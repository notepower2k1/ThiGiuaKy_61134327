package Bai3_61134327;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiDB {
	public static Connection KetNoi(String TenCSDL, String user, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String urlDB ="jdbc:mysql://localhost:3306/" + TenCSDL;
	    try {
		   return DriverManager.getConnection(urlDB, user, pass);
	    } catch (SQLException e1) {
			e1.printStackTrace();
	   }
	   return null; 
	}
}
