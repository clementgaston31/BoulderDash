package model.element.motionlessElement;

import banal.Permeability;
import banal.Sprite;

public class Door extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite spriteDoor = new Sprite('O', "Door.jpg");
    
    
    /**
     * Instantiates a new door.
     */
    Door() {
        super(spriteDoor, Permeability.PENETRABLE);
    }

}
