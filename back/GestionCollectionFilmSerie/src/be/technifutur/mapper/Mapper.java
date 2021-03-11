package be.technifutur.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import be.technifutur.dto.FilmSerie;
import be.technifutur.dto.Genre;
import be.technifutur.dto.GenrePers;
import be.technifutur.dto.Personne;
import be.technifutur.dto.Type;

public class Mapper {

	/*
	 * METHOD
	 */

	public static FilmSerie toDtoFilmSerie(ResultSet resultSet) throws SQLException {
		FilmSerie fs = null;

		Integer fs_id = resultSet.getInt("fs_id");
		String fs_nom = resultSet.getString("fs_nom");
		String fs_synopsis = resultSet.getString("fs_synopsis");
		Type fs_type = new Type(resultSet.getInt("ty_id"), resultSet.getString("ty_type"));
		LocalDateTime fs_date_sortie = resultSet.getTimestamp("fs_date_sortie").toLocalDateTime();
		Genre ge_genre = new Genre(resultSet.getInt("ge_id"), resultSet.getString("ge_genre"));
		String fs_img = resultSet.getString("fs_img");
		if (fs_type.getTy_type().equalsIgnoreCase("serie")) {
			Integer fs_saison = resultSet.getInt("fs_saison");
			Integer fs_episode = resultSet.getInt("fs_episode");
			fs = new FilmSerie(fs_id, fs_nom, fs_synopsis, fs_type, fs_date_sortie, ge_genre, fs_saison, fs_episode,
					fs_img);
		} else {
			fs = new FilmSerie(fs_id, fs_nom, fs_synopsis, fs_type, fs_date_sortie, ge_genre, fs_img);
		}
		return fs;
	}

	public static Type toDtoType(ResultSet resultSet) throws SQLException {
		Type type = null;

		Integer ty_id = resultSet.getInt("ty_id");
		String ty_type = resultSet.getString("ty_type");

		type = new Type(ty_id, ty_type);
		return type;
	}

	public static Genre toDtoGenre(ResultSet resultSet) throws SQLException {
		Genre genre = null;

		Integer ge_id = resultSet.getInt("ge_id");
		String ge_genre = resultSet.getString("ge_genre");

		genre = new Genre(ge_id, ge_genre);

		return genre;
	}

	public static Personne toDtoPersonne(ResultSet resultSet) throws SQLException {
		Personne per = null;
		Integer per_id = resultSet.getInt("per_id");
		String per_nom = resultSet.getString("per_nom");
		String per_prenom = resultSet.getString("per_prenom");
		GenrePers per_genre = GenrePers.valueOf(resultSet.getString("per_genre"));
		LocalDate per_ddn = resultSet.getTimestamp("per_ddn").toLocalDateTime().toLocalDate();
		String per_url = resultSet.getString("per_url");

		per = new Personne(per_id, per_nom, per_prenom, per_genre, per_ddn, per_url);

		return per;
	}

	public static Personne toDtoPersonneInFS(ResultSet resultSet) throws SQLException {
		Personne per = null;
		Integer per_id = resultSet.getInt("per_id");
		String per_nom = resultSet.getString("per_nom");
		String per_prenom = resultSet.getString("per_prenom");
		GenrePers per_genre = GenrePers.valueOf(resultSet.getString("per_genre"));
		LocalDate per_ddn = resultSet.getTimestamp("per_ddn").toLocalDateTime().toLocalDate();
		String per_url = resultSet.getString("per_url");
		String per_role = resultSet.getString("ro_nom");
		per = new Personne(per_id, per_nom, per_prenom, per_genre, per_ddn, per_url, per_role);
		return per;
	}

}
