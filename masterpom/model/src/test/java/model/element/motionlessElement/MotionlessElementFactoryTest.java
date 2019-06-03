package model.element.motionlessElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <h1>The MotionlessElementFactoryTest Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */

public class MotionlessElementFactoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Check if the return of the method of the factory is the same in the console
	 */
	@Test
	public void testCreateDirt() {
		assertNotNull(MotionlessElementFactory.createDirt());
		assertEquals(MotionlessElementFactory.createDirt().getSprite().getConsoleImage(), 'D');
	}

	/**
	 * Check if the return of the method of the factory is the same in the console
	 */
	@Test
	public void testCreateBackground() {
		assertNotNull(MotionlessElementFactory.createBackground());
		assertEquals(MotionlessElementFactory.createBackground().getSprite().getConsoleImage(), ' ');
	}

	/**
	 * Check if the return of the method of the factory is the same in the console
	 */
	@Test
	public void testCreateDoor() {
		assertNotNull(MotionlessElementFactory.createDoor());
		assertEquals(MotionlessElementFactory.createDoor().getSprite().getConsoleImage(), 'O');
	}

	/**
	 * Check if the return of the method of the factory is the same in the console
	 */
	@Test
	public void testCreateUnbreakableWall() {
		assertNotNull(MotionlessElementFactory.createUnbreakableWall());
		assertEquals(MotionlessElementFactory.createUnbreakableWall().getSprite().getConsoleImage(), 'X');
	}

	/**
	 * Check if the return of the method of the factory is the same in the console
	 */
	@Test
	public void testCreateWall() {
		assertNotNull(MotionlessElementFactory.createWall());
		assertEquals(MotionlessElementFactory.createWall().getSprite().getConsoleImage(), 'W');
	}

	/**
	 * Check if the getFromFileSymbol is the same character in getSprite
	 */
	@Test
	public void testGetFromFileSymbol() {
		assertNotNull(MotionlessElementFactory.getFromFileSymbol('W'));
		assertEquals(MotionlessElementFactory.getFromFileSymbol('W').getSprite().getImage(), 
				MotionlessElementFactory.createWall().getSprite().getImage() );
	}
	

}
