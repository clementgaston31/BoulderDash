package model.element.motionlessElement;

import banal.Permeability;
import banal.Sprite;

public class Dirt extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite spriteDirt = new Sprite('D', "Dirt.png");
    
    
    /**
     * Instantiates a new dirt.
     */
    Dirt() {
        super(spriteDirt, Permeability.DISAPPEAR);
    }

}
