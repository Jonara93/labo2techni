package be.technifutur.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.technifutur.dto.Genre;
import be.technifutur.dto.Type;
import be.technifutur.mapper.Mapper;

public class GenreService implements Crudable<Genre,Integer> {

	@Override
	public List selectAll(Connection c) throws SQLException {
		List<Genre> genreList = new ArrayList<Genre>();
		
		Statement statement = c.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT ge_id, ge_genre FROM public.genres;");
		while (resultSet.next()) {
			Genre g = Mapper.toDtoGenre(resultSet);
			genreList.add(g);
		}
		
		return genreList;
	}

	@Override
	public Genre selectByID(Connection c, Integer id) throws SQLException {
		Genre genre = null;
		
		String request = "SELECT ge_id, ge_genre FROM public.genres where ge_id=?;";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			genre = Mapper.toDtoGenre(resultSet);
		}
		return genre;
	}

	@Override
	public void insert(Connection c, Genre v) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Connection c, Genre v, Integer id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection c, Integer id) throws SQLException {
		// TODO Auto-generated method stub

	}

}
