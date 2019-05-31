package model;

import java.io.IOException;
import java.util.Observable;

import banal.IMobile;
import contract.model.IMap;
import contract.model.IModel;

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
	Model(int idMap, int playerX, int playerY) throws IOException{
		this.setMap(new Map(idMap));
		//this.setPlayer(new Player(playerX, playerY, this.getMap()));
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
	private void setMap(IMap map) {
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
	private void setPlayer(IMobile player) {
		this.player = player;
	}
	
	/*public void updateMOdel() {
		
	}*/

}
