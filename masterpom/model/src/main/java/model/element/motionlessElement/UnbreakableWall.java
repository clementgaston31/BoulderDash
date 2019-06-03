package model.element.motionlessElement;

import model.element.Permeability;
import model.element.Sprite;

/**
 * <h1>The UnbreakableWall Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */

public class UnbreakableWall extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite spriteUnbreakableWall = new Sprite('X', "UnbreakableWall.png");
    
    
    /**
     * Instantiates a new unbreakableWall.
     */
    UnbreakableWall() {
        super(spriteUnbreakableWall, Permeability.BLOCKING);
    }

}
