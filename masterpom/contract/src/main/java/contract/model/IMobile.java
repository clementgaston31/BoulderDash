package contract.model;

import java.awt.Point;

import fr.exia.showboard.IPawn;

/**
 * 
 * @author kevinBourdeau
 * @version 0.1
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
	 * Checks if he is on a dirt block.
	 *
	 * @return the alive
	 */

	Boolean isDirt();

	/**
	 * Checks if rockford killed.
	 *
	 * @return the boolean
	 */
	Boolean isKilled();

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
}
