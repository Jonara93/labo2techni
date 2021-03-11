package be.technifutur.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.technifutur.dto.FilmsSeriePersonnesRoles;
import be.technifutur.dto.Personne;
import be.technifutur.mapper.Mapper;

public class PersInFSService implements Crudable<Personne, Integer> {

	@Override
	public List<Personne> selectAll(Connection c) throws SQLException {
		List<Personne> pers = null;
		return pers;
	}

	@Override
	public Personne selectByID(Connection c, Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Connection c, Personne v) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Connection c, Personne v, Integer id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection c, Integer id) throws SQLException {
		// TODO Auto-generated method stub

	}

	public List<Personne> selectAll(Connection c, Integer idFilm) throws SQLException {
		List<Personne> pers = new ArrayList<Personne>();
		String request = "select personnes.per_id,per_nom, per_prenom, per_genre,per_ddn,per_url, ro_nom "
				+ "from filmsseries " + "join filmsseries_personnes on filmsseries.fs_id = filmsseries_personnes.fs_id "
				+ "join personnes on filmsseries_personnes.per_id = personnes.per_id "
				+ "join roles on filmsseries_personnes.ro_id = roles.ro_id " + "where filmsseries.fs_id = ?";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setInt(1, idFilm);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Personne per = Mapper.toDtoPersonneInFS(resultSet);
			pers.add(per);
		}
		return pers;
	}

	public String insertIntoFilmPersWithRole(Connection c, FilmsSeriePersonnesRoles v) throws SQLException {
		String request = "INSERT INTO public.filmsseries_personnes(fs_id, per_id, ro_id) " + "VALUES (?, ?, ?);";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setInt(1, v.getFs_id());
		preparedStatement.setInt(2, v.getPer_id());
		preparedStatement.setInt(3, v.getRo_id());
		preparedStatement.executeQuery();

		return "Personne ajouté au film";
	}

	public String removeIntoFilmPersWithIsRole(Connection c, FilmsSeriePersonnesRoles v) throws SQLException {
		System.out.println(v);
		String request = "delete from filmsseries_personnes where fs_id=? and per_id = ? and ro_id = ?";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setInt(1, v.getFs_id());
		preparedStatement.setInt(2, v.getPer_id());
		preparedStatement.setInt(3, v.getRo_id());
		preparedStatement.executeQuery();

		return "Piou Piou tu es mort !";
	}
}
