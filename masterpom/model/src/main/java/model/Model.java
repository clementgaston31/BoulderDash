package model;

import java.io.IOException;
import java.util.Observable;

import banal.IMobile;
import contract.model.IMap;
import contract.model.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	private IMap map;
	private IMobile player;
	String mapFromBDD;
	int idMap;
	
	Model(int idMap, int playerX, int playerY) throws IOException{
		this.setMap(new Map());
		//this.setPlayer(new Player(playerX, playerY, this.getMap()));
	}
	
	public IMap getMap() {
		return this.map;
	}
	
	private void setMap(IMap map) {
		this.map = map;
	}
	
	public IMobile getPlayer() {
		return this.player;
	}
	
	private void setPlayer(IMobile player) {
		this.player = player;
	}
	
	/*public void updateMOdel() {
		
	}*/

}
