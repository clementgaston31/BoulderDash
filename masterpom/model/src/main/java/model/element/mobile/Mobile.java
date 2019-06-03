package model.element.mobile;

import java.awt.Point;

import fr.exia.showboard.IBoard;
import model.IMap;
import model.element.Element;
import model.element.Permeability;
import model.element.Sprite;

/**
 * <h1>The Mobile Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */

public abstract class Mobile extends Element implements IMobile{

	/**
	 * The x.
	 */
	private Point   position;

	/** The alive. */
	private Boolean alive = true;

	/** The road. */
	private IMap map;

	/** The board. */
	private IBoard  board;
	
	/* The ennemy */
	private Ennemy ennemy;
	
	/* The moved */
	private Boolean moved = false;

	/**
	 * Instantiates a new mobile.
	 *
	 * @param sprite
	 *            the sprite
	 * @param map
	 *            the map
	 * @param permeability
	 *            the permeability
	 */
	public Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
		this.position = new Point();
	}
	
	/**
     * Instantiates a new mobile.
     */
	public Mobile() {
		super();
	}

	/**
	 * Instantiates a new mobile.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param sprite
	 *            the sprite
	 * @param map
	 *            the map
	 * @param permeability
	 *            the permeability
	 */
	public Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
		this(sprite, map, permeability);
		this.setX(x);
		this.setY(y);
	}
	
	/**
     * Instantiates a new mobile element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    Mobile(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }

	/**
	 * Move up the mobile and say he has moved
	 * 
	 * @see model.element.mobile.IMobile#moveUp()
	 */
	@Override
	public void moveUp() {
		this.setY(this.getY() - 1);
        this.setHasMoved();
	}

	/**
	 * Move left the mobile and say he has moved
	 * 
	 * @see model.element.mobile.IMobile#moveLeft()
	 * 
	 */
	@Override
	public void moveLeft() {
		this.setX(this.getX() - 1);
        this.setHasMoved();
	}

	/**
	 * Move down the mobile and say he has moved
	 * 
	 * @see model.element.mobile.IMobile#moveDown()
	 */
	@Override
	public void moveDown() {
		this.setY(this.getY() + 1);
        this.setHasMoved();
	}

	/**
	 * Move up the mobile and say he has moved
	 * 
	 * @see model.element.mobile.IMobile#moveRight()
	 */
	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
        this.setHasMoved();
	}

	/**
	 * The mobile do nothing
	 * @see model.element.mobile.IMobile#doNothing()
	 */
	@Override
	public void doNothing() {
		this.setHasMoved();
	}

	/**
	 * Sets the has moved.
	 */
	private void setHasMoved() {
		 this.getMap().setMobileHasChanged();
	}

	/**
	 * Get the x
	 * 
	 * @see model.element.mobile.IMobile#getX()
	 * 
	 */
	@Override
	public final int getX() {
		return this.getPosition().x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x
	 *            the new x
	 */
	public final void setX(final int x) {
		this.getPosition().x = x;
		
	}

	/**
	 * Get the y
	 * 
	 * @see model.element.mobile.IMobile#getY()
	 */
	@Override
	public final int getY() {
		return this.getPosition().y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y
	 *            the new y, as the road is an infinite loop, there's a modulo
	 *            based on the road height.
	 */
	public final void setY(final int y) {
		this.getPosition().y = y;
		
	}


	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public IMap getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map
	 *            the new map
	 */
	private void setMap(final IMap map) {
		this.map = map;
	}

	/**
	 * Get the alive
	 * 
	 * @see model.element.mobile.IMobile#isAlive()
	 */
	@Override
	public Boolean isAlive() {
		return this.alive;
	}

	/**
	 * The player dies.
	 */
	public void die() {
		this.alive = false;
		this.getMap().setStillPlaying(false);
		this.setHasMoved();
	}

	
	/**
	 * Check if is a dirt
	 * 
	 * @see model.element.mobile.IMobile#isDirt()
	 */
	@Override
	public Boolean isDirt() {
		return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.DISAPPEAR;
	}
	
	/**
	 * Check if is a diamond
	 * 
	 * @see model.element.mobile.IMobile#isDiamond()
	 */
	@Override
	public Boolean isDiamond() {
		return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.PICKABLE;
	}
	
	/**
	 * Check if we can passed through objects
	 * 
	 * @see model.element.mobile.IMobile#isBlocked()
	 */
	@Override
	public Boolean isBlocked() {
		return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
	}
	
	/**
	 * Check if we can push rocks
	 * 
	 * @see model.element.mobile.IMobile#isPushable()
	 */
	@Override
	public Boolean isPushable() {
		return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.PUSHABLE;
	}

	/**
	 * (
	 * @see fr.exia.showboard.IPawn#getPosition()
	 */
	/**
	 * Get the position
	 * @see model.element.mobile.IMobile#getPosition()
	 */
	@Override
	public Point getPosition() {
		return this.position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position
	 *            the position to set
	 */
	public void setPosition(final Point position) {
		this.position = position;
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	protected IBoard getBoard() {
		return this.board;
	}

	/**
	 * Get the ennemy
	 * 
	 * @return ennemy
	 */
	public Ennemy getEnnemy() {
		return ennemy;
	}

	/**
	 * Set the ennemy
	 * 
	 * @param ennemy
	 */
	public void setEnnemy(Ennemy ennemy) {
		this.ennemy = ennemy;
	}

	/**
	 * Set the moved
	 * 
	 * @param moved
	 */
	public void setHasMoved(boolean moved) {
		this.moved = moved;
	}
	
	/**
	 * Get the moved
	 * 
	 * @return the moved
	 */
	public Boolean getHasMoved() {
		return this.moved;
	}
	
}
