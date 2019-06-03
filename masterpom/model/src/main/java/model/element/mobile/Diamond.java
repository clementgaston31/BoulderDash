package model.element.mobile;




import model.element.Permeability;
import model.element.Sprite;


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
