package main;

import java.io.IOException;

import contract.controller.IController;
import contract.view.IView;
import controller.Controller;
import model.IModel;
import model.Model;
import view.View;

/**
 * <h1>The Main Class.</h1>
 *
 * @author Clement GASTON kevinBourdeau
 * @version 0.1
 */
public class Main {
	
	/** The id of the map in the dataBase. */
	private static int idMap = 5;

	/**
     * The main method which launch all the settings (for the player, the map, ...).
     *
     * @param args
     *            The arguments.
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InterruptedException
     *             The interrupted exception.
     */
	public static void main(final String[] args) throws Exception {
		final IModel model = new Model(idMap);
		final IView view = new View(model.getMap(), model.getPlayer());
		final IController controller = new Controller(view, model);
		view.setOrderPerformer(controller.getOrderPerformer());
		controller.play();
	}
}
