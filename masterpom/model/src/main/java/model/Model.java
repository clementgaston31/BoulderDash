package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import model.DAO.DAOMap;
import model.DAO.DBConnection;
import model.element.mobile.IMobile;
import model.element.mobile.Player;

/**
 * <h1> The Model Class. </h1>
 * 
 * @author Clément GASTON
 * @version 0.1
 */
public final class Model extends Observable implements IModel {

	/** The map/grill of the game. */
	private IMap map;
	
	/** The Player*/
	private IMobile player;
	
	/** The map of the database made of characters. */
	String mapFromBDD;
	
	/** The number of the map in the database. */
	int idMap;
	
	/**
	 * Instantiates a new model.
	 * 
	 * @param idMap
	 * 			Sets a new map.
	 * @param playerX
	 * 			Gives the X position of the player.
	 * @param playerY
	 * 			Gives the Y position of the player.
	 * @throws IOException
	 * 			Signals that an I/O exception has occured.
	 * @throws SQLException 
	 */
	public Model(int idMap) throws IOException, SQLException{
		final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
		this.setMap(daoMap.find(idMap));
		this.setPlayer(new Player(this.getMap().getPlayerStartX(), this.getMap().getPlayerStartY(), this.getMap()));
	}
	
	/**
	 * Gets the Map.
	 * @return map
	 */
	public IMap getMap() {
		return this.map;
	}
	
	/**
	 * Sets a new Map.
	 * 
	 * @param map
	 * 			The new Map.
	 */
	public void setMap(final IMap map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Gets the Player.
	 * 
	 * @return player
	 */
	public IMobile getPlayer() {
		return this.player;
	}
	
	/**
	 * Sets the Player.
	 * 
	 * @param player
	 * 			The new player.
	 */
	
	private void setPlayer(Player player) {
		this.player = player;
	}
	
	/*public void updateMOdel() {
		
	}*/

}
