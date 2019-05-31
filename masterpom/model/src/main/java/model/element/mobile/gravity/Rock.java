package model.element.mobile.gravity;

import java.io.IOException;

import contract.model.IGravity;
import contract.model.IMap;
import model.element.Permeability;
import model.element.Sprite;
import model.element.mobile.Mobile;

public class Rock extends Mobile implements IGravity{

	/** The Constant SPRITE. */
    private static final Sprite spriteRock = new Sprite('R', "Rock.jpg");
    
    private boolean falling = false;
    
    
    /**
     * Instantiates a new diamond.
     */
    public Rock(final int x, final int y, final IMap map) throws IOException {
        super(x, y, spriteRock, map, Permeability.BLOCKING);
        spriteRock.loadImage();
        this.setFalling(false);
    }
    
    public Rock() {
		super();
	}
    
    

    @Override
    public void doNothing() {
    	super.doNothing();
    	this.setSprite(spriteRock);
    }
    
    @Override
    public void moveDown() {
    	super.moveDown();
    	this.setSprite(spriteRock);
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
