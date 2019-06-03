package model.element.mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.IMap;
import model.Map;
import model.element.Permeability;

/**
 * <h1>The PlayerTest Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */

public class PlayerTest {

	/** The player */
	private Player player;
	
	/** The player */
	private IMap map;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	/**
	 * Set up the map and then the player
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.map = new Map(10, 1, 3, 3, 2, 2, "   \r\n D \r\n   ");
		this.player = new Player(1, 1, map);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Check if the player has a sprite and a permeability
	 */
	@Test
	public void testPlayer() {
		assertNotNull(this.player.getSprite());
		
		Permeability expected1 = Permeability.BLOCKING;
		assertEquals(expected1, this.player.getPermeability());
	}
	

}
