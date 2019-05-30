package model.element.mobile.gravity;

import java.io.IOException;

import banal.Permeability;
import banal.Sprite;
import contract.model.IMap;
import model.element.mobile.Mobile;

public class Diamond extends Mobile {
	
	/** The Constant SPRITE. */
    private static final Sprite spriteDiamond = new Sprite('*', "Diamond.jpg");
    
    
    /**
     * Instantiates a new diamond.
     */
    public Diamond(final int x, final int y, final IMap map) throws IOException {
        super(x, y, spriteDiamond, map, Permeability.BLOCKING);
        spriteDiamond.loadImage();
        
       
    }
    
    

    @Override
    public void doNothing() {
    	super.doNothing();
    	this.setSprite(spriteDiamond);
    }
    
    @Override
    public void moveDown() {
    	super.moveDown();
    	this.setSprite(spriteDiamond);
    }
}
