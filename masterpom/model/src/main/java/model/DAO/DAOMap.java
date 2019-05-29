package model.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DAO.Entity;
import model.Map;

public class DAOMap extends DAOElement{

	public DAOMap(Connection connection) throws SQLException {
		super(connection);
	}
	
	public boolean create(Entity entity) {
		// Not implemented
		return false;
	}
	
	public boolean delete(Entity entity) {
		// Not implemented
		return false;
	}
	
	public boolean update(Entity entity) {
		// Not implemented
		return false;
	}
	
	public Map find(int idMap) {
		Map map = null;
		try {
			final String sql = "{call MapById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, idMap);
			call.execute();
			ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				map = new Map(resultSet.getInt("idMap"), resultSet.getInt("width"), resultSet.getInt("height"), resultSet.getInt("playerStartX"), resultSet.getInt("playerStartY"), resultSet.getString("StringMap"));
			}
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
