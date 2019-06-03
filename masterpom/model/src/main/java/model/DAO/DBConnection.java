package model.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * <h1>The Class DBConnection.</h1>
 * 
 * @author Clement GASTON
 * @version 0.1
 */
public class DBConnection {

	/** Instance is the connection to the database. */
	static DBConnection instance = null;
	
	/** Stock all the data needed to create a new connection to the database. */
	private Connection connection;

	/**
	 * Call the creation of a new connection to the database.
	 */
	DBConnection() {
		this.open();
	}

	/**
	 * Gets the instance.
	 * 
	 * @return instance
	 */
	public static synchronized DBConnection getInstance() {
		if (DBConnection.instance == null) {
			DBConnection.instance = new DBConnection();
		}
		return DBConnection.instance;
	}

	/**
	 * Gets the connection.
	 * 
	 * @return connection
	 */
	public Connection getConnection() {
		return this.connection;
	}

	/**
	 * Sets the connection.
	 * 
	 * @param connection
	 * 			The new connection.
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Open a new connection between eclipse and the database.
	 * 
	 * @return true
	 * 			If the connection didn't failed.
	 */
	private boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			setConnection(DriverManager.getConnection(dbProperties.getURL(), dbProperties.getLogin(),
					dbProperties.getPassword()));
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
