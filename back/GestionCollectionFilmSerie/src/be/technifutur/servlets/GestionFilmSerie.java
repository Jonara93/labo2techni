package be.technifutur.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technifutur.dto.FilmSerie;
import be.technifutur.dto.Genre;
import be.technifutur.dto.Type;
import be.technifutur.services.FilmService;
import be.technifutur.services.GenreService;
import be.technifutur.services.TypeService;
import be.technifutur.util.ConnexionPSQL;

@WebServlet(name = "GestionFilmSerie", urlPatterns = { "/films", "/films/create", "/films/detail/*", "/films/delete/*",
		"/films/update/*" })
public class GestionFilmSerie extends HttpServlet {
	private final String HOST = "/GestionCollectionFilmSerie";
	private final FilmService filmService = new FilmService();
	private final TypeService typeService = new TypeService();
	private final GenreService genreService = new GenreService();
	String choice;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getRequestURI();
		choice = pathInfo.equals(HOST + "/films") ? "films" : pathInfo.split("/")[3];
		String[] parts;
		int id;

		switch (choice) {
		case "films":
			try {
				req.setAttribute("medias", filmService.selectAll(ConnexionPSQL.getInstance()));
			} catch (SQLException e) {
				req.setAttribute("messages", e.getMessage());
			} finally {
				this.getServletContext().getRequestDispatcher("/WEB-INF/afficheFilm.jsp").forward(req, resp);
			}
			break;
		case "create":
			try {
				req.setAttribute("types", typeService.selectAll(ConnexionPSQL.getInstance()));
				req.setAttribute("genres", genreService.selectAll(ConnexionPSQL.getInstance()));
			} catch (SQLException e) {
				req.setAttribute("messages", e.getMessage());
			} finally {
				this.getServletContext().getRequestDispatcher("/WEB-INF/create.jsp").forward(req, resp);
			}
			break;
		case "detail":
			parts = pathInfo.split("/");
			id = Integer.parseInt(parts[4]);
			try {
				req.setAttribute("media", filmService.selectByID(ConnexionPSQL.getInstance(), id));
			} catch (SQLException e) {
				req.setAttribute("messages", e.getMessage());
			} finally {
				this.getServletContext().getRequestDispatcher("/WEB-INF/detail.jsp").forward(req, resp);
			}
			break;
		case "delete":
			parts = pathInfo.split("/");
			id = Integer.parseInt(parts[4]);
			try {
				filmService.delete(ConnexionPSQL.getInstance(), id);
			} catch (SQLException e) {
				req.setAttribute("messages", e.getMessage());
			} finally {
				resp.sendRedirect(HOST + "/films");
			}
			break;
		case "update":
			parts = pathInfo.split("/");
			id = Integer.parseInt(parts[4]);
			try {
				req.setAttribute("types", typeService.selectAll(ConnexionPSQL.getInstance()));
				req.setAttribute("genres", genreService.selectAll(ConnexionPSQL.getInstance()));
				req.setAttribute("media", filmService.selectByID(ConnexionPSQL.getInstance(), id));
			} catch (SQLException e) {
				req.setAttribute("messages", e.getMessage());
			} finally {
				this.getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
			}
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fs_nom;
		String fs_synopsis;
		Integer fs_genre;
		Integer fs_type;
		Integer fs_episode;
		Integer fs_saison;
		LocalDateTime fs_date_sortie;

		String pathInfo = req.getRequestURI();
		choice = pathInfo.split("/")[3];

		switch (choice) {
		case "create":
			fs_nom = req.getParameter("fs_nom");
			fs_synopsis = req.getParameter("fs_synopsis");
			fs_genre = Integer.parseInt(req.getParameter("fs_genre"));
			fs_type = Integer.parseInt(req.getParameter("fs_type"));
			fs_episode = Integer.parseInt(req.getParameter("fs_episode"));
			fs_saison = Integer.parseInt(req.getParameter("fs_saison"));
			fs_date_sortie = LocalDateTime.parse(req.getParameter("fs_date") + "T00:00:00");
			try {
				Type type = typeService.selectByID(ConnexionPSQL.getInstance(), fs_type);
				Genre genre = genreService.selectByID(ConnexionPSQL.getInstance(), fs_genre);
				filmService.insert(ConnexionPSQL.getInstance(),
						new FilmSerie(fs_nom, fs_synopsis, type, fs_date_sortie, genre, fs_saison, fs_episode));
			} catch (SQLException e) {
				req.setAttribute("messages", e.getMessage());
			} finally {
				resp.sendRedirect(HOST + "/films");
			}
			break;
		case "update":
			Integer fs_id = Integer.parseInt(req.getParameter("fs_id"));
			fs_nom = req.getParameter("fs_nom");
			fs_synopsis = req.getParameter("fs_synopsis");
			fs_genre = Integer.parseInt(req.getParameter("fs_genre"));
			fs_type = Integer.parseInt(req.getParameter("fs_type"));
			fs_episode = Integer.parseInt(req.getParameter("fs_episode"));
			fs_saison = Integer.parseInt(req.getParameter("fs_saison"));
			fs_date_sortie = LocalDateTime.parse(req.getParameter("fs_date") + "T00:00:00");
			try {
				Type type = typeService.selectByID(ConnexionPSQL.getInstance(), fs_type);
				Genre genre = genreService.selectByID(ConnexionPSQL.getInstance(), fs_genre);
				filmService.update(ConnexionPSQL.getInstance(),
						new FilmSerie(fs_nom, fs_synopsis, type, fs_date_sortie, genre, fs_saison, fs_episode),fs_id);
			} catch (SQLException e) {
				req.setAttribute("messages", e.getMessage());
			} finally {
				resp.sendRedirect(HOST + "/films");
			}
			break;
		}

	}

}
