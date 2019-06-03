package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;
import model.element.motionlessElement.MotionlessElementFactory;


public class Player extends Mobile implements IMobile{
	
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

	/** Going to be deleted I think */
	public int Diamond = 0;

	/** Number of diamond to get (GOING TO BE DELETED) */
	public int DiamondToGet = 3;
	
	/** Set true if we win (GOING TO BE DELETED) */
	public boolean win = false;
	
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
        spriteLeft.loadImage(this.getMap().getIdMap());
        spriteRight.loadImage(this.getMap().getIdMap());
        spriteDie.loadImage(this.getMap().getIdMap());
        spriteDown.loadImage(this.getMap().getIdMap());
        spriteUp.loadImage(this.getMap().getIdMap());
        
        this.Diamond = 0;
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
        this.removeTheDirt();
        this.pickDiamond();
        this.setSprite(spriteLeft);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.removeTheDirt();
        this.pickDiamond();
        this.setSprite(spriteRight);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveUp()
     */
    @Override
    public final void moveUp() {
        super.moveUp();
        this.removeTheDirt();
        this.pickDiamond();
        this.setSprite(spriteUp);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveDown()
     */
    @Override
    public final void moveDown() {
        super.moveDown();
        this.removeTheDirt();
        this.pickDiamond();
        this.setSprite(spriteDown);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
	public final void die() {
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
    
    public void removeTheDirt() {
    	if (this.isDirt() == true) {
			this.getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(),
					this.getX(), this.getY());
		}
    	
    }
    
    public void pickDiamond() {
    	if (this.isDiamond() == true) {
			this.getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(),
					this.getX(), this.getY());
			/*Diamond = Diamond + 1;*/

		}
    }
    
  /* public void playerWin() {
    	if (Diamond >= DiamondToGet && this.getMap()
				.getOnTheMapXY(this.getX(), this.getY())
				.getPermeability() == Permeability.WIN) {
			win = true;
			
		}
    }*/
    
   
	@Override
	public Point getPosition() {
		return super.getPosition();
	}

	@Override
	public Boolean isNotWin() {
		// TODO Auto-generated method stub
		return null;
	}
}
