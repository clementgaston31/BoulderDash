package model.element.motionlessElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

	@Test
	public void testCreateDirt() {
		assertNotNull(MotionlessElementFactory.createDirt());
		assertEquals(MotionlessElementFactory.createDirt().getSprite().getConsoleImage(), 'D');
	}

	@Test
	public void testCreateBackground() {
		assertNotNull(MotionlessElementFactory.createBackground());
		assertEquals(MotionlessElementFactory.createBackground().getSprite().getConsoleImage(), ' ');
	}

	@Test
	public void testCreateDoor() {
		assertNotNull(MotionlessElementFactory.createDoor());
		assertEquals(MotionlessElementFactory.createDoor().getSprite().getConsoleImage(), 'O');
	}

	@Test
	public void testCreateUnbreakableWall() {
		assertNotNull(MotionlessElementFactory.createUnbreakableWall());
		assertEquals(MotionlessElementFactory.createUnbreakableWall().getSprite().getConsoleImage(), 'X');
	}

	@Test
	public void testCreateWall() {
		assertNotNull(MotionlessElementFactory.createWall());
		assertEquals(MotionlessElementFactory.createWall().getSprite().getConsoleImage(), 'W');
	}

	@Test
	public void testGetFromFileSymbol() {
		assertNotNull(MotionlessElementFactory.getFromFileSymbol('W'));
		assertEquals(MotionlessElementFactory.getFromFileSymbol('W').getSprite().getImage(), 
				MotionlessElementFactory.createWall().getSprite().getImage() );
	}
	

}
