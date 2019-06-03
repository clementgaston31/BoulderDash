package contract.controller;
/**
 * <h1> The Interface IOrderPerformer </h1>
 * 
 * @author Clément GASTON && kevinBourdeau
 * @version 0.1
 */
import java.io.IOException;

public interface IOrderPerformer {

	/**
     * Order perform.
     *
     * @param userOrder
     *            the user order
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
	void orderPerform(UserOrder userOrder) throws IOException;

}
