package model.element.mobile;

import java.awt.Point;

import fr.exia.showboard.IPawn;
import model.element.IElement;

/**
 * <h1>The IMobile Interface.</h1>
 * 
 * @author kevinBourdeau
 * @version 0.1
 * 
 * @see IPawn
 * @see IElement
 *
 */

public interface IMobile extends IPawn, IElement {

	/**
	 * Move up
	 */

	void moveUp();

	/**
	 * Move down
	 */

	void moveDown();

	/**
	 * Move left
	 */

	void moveLeft();

	/**
	 * Move right
	 */

	void moveRight();
	
	void die();

	/**
	 * Do nothing
	 */

	void doNothing();


	/**
	 * Check if the mobile is alive
	 * @return the alive
	 */

	Boolean isAlive();

	/**
	 * Check if there is a dirt.
	 *
	 * @return the dirt
	 */

	Boolean isDirt();
	
	/**
	 * Check if objects have a blockable permeability
	 * 
	 * @return the blocked
	 */
	
	 Boolean isBlocked();

	/**
	 * (non-Javadoc)
	 * @see fr.exia.showboard.IPawn#getPosition()
	 */
	@Override
	Point getPosition();

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	@Override
	int getX();

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	@Override
	int getY();

	/**
	 * Check if is a diamond
	 * @return the diamond
	 */
	Boolean isDiamond();

	/**
	 * Check if is a rock
	 * @return the rock
	 */
	Boolean isPushable();
}
