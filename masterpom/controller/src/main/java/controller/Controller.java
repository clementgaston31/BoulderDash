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

	/** Going to be deleted I think */
	public int Diamond = 0;

	/** Number of diamond to get (GOING TO BE DELETED) */
	public int DiamondToGet = 3;

	/** Set true if we win (GOING TO BE DELETED) */
	public boolean win = false;

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
			default:
				this.getModel().getPlayer().doNothing();
				break;
			}
			updateModel();
			this.getModel().getMap().setMobileHasChanged();
			this.getView().followMyPlayer();
			this.getView().updateView();

			// updateModel();

			this.clearStackOrder();

		}
		if (win) {
			this.getView().displayMessage("VICTORYYYYY !!!!!!!!");
		} else {
			this.getView().displayMessage("Cheh");
		}
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

		}
		this.getModel().getMap().getEnnemy().setHasMoved(false);
		for (int y = this.getModel().getMap().getHeight() - 1; y > 0; y--) {
			for (int x = this.getModel().getMap().getWidth() - 1; x > 0; x--) {

				if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == Ennemy.class) {

					if ((this.getModel().getPlayer().getX() == x && this.getModel().getPlayer().getY() == y)
							|| (this.getModel().getPlayer().getX() == x+1 && this.getModel().getPlayer().getY() == y)
							|| (this.getModel().getPlayer().getX() == x-1 && this.getModel().getPlayer().getY() == y)
							|| (this.getModel().getPlayer().getX() == x && this.getModel().getPlayer().getY() == y+1)
							|| (this.getModel().getPlayer().getX() == x && this.getModel().getPlayer().getY() == y-1)) {
						this.getModel().getPlayer().die();
					}
					
					if (this.getModel().getMap().getEnnemy().getHasMoved() == false) {

						int Random = new Random().nextInt(3 + 1);
						// System.out.println(Random);

						if (this.getModel().getMap().getOnTheMapXY(x - 1, y).getSprite().getConsoleImage() == 'B'
								&& Random == 0) {
							this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x - 1,
									y);
							this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
						}

						if (this.getModel().getMap().getOnTheMapXY(x, y + 1).getSprite().getConsoleImage() == 'B'
								&& Random == 1) {
							this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x,
									y + 1);
							this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
						}

						if (this.getModel().getMap().getOnTheMapXY(x + 1, y).getSprite().getConsoleImage() == 'B'
								&& Random == 2) {
							this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x + 1,
									y);
							this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
						}

						if (this.getModel().getMap().getOnTheMapXY(x, y - 1).getSprite().getConsoleImage() == 'B'
								&& Random == 3) {
							this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x,
									y - 1);
							this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
						}

						this.getModel().getMap().getEnnemy().setHasMoved(true);
					}
				}

				/*
				 * //GAUCHE if (this.getModel().getMap().getOnTheMapXY(x - 1,
				 * y).getSprite().getConsoleImage() == 'B') {
				 * this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY
				 * (x, y), x - 1, y);
				 * this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.
				 * createBackground(), x, y); } //BAS if
				 * (this.getModel().getMap().getOnTheMapXY(x, y -
				 * 1).getSprite().getConsoleImage() == 'B') {
				 * this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY
				 * (x, y), x, y - 1);
				 * this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.
				 * createBackground(), x, y); } //DROITE if
				 * (this.getModel().getMap().getOnTheMapXY(x + 1,
				 * y).getSprite().getConsoleImage() == 'B') {
				 * this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY
				 * (x, y), x + 1, y);
				 * this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.
				 * createBackground(), x, y); } //HAUT if
				 * (this.getModel().getMap().getOnTheMapXY(x, y +
				 * 1).getSprite().getConsoleImage() == 'B') {
				 * this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY
				 * (x, y), x, y + 1);
				 * this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.
				 * createBackground(), x, y);
				 * 
				 * }
				 */
				
				if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == Rock.class 
						&& this.getModel().getPlayer().getX() == (x-1)
						&& this.getModel().getPlayer().getY() == y
						&& this.getModel().getMap().getOnTheMapXY(x+1, y).getPermeability() == Permeability.PENETRABLE
						&& this.getStackOrder() == UserOrder.RIGHT) {
					this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x+1, y);
					this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
					this.getModel().getPlayer().moveRight();
				}
				
				// CA MARCHEEEEEEEEEEEEE PASSSSSSSSSSSSSSSSS
				if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == Rock.class 
						&& this.getModel().getPlayer().getX() == (x+1)
						&& this.getModel().getPlayer().getY() == y
						&& this.getModel().getMap().getOnTheMapXY(x-1, y).getPermeability() == Permeability.PENETRABLE
						&& this.getStackOrder() == UserOrder.LEFT) {
					this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x-1, y);
					this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
					this.getModel().getPlayer().moveLeft();
				}
				
				
				
				// Si notre objet est soumis à la gravité
				if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == Rock.class
						|| this.getModel().getMap().getOnTheMapXY(x, y).getClass() == Diamond.class) {
					// Et qu'il n'ya rien en dessous

					if (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == Rock.class
							|| this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == Diamond.class
									&& this.getModel().getMap().getOnTheMapXY(x - 1, y)
											.getPermeability() == Permeability.PENETRABLE
									&& this.getModel().getMap().getOnTheMapXY(x - 1, y + 1)
											.getPermeability() == Permeability.PENETRABLE) {
						this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x - 1,
								y + 1);
						this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
					}

					if (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == Rock.class
							|| this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == Diamond.class
									&& this.getModel().getMap().getOnTheMapXY(x + 1, y)
											.getPermeability() == Permeability.PENETRABLE
									&& this.getModel().getMap().getOnTheMapXY(x + 1, y + 1)
											.getPermeability() == Permeability.PENETRABLE) {
						this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x + 1,
								y + 1);
						this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);
					}

					if (this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PENETRABLE
							&& (this.getModel().getPlayer().getX() != x
									|| this.getModel().getPlayer().getY() != y + 1)) {
						// Alors notre objet tombe
						this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getOnTheMapXY(x, y), x, y + 1);

						
						
						if ((this.getModel().getPlayer().getX() == x || this.getModel().getPlayer().getY() == y + 2)) {
							this.getModel().getPlayer().die();
						}

						if (this.getModel().getMap().getOnTheMapXY(x, y+2).getClass() == Ennemy.class) {
							this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y+2);
						}
						
						this.getModel().getMap().setOnTheMapXY(MotionlessElementFactory.createBackground(), x, y);

					}

				}

				if (Diamond >= DiamondToGet && this.getModel().getMap()
						.getOnTheMapXY(this.getModel().getPlayer().getX(), this.getModel().getPlayer().getY())
						.getPermeability() == Permeability.WIN) {
					win = true;
					this.getModel().getPlayer().die();
				}

			}
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

}
