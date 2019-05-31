package model.element.motionlessElement;

import model.element.Permeability;
import model.element.Sprite;

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
