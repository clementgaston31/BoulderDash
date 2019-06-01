package model.element.motionlessElement;

import model.element.Permeability;
import model.element.Sprite;

public class Background extends MotionlessElement {

	/** The Constant SPRITE. */
    private static final Sprite spriteBackground = new Sprite('B', "Background.png");
    
    
    /**
     * Instantiates a new background.
     */
    Background() {
        super(spriteBackground, Permeability.PENETRABLE);
    }
}
