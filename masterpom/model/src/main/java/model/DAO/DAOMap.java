package model.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DAO.Entity;
import model.Map;

/**
 * <h1> The DAOMap Class. </h1>
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
	 * Not yet implemented
	 */
	public boolean create(Entity entity) {
		// Not implemented
		return false;
	}
	
	/**
	 * Not yet implemented
	 */
	public boolean delete(Entity entity) {
		// Not implemented
		return false;
	}
	
	/**
	 * Not yet implemented
	 */
	public boolean update(Entity entity) {
		// Not implemented
		return false;
	}
	
	/**
	 * Search a specific map in the database then add it to a new Map.
	 * 
	 * @param idMap
	 * 			Give the ID of the map searched in the database.
	 * @return map
	 * 			Return all the corresponding information of the idMap if found.
	 */
	public Map find(int idMap, Map map) {
		try {
			final String sql = "{call MapById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, idMap);
			call.execute();
			ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				System.out.println("Tkt j'te soutient frérot");
				map = new Map(resultSet.getInt("idMap"), resultSet.getInt("width"), resultSet.getInt("height"), resultSet.getInt("playerStartX"), resultSet.getInt("playerStartY"), resultSet.getString("StringMap"));
			}
			System.out.println(resultSet.getInt("width"));
			System.out.println("Yo " + map.getWidth());
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
