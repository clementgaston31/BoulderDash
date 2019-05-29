package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Observable;

import contract.model.IElement;
import contract.model.IMap;

public class Map extends Observable implements IMap{

	private int idMap;
	private int width;
	private int height;
	private int playerStartX;
	private int playerStartY;
	private String mapFromBDD;
	IElement[][] onTheMap;
	
	public Map(int idMap, int width, int height, int playerStartX, int playerStartY, String mapFromBDD) {
		super();
		
		
		
		this.setIdMap(idMap);
		this.setWidth(width);
		this.setHeight(height);
		this.setPlayerStartX(playerStartX);
		this.setPlayerStartY(playerStartY);
		this.setMapFromBDD(mapFromBDD);
		/*try {
			this.loadMap(mapFromBDD);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public Map() {
		super();
		try {
			this.loadMap(mapFromBDD);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getIdMap() {
		return idMap;
	}

	public void setIdMap(int idMap) {
		this.idMap = idMap;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getPlayerStartX() {
		return playerStartX;
	}

	public void setPlayerStartX(int playerStartX) {
		this.playerStartX = playerStartX;
	}

	public int getPlayerStartY() {
		return playerStartY;
	}

	public void setPlayerStartY(int playerStartY) {
		this.playerStartY = playerStartY;
	}

	public String getMapFromBDD() {
		return mapFromBDD;
	}

	public void setMapFromBDD(String mapFromBDD) {
		this.mapFromBDD = mapFromBDD;
	}
	
	public void loadMap(String mapFromBDD) throws IOException {
		String line = this.getMapFromBDD();
		Reader inputString = new StringReader(line);
		BufferedReader reader = new BufferedReader(inputString);
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		line = reader.readLine();
		int y = 0;
		while (line != null) {
			for (int x = 0; x < this.getWidth(); x++) {
				this.setOnTheMapXY(getFromFileSymbol(line.toCharArray()[x]), x, y);
			}
			line = reader.readLine();
			y++;
		}
		reader.close();
	}

	private IElement getFromFileSymbol(char c) {
		return null;
	}
	
	public IElement getOnTheMapXY(int x, int y) {
		return this.onTheMap[x][y];
	}
	
	public void setOnTheMapXY(IElement element, int x, int y) {
		this.onTheMap[x][y] = element;
	}
	
	public void setMobileHasChanged() {
		
	}
	
	/*
	public Observable getObservable() {
		return this;
	}*/
	
	public void updateMap() {
		
	}
	
}
