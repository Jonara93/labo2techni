package be.technifutur.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import be.technifutur.dto.FilmSerie;
import be.technifutur.dto.GenrePers;
import be.technifutur.dto.Personne;
import be.technifutur.mapper.Mapper;

public class PersonneService implements Crudable<Personne, Integer> {

	@Override
	public List<Personne> selectAll(Connection c) throws SQLException {
		List<Personne> pers = new ArrayList<Personne>();
		Statement statement = c.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from personnes order by per_id");
		while (resultSet.next()) {
			Personne per = Mapper.toDtoPersonne(resultSet);
			pers.add(per);
		}
		return pers;
	}

	@Override
	public Personne selectByID(Connection c, Integer id) throws SQLException {
		Personne per = null;
		String request = "select * from personnes where per_id=?";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			per = Mapper.toDtoPersonne(resultSet);
		}
		return per;
	}

	@Override
	public void insert(Connection c, Personne v) throws SQLException {
		String request = "INSERT INTO public.personnes(per_nom, per_prenom, per_genre, per_ddn, per_url)"
				+ "	VALUES (?, ?, cast (? as genrepers), ?, ?);";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setString(1, v.getPer_nom());
		preparedStatement.setString(2, v.getPer_prenom());
		preparedStatement.setString(3, v.getPer_genre().toString());
		preparedStatement.setDate(4, Date.valueOf(v.getPer_ddn()));
		preparedStatement.setString(5, v.getPer_url());
		preparedStatement.executeQuery();
	}

	@Override
	public void update(Connection c, Personne v, Integer id) throws SQLException {
		String request = "UPDATE public.personnes "
				+ "SET per_id=?, per_nom=?, per_prenom=?, per_genre= cast (? as genrepers), per_ddn=?, per_url=? " + "WHERE per_id=?;";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, v.getPer_nom());
		preparedStatement.setString(3, v.getPer_prenom());
		preparedStatement.setString(4, v.getPer_genre().toString());
		preparedStatement.setDate(5, Date.valueOf(v.getPer_ddn()));
		preparedStatement.setString(6, v.getPer_url());
		preparedStatement.setInt(7, id);
		preparedStatement.executeQuery();
	}

	@Override
	public void delete(Connection c, Integer id) throws SQLException {
		String request = "DELETE FROM public.personnes WHERE per_id=?;";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

}
