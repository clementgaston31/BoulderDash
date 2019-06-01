package model.DAO;

import java.sql.SQLException;
import java.sql.Connection;

import model.DAO.Entity;
import model.IMap;
import model.Map;

/**
 * <h1> The DAOElement abstract Class. </h1>
 * 
 * @author Clément GASTON
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
	 * Not yet implemented
	 */
	public abstract boolean create(Entity entity);
	
	/**
	 * Not yet implemented
	 */
	public abstract boolean delete(Entity entity);
	
	/**
	 * Not yet implemented
	 */
	public abstract boolean update(Entity entity);
	
	/**
	 * Search a specific map in the database then add it to a new Map.
	 * 
	 * @param idMap
	 * 			Give the ID of the map searched in the database.
	 * @return map
	 * 			Return all the corresponding information of the idMap if found.
	 */
	public abstract IMap find (int iDMap);
}
