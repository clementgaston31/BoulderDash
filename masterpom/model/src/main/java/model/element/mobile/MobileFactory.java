package model.element.mobile;

import model.element.mobile.gravity.*;


/**
 * <h1>A factory to create MobileElements objects.</h1>
 *
 * @author kevinBourdeau
 * @version 0.1
 */

public abstract class MobileFactory {

	/** The Constant Background. */
	private static final Diamond diamond = new Diamond();
	
	/** The Constant Rock. */
	private static final Rock rock = new Rock();

	/** The Constant Dirt. */
	private static final Ennemy ennemy = new Ennemy();
	
	/** The Constant Dirt. */
	private static final EnnemyRandom ennemyRandom = new EnnemyRandom();

	/** The Constant UnbreakableWall. */
	private static final Player player = new Player();

	
	
	/**
	 * The motionless elements is an array of all possible MotionlessElement.
	 */
	private static Mobile[] mobileElements = {
			diamond, 
			ennemy, 
			ennemyRandom, 
			player,
			};
	
	
	/**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Mobile createDiamond() {
        return diamond;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Mobile createPlayer() {
        return player;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Mobile createRock() {
        return rock;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Mobile createEnnemy() {
        return ennemy;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Mobile createEnnemyRandom() {
        return ennemyRandom;
    }
    
    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static Mobile getFromFileSymbol(final char fileSymbol) {
        for (final Mobile mobileElement : mobileElements) {
            if (mobileElement.getSprite().getConsoleImage() == fileSymbol) {
                return mobileElement;
            }
        }
        return rock;
    }
}
