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
 * @author Clément GASTON && kevinBourdeau
 * @version 0.1
 */
public class Main {
	
	/** The Constant idMap. */
	private static int idMap = 5;

	/**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InterruptedException
     *             the interrupted exception
     */
	public static void main(final String[] args) throws Exception {
		final IModel model = new Model(idMap);
		System.out.println("Checkpoint 1");
		
		final IView view = new View(model.getMap(), model.getPlayer());
		System.out.println("Checkpoint 2");
		
		final IController controller = new Controller(view, model);
		System.out.println("Checkpoint 3");
		
		view.setOrderPerformer(controller.getOrderPerformer());
		System.out.println("Checkpoint 4");
		
		controller.play();
		System.out.println("Checkpoint 5");
	}
}
