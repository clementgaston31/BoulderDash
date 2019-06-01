package model.element.mobile;



/**
 * <h1>A factory to create MobileElements objects.</h1>
 *
 * @author kevinBourdeau
 * @version 0.1
 */

public abstract class MobileFactory {

	/** The Constant Diamond. */
	private static final Diamond diamond = new Diamond();
	
	/** The Constant Rock. */
	private static final Rock rock = new Rock();

	
	
	/**
	 * The motionless elements is an array of all possible MotionlessElement.
	 */
	private static Mobile[] mobileElements = {
			diamond, 
			rock,
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
    public static Mobile createRock() {
        return rock;
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
