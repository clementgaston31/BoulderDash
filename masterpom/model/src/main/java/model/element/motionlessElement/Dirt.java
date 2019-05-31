package model.element.motionlessElement;

import model.element.Permeability;
import model.element.Sprite;

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
