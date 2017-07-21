package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Settings;

public class DbConnectionManager {
	private String JDBC_DRIVER;
	private String DB_URL;
	private String USER;
	private String PASS;

	private Connection connection = null;
	private Settings settings;

	public DbConnectionManager(Settings settings) {
		this.settings = settings;

		this.JDBC_DRIVER = settings.getDbDriver();
		this.DB_URL = settings.getDbUrl();
		this.USER = settings.getDbUsername();
		this.PASS = settings.getDbPassword();

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(this.getClass() + " succesfully instantiated.");
	}

	public void insertIntoDb() {
		try {
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
