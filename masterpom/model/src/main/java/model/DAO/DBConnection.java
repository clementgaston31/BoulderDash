package model.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnection {

	static DBConnection instance = null;
	private Connection connection;
	
	DBConnection() {
		this.open();
	}
	
	public static synchronized DBConnection getInstance() {
		if (DBConnection.instance == null) {
			DBConnection.instance = new DBConnection();
		}
		return DBConnection.instance;
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	private boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			setConnection(DriverManager.getConnection(dbProperties.getURL(), dbProperties.getLogin(), dbProperties.getPassword()));
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
