package be.technifutur.services;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import be.technifutur.dto.FilmSerie;
import be.technifutur.mapper.Mapper;
import be.technifutur.util.Util;

public class FilmService implements Crudable<FilmSerie, Integer> {

	@Override
	public List<FilmSerie> selectAll(Connection c) throws SQLException {
		List<FilmSerie> output = new ArrayList<FilmSerie>();

		Statement statement = c.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select filmsseries.fs_id,fs_nom, fs_synopsis,public.types.ty_id,ty_type,fs_date_sortie,genres.ge_id"
						+ ",ge_genre,fs_saison,fs_episode, fs_img "
						+ "from filmsseries join public.types on public.types.ty_id = filmsseries.ty_id "
						+ "join genres on genres.ge_id = filmsseries.ge_id " + "order by filmsseries.fs_nom");
		while (resultSet.next()) {
			FilmSerie fs = Mapper.toDtoFilmSerie(resultSet);
			output.add(fs);
		}
		return output;
	}

	@Override
	public FilmSerie selectByID(Connection c, Integer id) throws SQLException {
		FilmSerie fs = null;
		String request = "select filmsseries.fs_id,fs_nom, fs_synopsis,public.types.ty_id,ty_type,"
				+ "fs_date_sortie,genres.ge_id,ge_genre,fs_saison,fs_episode, fs_img "
				+ "from filmsseries join public.types on public.types.ty_id = filmsseries.ty_id "
				+ "join genres on genres.ge_id = filmsseries.ge_id " + "where filmsseries.fs_id = ?";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			fs = Mapper.toDtoFilmSerie(resultSet);
		}
		return fs;
	}

	@Override
	public void insert(Connection c, FilmSerie v) throws SQLException {
		String request = "INSERT INTO public.filmsseries("
				+ "fs_id, fs_nom, fs_synopsis, ty_id, fs_date_sortie, ge_id, fs_img, fs_saison, fs_episode, fs_creationdb, fs_modifdb)"
				+ "	VALUES (DEFAULT, ?, ?, ?, ?, ?,?, ?, ?, CURRENT_DATE, CURRENT_DATE);";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setString(1, v.getFs_nom());
		preparedStatement.setString(2, v.getFs_synopsis());
		preparedStatement.setInt(3, v.getTy_type().getTy_id());
		preparedStatement.setTimestamp(4, Timestamp.valueOf(v.getFs_date_sortie()));
		preparedStatement.setInt(5, v.getGe_genre().getGe_id());
		preparedStatement.setString(6, v.getFs_img());
		if (v.getTy_type().getTy_id() == 1) {
			preparedStatement.setInt(7, v.getFs_saison());
			preparedStatement.setInt(8, v.getFs_episode());
		} else {
			preparedStatement.setNull(7, 0);
			preparedStatement.setNull(8, 0);
		}

		preparedStatement.execute();

	}

	@Override
	public void update(Connection c, FilmSerie v, Integer id) throws SQLException {
		String request = "UPDATE " + "public.filmsseries SET "
				+ "fs_nom=?, fs_synopsis=?, fs_date_sortie=?, ge_id=?, fs_saison=?, fs_episode=?, fs_modifdb=CURRENT_DATE"
				+ " WHERE fs_id=?;";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setString(1, v.getFs_nom());
		preparedStatement.setString(2, v.getFs_synopsis());
		preparedStatement.setTimestamp(3, Timestamp.valueOf(v.getFs_date_sortie()));
		preparedStatement.setInt(4, v.getGe_genre().getGe_id());
		if (v.getTy_type().getTy_id() == 1) {
			preparedStatement.setInt(5, v.getFs_saison());
			preparedStatement.setInt(6, v.getFs_episode());
		} else {
			preparedStatement.setNull(5, 0);
			preparedStatement.setNull(6, 0);
		}
		preparedStatement.setInt(7, id);

		preparedStatement.execute();
	}

	@Override
	public void delete(Connection c, Integer id) throws SQLException {
		String request = "DELETE FROM public.filmsseries WHERE fs_id=?;";
		PreparedStatement preparedStatement = c.prepareStatement(request);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public void patchFilmSerie(Connection c, Map<?, ?> map, FilmSerie fs) throws SQLException {
		Class<?> classFs = fs.getClass();

		Iterator<?> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<?, ?> entry = (Entry<?, ?>) iterator.next();
			for (int i = 0; i < classFs.getDeclaredFields().length; i++) {
				if (classFs.getDeclaredFields()[i].toString().contains((CharSequence) entry.getKey())) {
					try {
						Field field = classFs.getDeclaredField((String) entry.getKey());
						field.setAccessible(true);
						if (entry.getValue() instanceof Double) {
							System.out.println("coucou");
							field.set(fs, (Integer) entry.getValue());
						} else {
							field.set(fs, entry.getValue());
						}
						// System.out.println(fs.toString());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
			String request = "update filmsseries set ";
			request += " where fs_id = ?";
			PreparedStatement preparedStatement = c.prepareStatement(request);
			preparedStatement.setInt(1, fs.getFs_id());
			// preparedStatement.executeQuery();
		}

	}

}
