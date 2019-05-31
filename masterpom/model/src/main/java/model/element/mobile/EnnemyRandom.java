package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import banal.Permeability;
import banal.Sprite;
import contract.model.IMap;

public class EnnemyRandom extends Mobile{

	/** The Constant SPRITE. */
	private static final Sprite spriteEnnemyRandom = new Sprite('E', "EnnemyRandom.png");
	
	
	/** The Constant spriteMove. */
	private static final Sprite spriteMoveRandom = new Sprite('E', "EnnemyMoveRandom.png");
	
	/** The Constant spriteDie. */
	private static final Sprite spriteEnnemyDieRandom = new Sprite('E', "EnnemyDieRandom.png");
	
	public EnnemyRandom(final int x, final int y, final IMap map) throws IOException {
        super(x, y, spriteEnnemyRandom, map, Permeability.BLOCKING);
        spriteMoveRandom.loadImage();
        spriteEnnemyDieRandom.loadImage();
    }
    
    public EnnemyRandom() {
		super();
	}

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteMoveRandom);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteMoveRandom);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveUp()
     */
    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(spriteMoveRandom);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveDown()
     */
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spriteMoveRandom);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
    protected final void die() {
        super.die();
        this.setSprite(spriteEnnemyDieRandom);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(spriteEnnemyRandom);
    }
    
    @Override
	public Point getPosition() {
		return super.getPosition();
	}
}
