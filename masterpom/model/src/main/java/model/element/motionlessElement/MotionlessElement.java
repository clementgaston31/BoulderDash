package model.element.motionlessElement;

import model.element.Element;
import model.element.Permeability;
import model.element.Sprite;

/**
 * <h1>The MotionlessElement Class.</h1>
 *
 * @author kevinBourdeau
 * @version 0.1
 */

public abstract class MotionlessElement extends Element {
	
	/**
     * Instantiates a new motionless element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    MotionlessElement(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }

}
