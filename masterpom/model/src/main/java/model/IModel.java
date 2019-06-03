package model;

import model.element.mobile.IMobile;

/**
 * <h1>The Interface IModel.</h1>
 * 
 * @author Clément GASTON & Kévin BOURDEAU
 * @version 0.1
 */
public interface IModel {

	/**
	 * Gets the Map.
	 * 
	 * @return map
	 */
	IMap getMap();
	
	/**
	 * Gets the Player.
	 * 
	 * @return player
	 */
	IMobile getPlayer();

}