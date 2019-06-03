package model.element.mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.exia.showboard.IBoard;
import model.IMap;
import model.Map;
import model.element.Permeability;
import model.element.Sprite;

/**
 * <h1>The MobileTest Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */
public class MobileTest {
	
	/** The map */
	private IMap map;
	
	/** The board */
	private IBoard board;
	
	/** The new sprite */
	final Sprite sprite = new Sprite('X', "player");
	
	/** The mobile */
	private Mobile testMobile;

	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Set up the map and then the mobile
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.map = new Map(10, 1, 3, 3, 2, 2, "   \r\n D \r\n   ");
		this.testMobile = new Mobile(1, 1, sprite, map, Permeability.BLOCKING) {
			
		};
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Check if the mobile has moved up
	 */
	@Test
	public void testMoveUp() {
		this.testMobile.moveUp();
		int expectedY = 0;
		int expectedX = 1;
		assertEquals(expectedY,this.testMobile.getY());
		assertEquals(expectedX,this.testMobile.getX());
	}

	/**
	 * Check if the mobile has moved left
	 */
	@Test
	public void testMoveLeft() {
		this.testMobile.moveLeft();
		int expectedY = 1;
		int expectedX = 0;
		assertEquals(expectedY,this.testMobile.getY());
		assertEquals(expectedX,this.testMobile.getX());
	}

	/**
	 * Check if the mobile has moved down
	 */
	@Test
	public void testMoveDown() {
		this.testMobile.moveDown();
		int expectedY = 2;
		int expectedX = 1;
		assertEquals(expectedY,this.testMobile.getY());
		assertEquals(expectedX,this.testMobile.getX());
	}

	/**
	 * Check if the mobile has moved right
	 */
	@Test
	public void testMoveRight() {
		this.testMobile.moveRight();
		int expectedY = 1;
		int expectedX = 2;
		assertEquals(expectedY,this.testMobile.getY());
		assertEquals(expectedX,this.testMobile.getX());
	}

	/**
	 * Check if the mobile do nothing
	 */
	@Test
	public void testDoNothing() {
		this.testMobile.doNothing();
		int expectedY = 1;
		int expectedX = 1;
		assertEquals(expectedY,this.testMobile.getY());
		assertEquals(expectedX,this.testMobile.getX());
	}

	/**
	 * Check if the  getter of position x of the mobile works
	 */
	@Test
	public void testGetX() {
		int ExpectedX = 1;
		assertEquals(ExpectedX, testMobile.getX());
	}

	/**
	 * Check if the setter of position x of the mobile works
	 */
	@Test
	public void testSetX() {
		int ExpectedX = 3;
		testMobile.setX(ExpectedX);
		
		assertEquals(ExpectedX, testMobile.getX());
	}

	/**
	 * Check if the getter of position y of the mobile works
	 */
	@Test
	public void testGetY() {
		int ExpectedY = 1;
		assertEquals(ExpectedY, testMobile.getY());
	}

	/**
	 * Check if the setter of position y of the mobile works
	 */
	@Test
	public void testSetY() {
		int ExpectedY = 3;
		testMobile.setY(ExpectedY);
		
		assertEquals(ExpectedY, testMobile.getY());
	}

	/**
	 * Check if we recovered the map
	 */
	
	@Test
	public void testGetMap() {
		assertEquals(map, testMobile.getMap());
	}

	/**
	 * Check if the player is Alive
	 */
	@Test
	public void testIsAlive() {
			Boolean alive = true;
			assertEquals(alive, testMobile.isAlive());
	}

	/**
	 * Check if the player dies
	 */
	
	@Test
	public void testDie() {
		Boolean alive = false;
		
		if (testMobile.isAlive() != alive) {
			assertNotEquals(alive, testMobile.isAlive());
		}
	}

	/**
	 * Check if there is a dirt on the positionXY of the mobile
	 */
	
	@Test
	public void testIsDirt() {
		
		if (testMobile.isDirt() == true) {
			assertEquals(this.map.getOnTheMapXY(this.testMobile.getX(), this.testMobile.getY()).getPermeability(), Permeability.DISAPPEAR);
		}
	}

	/**
	 * Check if we recovered the Board
	 */
	@Test
	public void testGetBoard() {
		final IBoard expected = board;
		assertEquals(expected, testMobile.getBoard());
	}
	

}
