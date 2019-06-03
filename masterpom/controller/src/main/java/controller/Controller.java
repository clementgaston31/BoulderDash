package controller;

import contract.controller.IController;

import java.util.Random;
import contract.controller.IOrderPerformer;
import contract.controller.UserOrder;
import contract.view.IView;
import model.IModel;
import model.element.mobile.Rock;
import model.element.Permeability;
import model.element.mobile.Diamond;
import model.element.mobile.Ennemy;
import model.element.mobile.EnnemyRandom;
import model.element.motionlessElement.MotionlessElementFactory;

/**
 * <h1>The Controller Class.</h1>
 * 
 * @author Clément GASTON & Kévin BOURDEAU
 * @version 0.2
 */
public class Controller implements IOrderPerformer, IController {

	/** Speed will be the time in ms between every refresh of the game. */
	public int speed = 150;

	/** The model. */
	private IModel model;

	/** The view. */
	private IView view;

	/** The stack order. */
	private UserOrder stackOrder;
	
	/** Comment this */
	public boolean tried = false;
	
	/** Comment this */
	public boolean pushed = false;

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
			//System.out.println(this.getStackOrder());
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
					this.tried = true;
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
					this.tried = true;
					this.getModel().getPlayer().moveLeft();
				}
				break;
			case NOP:
				break;
			default:
				this.getModel().getPlayer().doNothing();
				break;
			}
			updateModel();
			this.getModel().getMap().setMobileHasChanged();
			this.getView().followMyPlayer();
			this.getView().updateView();
			this.tried = false;
			this.pushed = false;
			this.clearStackOrder();
			this.getModel().getMap().getEnnemy().setHasMoved(false);

		}
		/*if (win) {
			this.getView().displayMessage("VICTORYYYYY !!!!!!!!");
		} else {
			this.getView().displayMessage("Cheh");
		}*/
	}

	/**
	 * Check if the player die when the ennemy killed it
	 * 			rock, diamond fall and slide
	 * 			the player can push the rock
	 *  
	 */
	public void updateModel() {
		this.getModel().getMap().getEnnemy().setHasMoved(false);
		
		// Sweeping of the map
		for (int y = this.getModel().getMap().getHeight() - 1; y > 0; y--) {
			for (int x = this.getModel().getMap().getWidth() - 1; x > 0; x--) {

				// If there is an ennemy at the current x, y on the map
				if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == Ennemy.class) {

					// If the player is in a radius of 1 of the ennemy 
					if ((this.getModel().getPlayer().getX() == x && this.getModel().getPlayer().getY() == y)
							|| (this.getModel().getPlayer().getX() == x + 1 && this.getModel().getPlayer().getY() == y)
							|| (this.getModel().getPlayer().getX() == x - 1 && this.getModel().getPlayer().getY() == y)
							|| (this.getModel().getPlayer().getX() == x && this.getModel().getPlayer().getY() == y + 1)
							|| (this.getModel().getPlayer().getX() == x
									&& this.getModel().getPlayer().getY() == y - 1)) {
						// The player die
						this.getModel().getPlayer().die();
					}

					//To comment 
					if (this.getModel().getMap().getEnnemy().getHasMoved() == false) {
						moveEnnemy(x, y);

						this.getModel().getMap().getEnnemy().setHasMoved(true);
					}
				}
				
				// If in the map there are rocks you can push
				pushTheRockRight(x, y);
				pushTheRockLeft(x, y);
				// To comment
				if (pushed == true) {
					this.clearStackOrder();
				}

				// If our object is subjected to gravity
				if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == Rock.class
						|| this.getModel().getMap().getOnTheMapXY(x, y).getClass() == Diamond.class) {
					//And there is nothing below
					slideRight(x, y);
					slideLeft(x, y);
					fall(x, y);
				}
			}
		}
	}
	
	/**
	 * Check if there is nothing under that our object is falling
	 * @param x
	 * @param y
	 * 
	 */
	public void fall(int x, int y) {
		
		if (this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PENETRABLE
				&& (this.getModel().getPlayer().getX() != x || this.getModel().getPlayer().getY() != y + 1)) {
			// Alors notre objet tombe
			this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x, y + 1);

			if ((this.getModel().getPlayer().getX() == x && this.getModel().getPlayer().getY() == y + 2)) {
				this.getModel().getPlayer().die();
			}

			if (this.getModel().getMap().getOnTheMapXY(x, y + 2).getClass() == Ennemy.class
					|| this.getModel().getMap().getOnTheMapXY(x, y + 2).getClass() == EnnemyRandom.class) {
				this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y + 2);
			}

			this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);

		}

	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void slideRight(int x, int y) {
		// SLIDE droite
		if ((this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == Rock.class
				|| this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == Diamond.class)
				&& this.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == Permeability.PENETRABLE
				&& this.getModel().getMap().getOnTheMapXY(x + 1, y + 1).getPermeability() == Permeability.PENETRABLE
				&& (this.getModel().getPlayer().getX() != (x + 1) || this.getModel().getPlayer().getY() != (y + 1))) {
			this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x + 1, y + 1);
			this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
		}
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void slideLeft(int x, int y) {
		// SLIDE gauche
		if ((this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == Rock.class
				|| this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == Diamond.class)
				&& this.getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability() == Permeability.PENETRABLE
				&& this.getModel().getMap().getOnTheMapXY(x - 1, y + 1).getPermeability() == Permeability.PENETRABLE
				&& (this.getModel().getPlayer().getX() != (x - 1) || this.getModel().getPlayer().getY() != (y + 1))) {
			this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x - 1, y + 1);
			this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
		}
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void pushTheRockRight(int x, int y) {
		/// PUSH DROIT
		if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == Rock.class
				&& this.getModel().getPlayer().getX() == (x - 1) && this.getModel().getPlayer().getY() == y
				&& this.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == Permeability.PENETRABLE
				&& this.getStackOrder() == UserOrder.RIGHT && this.tried == true) {
			this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x + 1, y);
			this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
			this.getModel().getPlayer().moveRight();
			this.pushed = true;

		}

	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void pushTheRockLeft(int x, int y) {
		// PUSH GAUCHE
		if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == Rock.class
				&& this.getModel().getPlayer().getX() == (x + 1) && this.getModel().getPlayer().getY() == y
				&& this.getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability() == Permeability.PENETRABLE
				&& this.getStackOrder() == UserOrder.LEFT && this.tried == true) {
			this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x - 1, y);
			this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
			this.getModel().getPlayer().moveLeft();
			this.pushed = true;
		}
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
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void moveEnnemy(int x, int y) {
		int Random = new Random().nextInt(3 + 1);
		// System.out.println(Random);

		if (this.getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability() == Permeability.PENETRABLE
				&& Random == 0) {
			this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x - 1,
					y);
			this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
		}

		if (this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PENETRABLE
				&& Random == 1) {
			this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x,
					y + 1);
			this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
		}

		if (this.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == Permeability.PENETRABLE
				&& Random == 2) {
			this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x + 1,
					y);
			this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
		}

		if (this.getModel().getMap().getOnTheMapXY(x, y - 1).getPermeability() == Permeability.PENETRABLE
				&& Random == 3) {
			this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x,
					y - 1);
			this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
		}
	}

}
