package model.element.mobile.gravity;

import java.io.IOException;

import contract.model.IGravity;
import contract.model.IMap;
import model.element.Permeability;
import model.element.Sprite;
import model.element.mobile.Mobile;

public class Diamond extends Mobile implements IGravity{
	
	/** The Constant SPRITE. */
    private static final Sprite spriteDiamond = new Sprite('*', "Diamond.jpg");
    
    private boolean falling = false;
    
    
    /**
     * Instantiates a new diamond.
     */
    public Diamond(final int x, final int y, final IMap map) throws IOException {
        super(x, y, spriteDiamond, map, Permeability.BLOCKING);
        spriteDiamond.loadImage();
        this.setFalling(false);
    }
    
    public Diamond() {
		super();
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



	@Override
	public boolean isFalling() {
		return this.falling;
	}



	@Override
	public void setFalling(boolean falling) {
		this.falling = falling;
		
	}
}
