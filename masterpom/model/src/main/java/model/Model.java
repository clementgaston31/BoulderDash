package model;

import java.io.IOException;
import java.util.Observable;

import contract.model.*;
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
	 */
	public Model(int idMap, Map map) throws IOException{
		this.setMap(new Map(idMap, map));
	    System.out.println("Pk ça marche pas " + this.getMap().getWidth());
		this.setPlayer(new Player(2, 2, this.getMap()));
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
	private void setMap(Map map) {
		this.map = map;
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
	@SuppressWarnings("unused")
	private void setPlayer(Player player) {
		this.player = player;
	}
	
	/*public void updateMOdel() {
		
	}*/

}
