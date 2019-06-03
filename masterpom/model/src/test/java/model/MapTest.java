package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;;

/**
 * Test of the different getters of Map.java. 
 * @author Clément GASTON
 * @version 0.1
 */
public class MapTest {

	/** Create a new map. */
	Map map;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		map = new Map(999, 1, 5, 2, 3, 1, "XWD EJ*RO");
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test of the getter of the idMap.
	 */
	@Test
	public void testGetIdMap() {
		final int expected = 999;
		assertEquals(expected, map.getIdMap());
	}
	
	/**
	 * Test of the getter of the DiamondToGet.
	 */
	public void testGetDiamondToGet() {
		final int expected = 1;
		assertEquals(expected, map.getDiamondToGet());
	}

	/**
	 * Test of the getter of the Width.
	 */
	@Test
	public void testGetWidth() {
		final int expected = 5;
		assertEquals(expected, map.getWidth());
	}

	/**
	 * Test of the getter of the Height.
	 */
	@Test
	public void testGetHeight() {
		final int expected = 2;
		assertEquals(expected, map.getHeight());
	}

	/**
	 * Test of the getter of the PlayerStartX.
	 */
	@Test
	public void testGetPlayerStartX() {
		final int expected = 3;
		assertEquals(expected, map.getPlayerStartX());
	}

	/**
	 * Test of the getter of the PlayerStartY.
	 */
	@Test
	public void testGetPlayerStartY() {
		final int expected = 1;
		assertEquals(expected, map.getPlayerStartY());
	}

	/**
	 * Test of the getter of the MapFromBDD.
	 */
	@Test
	public void testGetMapFromBDD() {
		final String expected = "XWD EJ*RO";
		assertEquals(expected, map.getMapFromBDD());
	}
}
