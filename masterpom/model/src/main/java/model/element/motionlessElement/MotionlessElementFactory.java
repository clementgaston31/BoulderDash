package model.element.motionlessElement;

/**
 * <h1>A factory to create MotionlessElements objects.</h1>
 *
 * @author kevinBourdeau
 * @version 0.1
 */

public abstract class MotionlessElementFactory {

	/** The Constant Background. */
	private static final Background background = new Background();

	/** The Constant Dirt. */
	private static final Dirt dirt = new Dirt();

	/** The Constant Door. */
	private static final Door door = new Door();

	/** The Constant UnbreakableWall. */
	private static final UnbreakableWall unbreakableWall = new UnbreakableWall();

	/** The Constant Wall. */
	private static final Wall wall = new Wall();
	
	/**
	 * The motionless elements is an array of all possible MotionlessElement.
	 */
	private static MotionlessElement[] motionlessElements = {
			dirt, 
			background, 
			door, 
			unbreakableWall, 
			wall,
			};
	
	
	/**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDirt() {
        return dirt;
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
