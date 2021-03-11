package be.technifutur.servlets;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import be.technifutur.dto.FilmSerie;
import be.technifutur.dto.FilmsSeriePersonnesRoles;
import be.technifutur.services.FilmService;
import be.technifutur.util.ConnexionPSQL;
import be.technifutur.util.LocalDateDeserializer;
import be.technifutur.util.LocalDateTimeDeserializer;
import be.technifutur.util.ServletConfig;
import be.technifutur.util.Util;

@WebServlet(name = "ApiFilms", urlPatterns = { "/apiFilms", "/apiFilms/*" })
public class ApiFilms extends HttpServlet {

	private final String HOST = "/GestionCollectionFilmSerie";
	private final FilmService filmService = new FilmService();
	String message;
	private static final Gson gson = new GsonBuilder().setPrettyPrinting()
			.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
			.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer()).create();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getRequestURI();
		String choice = pathInfo.equals(HOST + "/apiFilms") ? "all" : "id";

		switch (choice) {
		case "all":
			try {
				List<FilmSerie> medias = filmService.selectAll(ConnexionPSQL.getInstance());
				Util.formatResponse(resp, medias);
			} catch (SQLException e) {
				message = e.getMessage();
				Util.formatResponse(resp, message);
			}
			break;
		case "id":
			int id = Integer.parseInt(req.getRequestURI().split("/")[3]);
			try {
				FilmSerie fs = filmService.selectByID(ConnexionPSQL.getInstance(), id);
				Util.formatResponse(resp, fs);
			} catch (SQLException e) {
				message = e.getMessage();
				Util.formatResponse(resp, message);
			}
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FilmSerie fsToAdd = gson.fromJson(req.getReader(), FilmSerie.class);
		try {
			filmService.insert(ConnexionPSQL.getInstance(), fsToAdd);
			Util.formatResponse(resp, message = "Le média à bien été ajouté à la DB");
		} catch (SQLException e) {
			message = e.getMessage();
			Util.formatResponse(resp, message);
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getRequestURI().split("/")[3]);
		FilmSerie fsToPut = gson.fromJson(req.getReader(), FilmSerie.class);
		try {
			filmService.update(ConnexionPSQL.getInstance(), fsToPut, id);
			Util.formatResponse(resp, message = "Le film ou la série a bien été modifié");
		} catch (SQLException e) {
			message = e.getMessage();
			Util.formatResponse(resp, message);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getRequestURI().split("/")[3]);
		try {
			filmService.delete(ConnexionPSQL.getInstance(), id);
			Util.formatResponse(resp, message = "Le média a bien été supprimé.");
		} catch (SQLException e) {
			message = e.getMessage();
			Util.formatResponse(resp, message);
		}
	}
	
	

	public void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getRequestURI().split("/")[3]);
		Map<?,?> map = gson.fromJson(req.getReader(), Map.class);
		try {
			FilmSerie fs = filmService.selectByID(ConnexionPSQL.getInstance(), id);
			filmService.patchFilmSerie(ConnexionPSQL.getInstance(), map, fs);
			Util.formatResponse(resp, fs);
		} catch (Exception e) {
			Util.formatResponse(resp, e.getMessage());
		}
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Util.formatResponse(resp, message = "");
	}

	

}
