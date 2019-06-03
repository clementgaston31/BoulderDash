package model.element.motionlessElement;

import model.element.Permeability;
import model.element.Sprite;

/**
 * <h1>The Background Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */

public class Background extends MotionlessElement {

	/** The Constant SPRITE. */
    private static final Sprite spriteBackground = new Sprite(' ', "Background.png");
    
    
    /**
     * Instantiates a new background.
     */
    public Background() {
        super(spriteBackground, Permeability.PENETRABLE);
    }
}
