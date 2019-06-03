package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import model.DAO.DAOMap;
import model.DAO.DBConnection;
import model.element.mobile.IMobile;
import model.element.mobile.Player;

/**
 * <h1>The Model Class.</h1>
 * 
 * @author Clément GASTON
 * @version 0.1
 */
public final class Model extends Observable implements IModel {

	/** The map of the game. */
	private IMap map;
	
	/** The Player*/
	private IMobile player;
	
	/**
	 * Instantiates a new model.
	 * 
	 * @param idMap
	 * 			Give the idMap.
	 */
	public Model(int idMap) throws IOException, SQLException{
		final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
		this.setMap(daoMap.find(idMap));
		this.setPlayer(new Player(this.getMap().getPlayerStartX(), this.getMap().getPlayerStartY(), this.getMap()));
	}
	
	/**
	 * Gets the Map.
	 * 
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
	private void setMap(final IMap map) {
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


}
