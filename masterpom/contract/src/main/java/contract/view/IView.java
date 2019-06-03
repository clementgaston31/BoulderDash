package contract.view;

import contract.controller.IOrderPerformer;

/**
 * <h1>The Interface View.</h1>
 * 
 * @author Clement GASTON kevinBourdeau
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
	
	/**
	 * Update the view
	 */
	void updateView() ;
	
	/**
	 * Set the orderPerformer
	 * @param orderPerformer the OrderPerformer
	 */
	void setOrderPerformer(IOrderPerformer orderPerformer);
}
