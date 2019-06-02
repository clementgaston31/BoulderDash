package model.element.mobile;



import contract.model.IGravity;
import model.element.Permeability;
import model.element.Sprite;

public class Rock extends Mobile implements IGravity{

	/** The Constant SPRITE. */
    private static final Sprite spriteRock = new Sprite('R', "Rock.png");
    private boolean falling = false;
    
    
    /**
     * Instantiates a new diamond.
     */
    public Rock() {
        super(spriteRock, Permeability.BLOCKING);
        this.setFalling(false);
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



	@Override
	public void movement() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Boolean isNotWin() {
		// TODO Auto-generated method stub
		return null;
	}

}
