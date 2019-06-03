package model.element;

import java.awt.Image;

import fr.exia.showboard.ISquare;

/**
* <h1>The Element Class.</h1>
*
* @author kevinBourdeau
* @version 0.1
* @see ISquare
*/

public abstract class Element implements IElement{
	

	/** The sprite. */
	private Sprite sprite;

	/** The permeability. */
	private Permeability permeability;

	/**
	 * Instantiates a new element.
	 *
	 * @param sprite
	 *            the sprite
	 * @param permeability
	 *            the permeability
	 */
	public Element(final Sprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}
	
	 public Element() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.IElement#getSprite()
	 */
	@Override
	public final Sprite getSprite() {
		return this.sprite;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.IElement#getPermeability()
	 */
	@Override
	public final Permeability getPermeability() {
		return this.permeability;
	}

	/**
	 * Sets the sprite.
	 *
	 * @param sprite
	 *            the new sprite
	 */
	protected final void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * Sets the permeability.
	 *
	 * @param permeability
	 *            the new permeability
	 */
	protected void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.exia.showboard.ISquare#getImage()
	 */
	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.element.IElement#getImage()
	 */
	@Override
	public Image getImage() {
		return this.getSprite().getImage();
	}

}
