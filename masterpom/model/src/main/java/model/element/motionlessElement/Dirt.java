package model.element.motionlessElement;

import model.element.Permeability;
import model.element.Sprite;

/**
 * <h1>The Dirt Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */

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
