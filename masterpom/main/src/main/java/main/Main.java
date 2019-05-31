package main;

import contract.model.IModel;
import contract.view.IView;
import model.Map;
import model.Model;
import view.View;

public class Main {
	
	private static int idMap = 1;
	private static Map map;

	public static void main(final String[] args) throws Exception {
		final IModel model = new Model(idMap, map);
		System.out.println("Checkpoint 1");
		final IView view = new View(model.getMap(), model.getPlayer());
		System.out.println("Checkpoint 2");
		//final IController controller = new Controller();
		
		
		//controller.play();
	}
}
