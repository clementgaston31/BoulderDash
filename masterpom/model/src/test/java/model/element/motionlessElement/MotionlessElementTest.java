package model.element.motionlessElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.Permeability;

/**
 * <h1>The MotionlessElementTest Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */

public class MotionlessElementTest {
	
	/**The wall */
	private Wall wall;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Set up the wall
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.wall = new Wall();	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Check if the motionlessElement has a sprite and a permeability
	 */
	@Test
	public void testMotionlessElement() {
		assertNotNull(this.wall.getSprite());
		
		Permeability expected1 = Permeability.BLOCKING;
		assertEquals(expected1, this.wall.getPermeability());
	}

}
