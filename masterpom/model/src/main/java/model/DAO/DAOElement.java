package model.DAO;

import java.sql.SQLException;
import java.sql.Connection;

import model.DAO.Entity;
import model.Map;

abstract class DAOElement {

	private final Connection connection;
	
	public DAOElement(final Connection connection) throws SQLException{
		this.connection = connection;
	}
	
	protected Connection getConnection() {
		return this.connection;
	}
	
	public abstract boolean create(Entity entity);
	
	public abstract boolean delete(Entity entity);
	
	public abstract boolean update(Entity entity);
	
	public abstract Map find (int iDMap);
}
