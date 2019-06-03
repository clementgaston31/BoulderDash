package model.DAO;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.IMap;
import model.Map;

/**
 * <h1>The Class DAOMap.</h1>
 * 
 * @author Clément GASTON
 * @version 0.1
 */
public class DAOMap extends DAOElement{

	/**
	 * Sets a connection.
	 * 
	 * @param connection
	 * 			The new connection.
	 * @throws SQLException
	 * 			Signal that a SQL exception has occurred.
	 */
	public DAOMap(Connection connection) throws SQLException {
		super(connection);
	}
	
	/**
	 * Search a specific map in the database then add it to a new Map.
	 * 
	 * @param idMap
	 * 			Give the ID of the map searched in the database.
	 * @return map
	 * 			Return all the corresponding information of the idMap if found.
	 */
	public IMap find(int idMap) {
		try {
			IMap map = null;
			final String sql = "{call MapById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, idMap);
			call.execute();
			ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				try {
					map = new Map(resultSet.getInt("idMap"), resultSet.getInt("DiamondToGet"), resultSet.getInt("width"), resultSet.getInt("height"), resultSet.getInt("playerStartX"), resultSet.getInt("playerStartY"), resultSet.getString("StringMap"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
