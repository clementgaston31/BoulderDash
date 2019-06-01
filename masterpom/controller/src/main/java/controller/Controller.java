package controller;

import contract.controller.IController;
import contract.controller.IOrderPerformer;
import contract.controller.UserOrder;
import contract.view.IView;
import model.IModel;

/**
 * <h1> The Controller Class. </h1>
 * 
 * @author Clément GASTON
 * @version 0.1
 */
public class Controller implements IOrderPerformer, IController {

	/** Speed will be the time in ms between every refresh of the game. */
	public int speed = 300;
	
	/** The model. */
	private IModel model;
	
	/** The view. */
	private IView view;
	
	/** The stack order. */
	private UserOrder stackOrder;

	/**
	 * The controller which will create a view and a model.
	 * 
	 * @param view
	 * @param model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}

	/**
	 * This function will loop during all the game and will allow the player to move.
	 * @throws InterruptedException 
	 */
	public void play() throws InterruptedException {
		System.out.println(this.getStackOrder());
		this.stackOrder = UserOrder.NOP;
		while (this.getModel().getPlayer().isAlive()) {
			Thread.sleep(speed);
			System.out.println(this.getStackOrder());
			switch (this.getStackOrder()) {
			case UP:
				this.getModel().getPlayer().moveUp();
				break;
			case LEFT:
				this.getModel().getPlayer().moveLeft();
				break;
			case DOWN:
				this.getModel().getPlayer().moveDown();
				break;
			case RIGHT:
				this.getModel().getPlayer().moveRight();
				break;
			case NOP:
				System.out.println(this.getStackOrder());
				break;
			default:
				this.getModel().getPlayer().doNothing();
				break;
			}
			this.clearStackOrder();
			this.getView().followMyPlayer();
			System.out.println(this.getModel().getPlayer().getX());
		}
		this.getView().displayMessage("Cheh");
	}

	/**
	 * Gets the view.
	 * 
	 * @return view
	 */
	public IView getView() {
		return this.view;
	}

	/**
	 * Sets the view.
	 * 
	 * @param view
	 * 			The new view.
	 */
	private void setView(IView view) {
		this.view = view;
	}

	/**
	 * Gets the model. 
	 * 
	 * @return model
	 */
	public IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 * 
	 * @param model
	 * 			The new model.
	 */
	private void setModel(IModel model) {
		this.model = model;
	}

	/**
	 * IDK
	 * 
	 * @param userOrder
	 */
	public void orderPerform(UserOrder userOder) {
		this.setStackOrder(userOder);
	}

	/**
	 * Gets the stack order.
	 * 
	 * @return stackOrder
	 */
	public UserOrder getStackOrder() {
		return this.stackOrder;
	}

	/**
	 * Sets the stack order.
	 * 
	 * @param stackOrder
	 * 			The new stack order.
	 */
	private void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	/**
	 * Clear the stack order.
	 */
	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	/**
	 * 
	 * @return
	 */
	public IOrderPerformer getOrderPerformer() {
		return this;
	}
}
