package model.DAO;

import java.sql.SQLException;

import model.IMap;

import java.sql.Connection;

/**
 * <h1>The Abstract Class DAOElement.</h1>
 * 
 * @author Clement GASTON
 * @version 0.1
 */
abstract class DAOElement {

	/** Stock all the data needed to create a new connection to the database. */
	private final Connection connection;
	
	/**
	 * Sets a new connection.
	 * 
	 * @param connection
	 * 			Sets the new connection.
	 * @throws SQLException
	 * 			Signal that a SQL exception has occurred.
	 */
	public DAOElement(final Connection connection) throws SQLException{
		this.connection = connection;
	}
	
	/**
	 * Gets the connection.
	 * 
	 * @return connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}
	
	
	/**
	 * Search a specific map in the database then add it to a new Map.
	 * 
	 * 
	 * @return map
	 * 			Return all the corresponding information of the idMap if found.
	 * 
	 * @param iDMap the idMap
	 * 			Give the ID of the map searched in the database.
	 */
	public abstract IMap find (int iDMap);
}
