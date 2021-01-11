package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	Connection cnx;
	
	
	public void init() {
		try {
			System.out.println("Creating Connection");
			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppedb?user=ppedbuser");
			System.out.println("OK");
		} catch (SQLException e) {
			System.out.println("Erreur !!!");
			e.printStackTrace();
		}

	}
}
