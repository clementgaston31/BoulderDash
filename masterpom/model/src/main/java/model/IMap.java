package model;

import java.util.Observable;

import model.element.IElement;

/**
 * <h1>The Interface IMap.</h1>
 *
 * @author Clement GASTON Kevin BOURDEAU
 * @version 0.1
 */

public interface IMap {

	/**
	 * Gets the id of the map.
	 * 
	 * @return the idMap
	 */
	int getIdMap();

	/**
	 * Gets the number of diamond needed to finish the level.
	 * 
	 * @return diamondToGet
	 */
	int getDiamondToGet();
	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	int getWidth();

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	int getHeight();
	
	/**
	 * Gets the X of the player when the game start.
	 * 
	 * @return playerStartX
	 */
	public int getPlayerStartX();
	
	/**
	 * Gets the Y of the player when the game start.
	 * 
	 * @return playerStartX*Y
	 */
	public int getPlayerStartY();

	/**
	 * Gets the string map.
	 * 
	 * @return mapFromBDD
	 */
	String getMapFromBDD();

	/**
	 * Gets the current number of diamonds collected.
	 * 
	 * @return currentDiamondGot
	 */
	int getCurrentDiamondGot();
	
	/**
	 * Sets the number of the current diamond collected.
	 * 
	 * @param currentDiamondGot
	 * 			The new current of diamond got.
	 */
	void setCurrentDiamondGot(int currentDiamondGot);

	/**
	 * Gets the current map.
	 * 
	 * @return this
	 */
	public IMap getMap();

	/**
	 * Gets the on the map XY.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the on the map XY
	 */
	IElement getOnTheMapXY(int x, int y);
	
	/**
	 * Sets the coordinate on the map.
	 * 
	 * @param element The object to place.
	 * @param x       The new X of the object.
	 * @param y       The new Y of the object.
	 */
	void setOnTheMapXY(IElement element, int x, int y);

	/**
	 * Sets the mobile has changed.
	 */
	void setMobileHasChanged();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	/**
	 * Will add diamond each time you pick up one.
	 */
	void addDiamond();

	/**
	 * Sets if the player can play.
	 * 
	 * @param stillPlaying the stillPlaying
	 */
	void setStillPlaying(boolean stillPlaying);
	
	/**
	 * Gets if the player can still play.
	 * @return stillPlaying
	 */
	public Boolean getStillPlaying();
}
