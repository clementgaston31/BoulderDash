package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import contract.model.IMap;
import model.element.Permeability;
import model.element.Sprite;


public class Player extends Mobile{
	
	/** The Constant SPRITE. */
	private static final Sprite sprite = new Sprite('P', "Player.png");

	/** The Constant spriteLeft. */
	private static final Sprite spriteLeft = new Sprite('P', "Left.png");

	/** The Constant spriteRight. */
	private static final Sprite spriteRight = new Sprite('P', "Right.png");

	/** The Constant spriteUp. */
	private static final Sprite spriteUp = new Sprite('P', "Up.png");

	/** The Constant spriteDown. */
	private static final Sprite spriteDown = new Sprite('P', "Down.png");

	/** The Constant spriteDie. */
	private static final Sprite spriteDie = new Sprite('P', "Die.png");

	/** Diamond count of the player */
	private int diamondCount = 0;
	
	/**
     * Instantiates a new my vehicle.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param map
     *            the map
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Player(final int x, final int y, final IMap map) throws IOException {
        super(x, y, sprite, map, Permeability.BLOCKING);
        spriteLeft.loadImage();
        spriteRight.loadImage();
        spriteDie.loadImage();
        spriteDown.loadImage();
        spriteUp.loadImage();
        
        this.diamondCount = 0;
    }
    
    public Player() {
		super();
	}

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteLeft);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteRight);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveUp()
     */
    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(spriteUp);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveDown()
     */
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spriteDown);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
    protected final void die() {
        super.die();
        this.setSprite(spriteDie);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
    
    /**
	 * Returns the diamond count of the player
	 * 
	 */
	public int getDiamondCount() {
		return diamondCount;
	}

	/**
	 * Sets the diamond count of the player (Usefull to reset it)
	 * 
	 * @param diamondCount
	 */
	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}

	/**
	 * Increases the diamond count of the player
	 * 
	 * @param score
	 */
	public void addDiamond(int diamond) {
		this.diamondCount += diamond;
	}
   
	@Override
	public Point getPosition() {
		return super.getPosition();
	}
}
