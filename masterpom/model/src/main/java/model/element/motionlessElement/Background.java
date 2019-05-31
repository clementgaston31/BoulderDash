package model.element.motionlessElement;

import banal.Permeability;
import banal.Sprite;

public class Background extends MotionlessElement {

	/** The Constant SPRITE. */
    private static final Sprite spriteBackground = new Sprite('B', "Background.jpg");
    
    
    /**
     * Instantiates a new background.
     */
    Background() {
        super(spriteBackground, Permeability.BLOCKING);
    }
}
