package be.technifutur.servlets;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
import be.technifutur.dto.Personne;
import be.technifutur.services.PersonneService;
import be.technifutur.util.ConnexionPSQL;
import be.technifutur.util.LocalDateDeserializer;
import be.technifutur.util.LocalDateTimeDeserializer;
import be.technifutur.util.Util;

@WebServlet(name = "ApiPersonne", urlPatterns = { "/apiPers", "/apiPers/*" })
public class ApiPersonne extends HttpServlet {
	private final String HOST = "/GestionCollectionFilmSerie";
	private final PersonneService personneService = new PersonneService();
	String message;
	/*
	 * private static final Gson gson = new
	 * GsonBuilder().registerTypeAdapter(LocalDate.class, new
	 * JsonDeserializer<LocalDate>() {
	 * 
	 * @Override public LocalDate deserialize(JsonElement json, Type type,
	 * JsonDeserializationContext jsonDeserializationContext) throws
	 * JsonParseException { return
	 * LocalDate.parse(json.getAsJsonPrimitive().getAsString()); } }).create();
	 */
	private static final Gson gson = new GsonBuilder().setPrettyPrinting()
			.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
			.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer()).create();

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getRequestURI().split("/")[3]);
		try {
			personneService.delete(ConnexionPSQL.getInstance(), id);
			Util.formatResponse(resp, message = "La personne a été supprimée, ne regardez pas derrière-vous.");
		} catch (SQLException e) {
			message = e.getMessage();
		}
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Util.formatResponse(resp, "");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getRequestURI();
		String choice = pathInfo.equals(HOST + "/apiPers") ? "all" : "id";

		switch (choice) {
		case "all":
			try {
				List<Personne> pers = personneService.selectAll(ConnexionPSQL.getInstance());
				Util.formatResponse(resp, pers);
			} catch (SQLException e) {
				message = e.getMessage();
				Util.formatResponse(resp, message);
			}
			break;
		case "id":
			int id = Integer.parseInt(req.getRequestURI().split("/")[3]);
			try {
				Personne per = personneService.selectByID(ConnexionPSQL.getInstance(), id);
				Util.formatResponse(resp, per);
			} catch (SQLException e) {
				message = e.getMessage();
				Util.formatResponse(resp, message);
			}
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Personne per = gson.fromJson(req.getReader(), Personne.class);
		try {
			personneService.insert(ConnexionPSQL.getInstance(), per);
			Util.formatResponse(resp, per.toString());
		} catch (SQLException e) {
			Util.formatResponse(resp, e.getMessage());
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getRequestURI().split("/")[3]);
		Personne per = gson.fromJson(req.getReader(), Personne.class);
		try {
			personneService.update(ConnexionPSQL.getInstance(), per, id);
			Util.formatResponse(resp, per.toString());
		} catch (SQLException e) {
			Util.formatResponse(resp, e);
		}
	}

}
