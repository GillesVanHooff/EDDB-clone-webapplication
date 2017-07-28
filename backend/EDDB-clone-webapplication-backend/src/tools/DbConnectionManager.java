package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Settings;
import model.StarSystem;

public class DbConnectionManager {
	private String JDBC_DRIVER;
	private String DB_URL;
	private String USER;
	private String PASS;

	private final Settings settings;

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

	/**
	 * Insert a star system into the database using preparedStatements
	 * 
	 * @param system
	 * 			The system object you want to store in the database.
	 */
	public void insertStarSystem(StarSystem system) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String sql = "INSERT INTO tbl_starsystems"
					+ "(system_identifier, name_starSystem, amount_StellarObjects_starSystem, id_system) VALUES"
					+ "(?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, system.getIdStarSystem());
			preparedStatement.setString(2, system.getNameStarSystem());
			preparedStatement.setInt(3, system.getAmountOfStellarObjects());
			preparedStatement.setString(4, null);
			preparedStatement.addBatch();
			preparedStatement.executeBatch();
			
			//preparedStatement .executeUpdate();
			
			System.out.println("System added to database: " + system);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	/**
	 * Deletes all the rows from a table.
	 * 
	 * @param tableName
	 * 			The desired table of which you want the rows deleted.
	 */
	public void deleteAllFromTable(String tableName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "DELETE FROM " + tableName;
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.executeUpdate();
			
			System.out.println("All system deleted from table: " + tableName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
