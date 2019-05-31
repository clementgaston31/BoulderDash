package contract.model;

/**
 * 
 * <h1>The Interface IModel.</h1>
 *
 * @author kevinBourdeau
 * @version 0.1
 */

public interface IModel {

	/**
	 * Gets the road.
	 *
	 * @return the road
	 */
	IMap getMap();

	/**
	 * Gets the my vehicle.
	 *
	 * @return the myVehicle
	 */
	IMobile getMyVehicle();
}
