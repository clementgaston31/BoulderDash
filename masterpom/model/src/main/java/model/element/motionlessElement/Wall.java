package model.element.motionlessElement;

import model.element.Permeability;
import model.element.Sprite;

/**
 * <h1>The Wall Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */

public class Wall extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite spriteWall = new Sprite('W', "Wall.png");
    
    
    /**
     * Instantiates a new wall.
     */
    Wall() {
        super(spriteWall, Permeability.BLOCKING);
    }

}
