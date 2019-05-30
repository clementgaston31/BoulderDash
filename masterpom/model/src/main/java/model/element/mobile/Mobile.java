package model.element.mobile;

import java.awt.Point;

import banal.Permeability;
import banal.Sprite;
import contract.model.IMap;
import contract.model.IMobile;
import fr.exia.showboard.IBoard;
import model.element.Element;

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

	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveUp()
	 */
	@Override
	public void moveUp() {
		this.setY(this.getY() - 1);
        this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveLeft()
	 */
	@Override
	public void moveLeft() {
		this.setX(this.getX() - 1);
        this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveDown()
	 */
	@Override
	public void moveDown() {
		this.setY(this.getY() + 1);
        this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveRight()
	 */
	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
        this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#doNothing()
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

	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getX()
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
		if (this.isKilled()) {
			this.die();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getY()
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
		this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
		if (this.isKilled()) {
			this.die();
		}
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

	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isAlive()
	 */
	@Override
	public Boolean isAlive() {
		return this.alive;
	}

	/**
	 * Dies.
	 */
	protected void die() {

	}

	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isKilled()
	 */
	@Override
	public Boolean isKilled() {
		return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.KILLING;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isDirt()
	 */
	@Override
	public Boolean isDirt() {
		return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.DISAPPEAR;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.exia.showboard.IPawn#getPosition()
	 */
	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getPosition()
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
}
