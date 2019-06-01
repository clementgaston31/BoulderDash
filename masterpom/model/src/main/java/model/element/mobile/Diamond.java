package model.element.mobile;



import contract.model.IGravity;
import model.element.Permeability;
import model.element.Sprite;

public class Diamond extends Mobile implements IGravity{
	
	/** The Constant SPRITE. */
    private static final Sprite spriteDiamond = new Sprite('*', "Diamond.png");
    
    private boolean falling = false;
    
    
    /**
     * Instantiates a new diamond.
     */
    public Diamond() {
        super(spriteDiamond, Permeability.DISAPPEAR);
        this.setFalling(false);
       
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
