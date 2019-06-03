package model.element.mobile;


import model.element.Permeability;
import model.element.Sprite;
/**
 * <h1>The Ennemy Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */
public class Ennemy extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite spriteEnnemy = new Sprite('E', "Ennemy.png");
	
	public Ennemy() {
		super(spriteEnnemy, Permeability.BLOCKING);
	}
		
}
