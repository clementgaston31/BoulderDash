package controller;

import contract.controller.IController;
import contract.controller.IOrderPerformer;
import contract.controller.UserOrder;
import contract.view.IView;
import model.IModel;
import model.element.mobile.MobileFactory;
import model.element.motionlessElement.MotionlessElementFactory;

/**
 * <h1>The Controller Class.</h1>
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

	public int Diamond = 0;

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
	 * This function will loop during all the game and will allow the player to
	 * move.
	 * 
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
				if (this.getModel().getPlayer().isBlocked() == true) {
					this.getModel().getPlayer().moveDown();
				}
				break;
			case LEFT:
				this.getModel().getPlayer().moveLeft();
				if (this.getModel().getPlayer().isBlocked() == true) {
					this.getModel().getPlayer().moveRight();
				}
				break;
			case DOWN:
				this.getModel().getPlayer().moveDown();
				if (this.getModel().getPlayer().isBlocked() == true) {
					this.getModel().getPlayer().moveUp();
				}
				break;
			case RIGHT:
				this.getModel().getPlayer().moveRight();
				if (this.getModel().getPlayer().isBlocked() == true) {
					this.getModel().getPlayer().moveLeft();
				}
				break;
			case NOP:
				break;
			/*
			 * System.out.println(this.getStackOrder()); break;
			 */
			default:
				this.getModel().getPlayer().doNothing();
				break;
			}
			this.clearStackOrder();

			this.getModel().getMap().updateMap();
			// this.getView().followMyPlayer();
			this.getModel().getMap().setMobileHasChanged();
			//this.getModel().getMap().updateMap();
			updateModel();
			this.getView().updateView();

		}
		this.getView().displayMessage("Cheh");
	}

	public void updateModel() {
		if (this.getModel().getPlayer().isDirt() == true) {
			this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(),
					this.getModel().getPlayer().getX(), this.getModel().getPlayer().getY());
		}

		if (this.getModel().getPlayer().isDiamond() == true) {
			this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(),
					this.getModel().getPlayer().getX(), this.getModel().getPlayer().getY());
			Diamond = Diamond + 1;
			System.out.println("CONNAED");
			System.out.println(Diamond);
			System.out.println(Diamond);
			System.out.println(Diamond);
			
		}

		
		for (int x = 1 ; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 1 ; y < this.getModel().getMap().getHeight(); y++) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'R'
						&& this.getModel().getMap().getOnTheMapXY(x, y+1).getSprite().getConsoleImage() == 'B'
						&& this.getModel().getPlayer().getX() != x
						&& this.getModel().getPlayer().getY() != y+1) {
					this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x, y+1);
					this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
					System.out.println("Position X du joueur : " + this.getModel().getPlayer().getX());
					System.out.println("Position Y du joueur : " + this.getModel().getPlayer().getY());
					System.out.println("Position X  : " + x);
					System.out.println("Position Y : " + y);
				}
			}
		}
		/*for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
			for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'R'
						|| this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == '*') {

					if (this.getModel().getMap().getOnTheMapXY(x, y + 1).getSprite().getConsoleImage() == 'B'
							&& this.getModel().getPlayer().getX() != x && this.getModel().getPlayer().getY() != y + 1) {
						this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
						this.getModel().getMap().setOnTheMapXY(MobileFactory.createRock(), x, (y + 1));
						System.out.println("COUCOU ANTHONY LE PLUS BO");
					}
				}
			}
		}*/
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
	 * @param view The new view.
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
	 * @param model The new model.
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
	 * @param stackOrder The new stack order.
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
