package model.element.mobile;
import model.element.Permeability;
import model.element.Sprite;

public class Rock extends Mobile {

	/** The Constant SPRITE. */
    private static final Sprite spriteRock = new Sprite('R', "Rock.png");
    
    
    
    /**
     * Instantiates a new diamond.
     */
    public Rock() {
        super(spriteRock, Permeability.BLOCKING);
        
    }

}
