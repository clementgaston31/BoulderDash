package banal;

import java.awt.Point;

public interface IMobile {

	boolean isAlive();
	
	Point getPosition();
	
	int getY();
	
	int getX();
	
	void doNothing();
	
	void die();
	
	void moveRight();
	
	void moveLeft();
	
	void moveUp();
	
	void moveDown();
}
