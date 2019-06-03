package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Observable;

import model.element.IElement;
import model.element.mobile.MobileFactory;
import model.element.motionlessElement.MotionlessElementFactory;

/**
 * <h1>The Map Class.</h1>
 * 
 * @author Clement GASTON
 * @version 0.1
 */
public class Map extends Observable implements IMap {

	/** The id of the map in the database. */
	private int idMap;

	/** The number of diamond needed to finish the level. */
	private int diamondToGet;

	/** The width of the map. */
	private int width;

	/** The height of the map. */
	private int height;

	/** The X of the player when he start a game. */
	private int playerStartX;

	/** The Y of the player when he start a game. */
	private int playerStartY;

	/** The map composed of characters. */
	private String mapFromBDD;

	/** The current number of diamond collected. */
	private int currentDiamondGot;
	
	/** If the player still can play. */
	private Boolean StillPlaying = true;

	/**
	 * The grill of the map which will stock every character with their X Y
	 * coordinates.
	 */
	IElement[][] onTheMap;

	/**
	 * Creation of a new Map.
	 * 
	 * @param idMap        The number of the Map.
	 * @param width        The width of the Map.
	 * @param height       The height of the Map.
	 * @param playerStartX The X start point of the player.
	 * @param playerStartY The Y start point of the player.
	 * @param mapFromBDD   The characters Map.
	 * @param diamondToGet the diamondToGet
	 * @throws IOException the IOException
	 */
	public Map(int idMap, int diamondToGet, int width, int height, int playerStartX, int playerStartY,
			String mapFromBDD) throws IOException {
		super();
		this.setIdMap(idMap);
		this.setDiamondToGet(diamondToGet);
		this.setWidth(width);
		this.setHeight(height);
		this.setPlayerStartX(playerStartX);
		this.setPlayerStartY(playerStartY);
		this.setMapFromBDD(mapFromBDD);
		this.loadMap(mapFromBDD);
	}

	/**
	 * Gets the id of the Map.
	 * 
	 * @return idMap
	 */
	public int getIdMap() {
		return idMap;
	}

	/**
	 * Sets the id of the Map.
	 * 
	 * @param idMap The new id of the Map.
	 */
	private void setIdMap(int idMap) {
		this.idMap = idMap;
	}

	/**
	 * Gets the number of diamond needed to finish the level.
	 * 
	 * @return diamondToGet
	 */
	public int getDiamondToGet() {
		return this.diamondToGet;
	}

	/**
	 * Sets the number of diamond needed to finish the game.
	 * 
	 * @param diamondToGet The new number of diamond needed.
	 */
	private void setDiamondToGet(int diamondToGet) {
		this.diamondToGet = diamondToGet;
	}

	/**
	 * Gets the width of the Map.
	 * 
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of the Map
	 * 
	 * @param width The new width of the Map.
	 */
	private void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the height of the map.
	 * 
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height of the map.
	 * 
	 * @param height The new height of the map.
	 */
	private void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the X of the player when the game start.
	 * 
	 * @return playerStartX
	 */
	public int getPlayerStartX() {
		return playerStartX;
	}

	/**
	 * Sets the X of the player when the game start.
	 * 
	 * @param playerStartX The new X start point of the player.
	 */
	private void setPlayerStartX(int playerStartX) {
		this.playerStartX = playerStartX;
	}

	/**
	 * Gets the Y of the player when the game start.
	 * 
	 * @return playerStartY
	 */
	public int getPlayerStartY() {
		return playerStartY;
	}

	/**
	 * Sets the Y of the player when the game start.
	 * 
	 * @param playerStartY The new Y start point of the player.
	 */
	private void setPlayerStartY(int playerStartY) {
		this.playerStartY = playerStartY;
	}

	/**
	 * Gets the String Map.
	 * 
	 * @return mapFromBDD
	 */
	public String getMapFromBDD() {
		return mapFromBDD;
	}

	/**
	 * Sets the String Map.
	 * 
	 * @param mapFromBDD The new String Map.
	 */
	private void setMapFromBDD(String mapFromBDD) {
		this.mapFromBDD = mapFromBDD;
	}

	/**
	 * Gets the number of the current diamond collected.
	 * 
	 * @return currentDiamondGot
	 */
	public int getCurrentDiamondGot() {
		return this.currentDiamondGot;
	}

	/**
	 * Sets the number of the current diamond collected.
	 * 
	 * @param currentDiamondGot The new current of diamond got.
	 */
	public void setCurrentDiamondGot(int currentDiamondGot) {
		this.currentDiamondGot = currentDiamondGot;
	}

	/**
	 * Gets the current map.
	 * 
	 * @return this
	 */
	public IMap getMap() {
		return this;
	}

	/**
	 * Gets the coordinate on the map.
	 * 
	 * @param x the x
	 * @param y the y
	 * @return onTheMap[x][y]
	 */
	public IElement getOnTheMapXY(final int x, final int y) {
		return this.onTheMap[x][y];
	}

	/**
	 * Sets the coordinate on the map.
	 * 
	 * @param element The object to place.
	 * @param x       The new X of the object.
	 * @param y       The new Y of the object.
	 */
	public void setOnTheMapXY(IElement element, int x, int y) {
		this.onTheMap[x][y] = element;
	}

	/**
	 * Sets the mobile has changed.
	 */
	public void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	public Observable getObservable() {
		return this;
	}

	/**
	 * Read the String map, then create the grill.
	 * 
	 * @param mapFromBDD The String map to read.
	 * @throws IOException Signals that an I/O exception has occured.
	 */
	private void loadMap(String mapFromBDD) throws IOException {
		String line = mapFromBDD;
		Reader inputString = new StringReader(line);
		BufferedReader reader = new BufferedReader(inputString);
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		line = reader.readLine();
		int y = 0;
		while (line != null) {
			for (int x = 0; x < this.getWidth(); x++) {
				if (line.toCharArray()[x] == 'R' || line.toCharArray()[x] == '*' || line.toCharArray()[x] == 'E'
						|| line.toCharArray()[x] == 'J') {
					this.setOnTheMapXY(MobileFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
				} else {
					this.setOnTheMapXY(MotionlessElementFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
				}
			}
			line = reader.readLine();
			y++;
		}
		reader.close();
	}

	/*
	 * Add a diamond each time you pick up one.
	 */
	public void addDiamond() {
		this.setCurrentDiamondGot(currentDiamondGot + 1);
	}
	
	public void setStillPlaying(boolean stillPlaying) {
		this.StillPlaying = stillPlaying;
	}
	
	public Boolean getStillPlaying() {
		return this.StillPlaying;
	}
}
