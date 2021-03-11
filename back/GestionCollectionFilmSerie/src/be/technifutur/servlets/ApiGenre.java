package be.technifutur.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technifutur.services.GenreService;
import be.technifutur.util.ConnexionPSQL;
import be.technifutur.util.Util;

@WebServlet(name = "ApiGenre", urlPatterns = { "/apiGenre" })
public class ApiGenre extends HttpServlet {
	GenreService genreService = new GenreService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Util.formatResponse(resp, genreService.selectAll(ConnexionPSQL.getInstance()));
		} catch (SQLException e) {
			Util.formatResponse(resp, e.getMessage());
		}
	}
	
}
