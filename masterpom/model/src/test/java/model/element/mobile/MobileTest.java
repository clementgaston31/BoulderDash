package model.element.mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import banal.Permeability;
import banal.Sprite;
import contract.model.IMap;
import fr.exia.showboard.IBoard;


public class MobileTest {
	
	//private Mobile test;
	private IMap map;
	private IBoard board;
	//private Boolean aliveTest;
	
	final Sprite sprite = new Sprite('X', "player");
	
	private Mobile testMobile;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.testMobile = new Mobile(2, 1, sprite, map, Permeability.BLOCKING) {
			
		};
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMoveUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveDown() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveRight() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoNothing() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetX() {
		int ExpectedX = 2;
		assertEquals(ExpectedX, testMobile.getX());
	}

	@Test
	public void testSetX() {
		int ExpectedX = 0;
		testMobile.setX(0);
		
		int X = testMobile.getX();
		assertEquals(ExpectedX, X);
	}

	@Test
	public void testGetY() {
		int ExpectedY = 1;
		assertEquals(ExpectedY, testMobile.getY());
	}

	@Test
	public void testSetY() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMap() {
		assertEquals(map, testMobile.getMap());
	}

	@Test
	public void testIsAlive() {
			Boolean alive = true;
			assertEquals(alive, testMobile.isAlive());
	}

	@Test
	public void testDie() {
		Boolean alive = false;
		//new Boolean(false);
		
		if (testMobile.isAlive() != alive) {
			assertNotEquals(alive, testMobile.isAlive());
		}
	}

	@Test
	public void testIsKilled() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsDirt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBoard() {
		final IBoard expected = board;
		assertEquals(expected, testMobile.getBoard());
	}
	
	@Test
	public void testSetHasMoved() {
		
	}

}
