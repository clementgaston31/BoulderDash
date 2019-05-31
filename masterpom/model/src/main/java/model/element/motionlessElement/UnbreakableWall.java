package model.element.motionlessElement;

import banal.Permeability;
import banal.Sprite;

public class UnbreakableWall extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite spriteUnbreakableWall = new Sprite('X', "UnbreakableWall.jpg");
    
    
    /**
     * Instantiates a new unbreakableWall.
     */
    UnbreakableWall() {
        super(spriteUnbreakableWall, Permeability.BLOCKING);
    }

}
