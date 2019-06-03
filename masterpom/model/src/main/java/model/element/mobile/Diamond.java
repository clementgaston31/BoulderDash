package model.element.mobile;
import model.element.Permeability;
import model.element.Sprite;

/**
 * <h1>The Diamond Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */

public class Diamond extends Mobile {
	
	/** The Constant SPRITE. */
    private static final Sprite spriteDiamond = new Sprite('*', "Diamond.png");
  
    /**
     * Instantiates a new diamond.
     */
    public Diamond() {
        super(spriteDiamond, Permeability.PICKABLE);
       
    }
	
}
