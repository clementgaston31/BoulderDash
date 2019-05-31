package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import banal.Permeability;
import banal.Sprite;
import contract.model.IMap;

public class Ennemy extends Mobile{

	/** The Constant SPRITE. */
	private static final Sprite spriteEnnemy = new Sprite('E', "Ennemy.png");
	
	
	/** The Constant spriteMove. */
	private static final Sprite spriteMove = new Sprite('E', "EnnemyMove.png");
	
	/** The Constant spriteDie. */
	private static final Sprite spriteEnnemyDie = new Sprite('E', "EnnemyDie.png");
	
	public Ennemy(final int x, final int y, final IMap map) throws IOException {
        super(x, y, spriteEnnemy, map, Permeability.BLOCKING);
        spriteMove.loadImage();
        spriteEnnemyDie.loadImage();
    }
    
    public Ennemy() {
		super();
	}

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteMove);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteMove);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveUp()
     */
    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(spriteMove);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveDown()
     */
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spriteMove);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
    protected final void die() {
        super.die();
        this.setSprite(spriteEnnemyDie);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(spriteEnnemy);
    }
    
    @Override
	public Point getPosition() {
		return super.getPosition();
	}
	
}
