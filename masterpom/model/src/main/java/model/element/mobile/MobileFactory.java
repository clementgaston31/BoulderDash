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
    public static MotionlessElement createBackground() {
        return background;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDoor() {
        return door;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createUnbreakableWall() {
        return unbreakableWall;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createWall() {
        return wall;
    }
    
    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return background;
    }
}
