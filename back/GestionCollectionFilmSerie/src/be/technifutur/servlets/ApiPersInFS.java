package be.technifutur.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import be.technifutur.dto.FilmsSeriePersonnesRoles;
import be.technifutur.services.PersInFSService;
import be.technifutur.util.ConnexionPSQL;
import be.technifutur.util.LocalDateDeserializer;
import be.technifutur.util.LocalDateTimeDeserializer;
import be.technifutur.util.Util;

@WebServlet(name = "ApiPersInFS", urlPatterns = { "/apiFilms/pers/*" })
public class ApiPersInFS extends HttpServlet {
	private static final Gson gson = new GsonBuilder().setPrettyPrinting()
			.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
			.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer()).create();
	private final String HOST = "/GestionCollectionFilmSerie";
	private final PersInFSService persInFSService = new PersInFSService();
	String message;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idFilm = Integer.parseInt(req.getRequestURI().split("/")[4]);
		try {
			Util.formatResponse(resp, persInFSService.selectAll(ConnexionPSQL.getInstance(), idFilm));
		} catch (SQLException e) {
			Util.formatResponse(resp, e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FilmsSeriePersonnesRoles persToAdd = gson.fromJson(req.getReader(), FilmsSeriePersonnesRoles.class);
		try {
			Util.formatResponse(resp, persInFSService.insertIntoFilmPersWithRole(ConnexionPSQL.getInstance(), persToAdd));
		} catch (Exception e) {
			Util.formatResponse(resp, e.getMessage());
		}
	}
	
	

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FilmsSeriePersonnesRoles persToRemove = gson.fromJson(req.getReader(), FilmsSeriePersonnesRoles.class);
		try {
			Util.formatResponse(resp, persInFSService.removeIntoFilmPersWithIsRole(ConnexionPSQL.getInstance(), persToRemove));
		} catch (IOException | SQLException e) {
			Util.formatResponse(resp, e.getMessage());
		}
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Util.formatResponse(resp, "");
	}

}
