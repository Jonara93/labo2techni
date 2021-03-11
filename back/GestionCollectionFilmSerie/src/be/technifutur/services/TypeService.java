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

public class TypeService implements Crudable<Type,Integer> {

	@Override
	public List selectAll(Connection c) throws SQLException {
		List<Type> typeList = new ArrayList<Type>();
		
		Statement statement = c.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT ty_id, ty_type"
				+ "	FROM public.types");
		while(resultSet.next()) {
			Type t = Mapper.toDtoType(resultSet);
			typeList.add(t);
		}
		
		return typeList;
	}

	@Override
	public Type selectByID(Connection c, Integer id) throws SQLException {
		Type type = null;
		
		String request = "SELECT ty_id, ty_type FROM public.types where ty_id=?;";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			type = Mapper.toDtoType(resultSet);
		}
		return type;
	}

	@Override
	public void insert(Connection c, Type v) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection c, Type v, Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection c, Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	

}
