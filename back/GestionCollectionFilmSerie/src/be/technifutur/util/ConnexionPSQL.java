package be.technifutur.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionPSQL {
	/*
	 * FIELD
	 */
	private static String DBUrl = "jdbc:postgresql://localhost/techniLaboInt?useUnicode=true&characterEncoding=utf-8";
	private static String user = "postgres";
	private static String pwd = "123456a.";
	private static Connection instance;
	
	/*
	 * CONSTRUCTOR
	 */
	
	private ConnexionPSQL() {
	}
	
	/*
	 * METHOD
	 */
	public static Connection getInstance() throws SQLException {
		if (instance == null) {
			instance = DriverManager.getConnection(DBUrl,user,pwd);			
		}
		return instance;
	}
}
