package main;

import contract.view.IView;
import model.IModel;
import model.Model;
import view.View;

public class Main {
	
	private static int idMap = 1;

	public static void main(final String[] args) throws Exception {
		final IModel model = new Model(idMap);
		System.out.println("Checkpoint 1");
		final IView view = new View(model.getMap(), model.getPlayer());
		System.out.println("Checkpoint 2");
		//final IController controller = new Controller();
		
		
		//controller.play();
	}
}
