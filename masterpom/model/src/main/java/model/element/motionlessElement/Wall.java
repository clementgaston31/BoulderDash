package model.element.motionlessElement;

import banal.Permeability;
import banal.Sprite;

public class Wall extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite spriteWall = new Sprite('W', "Wall.jpg");
    
    
    /**
     * Instantiates a new wall.
     */
    Wall() {
        super(spriteWall, Permeability.BLOCKING);
    }

}
