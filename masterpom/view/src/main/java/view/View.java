package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import contract.controller.IOrderPerformer;
import contract.controller.UserOrder;
import contract.view.IView;
import fr.exia.showboard.BoardFrame;
import model.IMap;
import model.element.mobile.IMobile;

/**
 * <h1>The View Class</h1>
 * 
 * @author Clément GASTON
 * @version 0.1
 */
public class View implements IView, KeyListener, Runnable {

	/** Size of the map. */
	private static final int mapView = 11;

	/** Size of each case of the grid. */
	private static final int squareSize = 75;

	/** Create a view closer to the player. */
	private Rectangle closeView;

	/** Set a new map. */
	private IMap map;

	/** Set a new player. */
	private IMobile Player;

	/** The view. */
	private int view;

	/** The order to perform. */
	private IOrderPerformer orderPerformer;

	/** Create the grid of the close view. */
	final BoardFrame boardFrame = new BoardFrame("Close view");

	/**
	 * Create the view.
	 * 
	 * @param map    The new map.
	 * @param player The new player.
	 * @throws Exception
	 */
	public View(final IMap map, final IMobile player) throws Exception {
		this.setView(mapView);
		this.setMap(map);
		this.setPlayer(player);
		this.getPlayer().getSprite().loadImage(this.getMap().getIdMap());
		this.setCloseView(new Rectangle(0, mapView, mapView, mapView));
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Display a message.
	 * 
	 * @param message The message to display.
	 */
	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/**
	 * Update the view.
	 */
	public void updateView() {
		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
			}
		}
		boardFrame.addPawn(this.getPlayer());

		this.getMap().getObservable().addObserver(boardFrame.getObserver());
	}

	/**
	 * Set the closeView to follow the player or get blocked by the end of the map.
	 */
	public final void followMyPlayer() {
		if (this.getPlayer().getY() < 5) {
			this.getCloseView().y = 0;
		} else {
			if (this.getPlayer().getY() > this.getMap().getHeight() - 6) {
				this.getCloseView().y = this.getMap().getHeight() - 11;
			} else {
				this.getCloseView().y = this.getPlayer().getY() - 5;
			}
		}
		if (this.getPlayer().getX() < 5) {
			this.getCloseView().x = 0;
		} else {
			if (this.getPlayer().getX() > this.getMap().getWidth() - 6) {
				this.getCloseView().x = this.getMap().getWidth() - 11;
			} else {
				this.getCloseView().x = this.getPlayer().getX() - 5;
			}
		}
	}

	/**
	 * Gets the order to perform.
	 * 
	 * @return orderPerformer
	 */
	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
	 * Sets the order to perform.
	 * 
	 * @param orderPerformer
	 * 			The new order to perform.
	 */
	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	/**
	 * Run the view.
	 */
	public final void run() {
		boardFrame.setResizable(true);
		boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
		boardFrame.setHeightLooped(false);
		boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
			}
		}
		boardFrame.addPawn(this.getPlayer());
		this.getMap().getObservable().addObserver(boardFrame.getObserver());
		this.followMyPlayer();
		boardFrame.setVisible(true);
	}
	public final void show(final int yStart) {
		int y = yStart % this.getMap().getHeight();
		for (int view = 0; view < this.getView(); view++) {
			for (int x = 0; x < this.getMap().getWidth(); x++) {
				if ((x == this.getPlayer().getX()) && (y == yStart)) {
					System.out.print(this.getPlayer().getSprite().getConsoleImage());
				} else {
					System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
				}
			}
			System.out.print("\n");
		}
	}

	/**
	 * Set the correct user order.
	 * 
	 * @param keyCode
	 * 			The touch pressed by the player.
	 * @return userOrder
	 */
	private static UserOrder keyCodeToUserOrder(final int keyCode) {
		UserOrder userOrder = null;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		}
		return userOrder;
	}

	/**
	 * Gets the key pressed by the player.
	 */
	public final void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Gets the map.
	 * 
	 * @return map
	 */
	private IMap getMap() {
		return this.map;
	}

	/**
	 * Sets the map
	 * 
	 * @param map
	 * 			The new map.
	 * @throws IOException
	 */
	private void setMap(final IMap map) throws IOException {
		this.map = map;
		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				this.getMap().getOnTheMapXY(x, y).getSprite().loadImage(this.getMap().getIdMap());
			}
		}
	}

	/**
	 * Gets the player.
	 * 
	 * @return player
	 */
	private IMobile getPlayer() {
		return this.Player;
	}

	/**
	 * Sets the player.
	 * 
	 * @param Player
	 * 			The new player.
	 */
	private void setPlayer(final IMobile Player) {
		this.Player = Player;
	}

	/**
	 * Gets the view.
	 * 
	 * @return view
	 */
	private int getView() {
		return this.view;
	}

	/**
	 * Sets the view.
	 * 
	 * @param view
	 * 			The new view.
	 */
	private void setView(final int view) {
		this.view = view;
	}

	/**
	 * Gets the close view.
	 * 
	 * @return closeView.
	 */
	private Rectangle getCloseView() {
		return this.closeView;
	}

	/**
	 * Sets the close view.
	 * 
	 * @param closeView
	 * 			The new close view.
	 */
	private void setCloseView(final Rectangle closeView) {
		this.closeView = closeView;
	}

	/**
	 * Not used here.
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		//Not used here.
	}

	/**
	 * Not used here.
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		//Not used here.
	}

}
