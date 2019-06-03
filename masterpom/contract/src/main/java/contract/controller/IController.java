package contract.controller;
/**
 * <h1> The Controller Interface </h1>
 * 
 * @author Clement GASTON kevinBourdeau
 * @version 0.1
 */
public interface IController {

	/**
     * Play.
     *
     * @throws InterruptedException
     *             the interrupted exception
     */
	void play() throws InterruptedException;
	
	/**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
	
	IOrderPerformer getOrderPerformer();
}
