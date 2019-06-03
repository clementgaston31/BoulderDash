package model.element.mobile;

import java.awt.Point;
import model.element.Permeability;
import model.element.Sprite;

public class Ennemy extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite spriteEnnemy = new Sprite('E', "Ennemy.png");

	/** The Constant spriteMove. */
	private static final Sprite spriteMove = new Sprite('E', "EnnemyMove.png");

	/** The Constant spriteDie. */
	private static final Sprite spriteEnnemyDie = new Sprite('E', "EnnemyDie.png");
	

	public Ennemy() {
		super(spriteEnnemy, Permeability.BLOCKING);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
	 */
	@Override
	public final void moveLeft() {
		super.moveLeft();
		this.setSprite(spriteMove);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
	 */
	@Override
	public final void moveRight() {
		super.moveRight();
		this.setSprite(spriteMove);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveUp()
	 */
	@Override
	public final void moveUp() {
		super.moveUp();
		this.setSprite(spriteMove);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveDown()
	 */
	@Override
	public final void moveDown() {
		super.moveDown();
		this.setSprite(spriteMove);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
	 */
	@Override
	public
	final void die() {
		super.die();
		this.setSprite(spriteEnnemyDie);
	}

	/*
	 * (non-Javadoc)
	 * 
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


	@Override
	public Boolean isNotWin() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
