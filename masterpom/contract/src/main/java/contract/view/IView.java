package contract.view;

import contract.controller.IOrderPerformer;

/**
 * <h1> The View Interface </h1>
 * 
 * @author Clément GASTON && kevinBourdeau
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
	public void updateView() ;
	
	/**
	 * Set the orderPerformer
	 * @param orderPerformer
	 */
	void setOrderPerformer(IOrderPerformer orderPerformer);
}
