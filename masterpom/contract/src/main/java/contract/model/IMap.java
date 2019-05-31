package contract.model;

import java.util.Observable;


/**
 * <h1>The Interface IMap.</h1>
 *
 * @author kevinBourdeau
 * @version 0.1
 */

public interface IMap {

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
	 * Gets the on the map XY.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return the on the map XY
	 */
	IElement getOnTheMapXY(int x, int y);

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
	 * At each game case, apply physics on the map
	 * 
	 */
	void updateMap();
	
	public int getPlayerStartY();
	
	public int getPlayerStartX();
	
}
