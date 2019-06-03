package model.element.mobile;

import model.element.Permeability;
import model.element.Sprite;
/**
 * <h1>The EnnemyRandom Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */
public class EnnemyRandom extends Mobile{

	/** The Constant SPRITE. */
	private static final Sprite spriteEnnemyRandom = new Sprite('J', "EnnemyRandom.png");
    
    public EnnemyRandom() {
    	super(spriteEnnemyRandom, Permeability.BLOCKING);
	}

    
}
