package contract.view;

/**
 * <h1> The View Interface </h1>
 * 
 * @author Clément GASTON
 * @version 0.1
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
	void displayMessage(String message);
	
	/**
     * Follow myPlayer.
     */
	void followMyPlayer();
}
