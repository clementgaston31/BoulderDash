package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Observable;

import model.element.IElement;
import model.element.motionlessElement.MotionlessElementFactory;

/**
 * <h1> The Map Class. </h1>
 * 
 * @author Clément Gaston
 * @version 0.1
 */
public class Map extends Observable implements IMap{

	/** The number of the map in the database. */
	private int idMap;
	
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
	
	/** The grill of the map which will stock every character with their X Y coordinates. */
	IElement[][] onTheMap;
	
	/**
	 * Creation of a new Map.
	 * 
	 * @param idMap
	 * 			The number of the Map.
	 * @param width
	 * 			The width of the Map.
	 * @param height
	 * 			The height of the Map.
	 * @param playerStartX
	 * 			The X start point of the player.
	 * @param playerStartY
	 * 			The Y start point of the player.
	 * @param mapFromBDD
	 * 			The characters Map.
	 * @throws IOException 
	 */
	public Map(int idMap, int width, int height, int playerStartX, int playerStartY, String mapFromBDD) throws IOException {
		super();
		this.setIdMap(idMap);
		this.setWidth(width);
		this.setHeight(height);
		this.setPlayerStartX(playerStartX);
		this.setPlayerStartY(playerStartY);
		this.setMapFromBDD(mapFromBDD);
		this.loadMap(mapFromBDD);
	}
	
	/**
	 * Creation of a new Map from the database directly.
	 * @throws IOException 
	 */
	
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
	 * @param idMap
	 * 			The new id of the Map.
	 */
	public void setIdMap(int idMap) {
		this.idMap = idMap;
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
	 * @param width
	 * 			The new width of the Map.
	 */
	public void setWidth(int width) {
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
	 * @param height
	 * 			The new height of the map.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the X point start of the player.
	 * 
	 * @return playerStartX
	 */
	public int getPlayerStartX() {
		return playerStartX;
	}

	/**
	 * Sets the X point start of the player.
	 * 
	 * @param playerStartX
	 * 			The new X start point of the player.
	 */
	public void setPlayerStartX(int playerStartX) {
		this.playerStartX = playerStartX;
	}

	/**
	 * Gets the Y point start of the player.
	 * 
	 * @return playerStartY
	 */
	public int getPlayerStartY() {
		return playerStartY;
	}

	/**
	 * Sets the Y point start of the player.
	 * 
	 * @param playerStartY
	 * 			The new Y start point of the player.
	 */
	public void setPlayerStartY(int playerStartY) {
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
	 * @param mapFromBDD
	 * 			The new String Map.
	 * @return 
	 */
	public void setMapFromBDD(String mapFromBDD) {
		this.mapFromBDD = mapFromBDD;
	}
	
	public IMap getMap() {
		return this;
	}
	
	/**
	 * Read the String map, then create the grill.
	 * 
	 * @param mapFromBDD
	 * 			The String map to read.
	 * @throws IOException
	 * 		Signals that an I/O exception has occured.
	 */
	public void loadMap(String mapFromBDD) throws IOException {
		String line = mapFromBDD;
		Reader inputString = new StringReader(line);
		BufferedReader reader = new BufferedReader(inputString);
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		line = reader.readLine();
		int y = 0;
		while (line != null) {
			for (int x = 0; x < this.getWidth(); x++) {
				this.setOnTheMapXY(MotionlessElementFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
			}
			line = reader.readLine();
			y++;
		}
		reader.close();
	}
	
	/**
	 * Gets the coordinate on the map.
	 * 
	 * @param x
	 * @param y
	 * @return onTheMap[x][y]
	 */
	public IElement getOnTheMapXY(final int x,final int y) {
		return this.onTheMap[x][y];
	}
	
	/**
	 * Sets the coordinate on the map.
	 * 
	 * @param element
	 * 			The object to place.
	 * @param x
	 * 			The new X of the object.
	 * @param y
	 * 			The new Y of the object.
	 */
	public void setOnTheMapXY(IElement element, int x, int y) {
		this.onTheMap[x][y] = element;
	}
	
	/**
	 * IDK
	 */
	public void setMobileHasChanged() {
		this.setChanged();
        this.notifyObservers();
	}
	
	/*
	public Observable getObservable() {
		return this;
	}*/
	
	/**
	 * IDK
	 */
	public void updateMap() {
		
	}

	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
