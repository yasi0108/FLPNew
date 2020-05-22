package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Datakobling {
	String databaseName;
	public Connection connection;

	public Datakobling() {
		databaseName = "FerrariDB";

		loadJdbcDriver();
		openConnection(databaseName);
	}

	public boolean loadJdbcDriver() {
		try {
			System.out.println("Loading JDBC driver...");

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			System.out.println("JDBC driver loaded");

			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load JDBC driver!");
			return false;
		}
	}

	public boolean openConnection(String databaseName) {
		try {
			String connectionString = "jdbc:sqlserver://localhost:1433;" + "instanceName=SQLEXPRESS;" + "databaseName="
					+ databaseName + ";" + "integratedSecurity=true;";

			connection = null;

			System.out.println("Connecting to database...");

			connection = DriverManager.getConnection(connectionString);

			System.out.println("Connected to database");

			return true;
		} catch (SQLException e) {
			System.out.println("Could not connect to database!");
			System.out.println(e.getMessage());

			return false;
		}
	}
}
