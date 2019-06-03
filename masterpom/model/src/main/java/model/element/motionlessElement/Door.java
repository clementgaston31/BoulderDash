package model.element.motionlessElement;

import model.element.Permeability;
import model.element.Sprite;

/**
 * <h1>The Door Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */

public class Door extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite spriteDoor = new Sprite('O', "Door.png");
    
    
    /**
     * Instantiates a new door.
     */
    Door() {
        super(spriteDoor, Permeability.WIN);
    }

}
