package model.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * <h1>The ElementTest Class.</h1>
 *
 * @author keivnBourdeau
 * @version 0.1
 */

public class ElementTest {
	
	/** The element */
	private Element element;
	
	/**The new sprite */
	final Sprite sprite = new Sprite('X', "player");
	
	/**The permeability*/
	private Permeability permeability = Permeability.BLOCKING;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the set up
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.element = new Element(sprite, Permeability.BLOCKING) {
		};
		this.element.setSprite(sprite);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Check if the element has a sprite
	 */
	
	@Test
	public void testGetSprite() {
		assertNotNull(sprite);
		
		assertEquals(sprite, element.getSprite());
	}

	/**
	 * Check if the element has a permeability
	 */
	@Test
	public void testGetPermeability() {
		assertNotNull(permeability);
		assertEquals(permeability, element.getPermeability());
	}

	/**
	 * Test the setSprite of the element
	 */
	@Test
	public void testSetSprite() {
		this.element.setSprite(sprite);
		assertEquals(sprite, this.element.getSprite());
		
		
	}

	/**
	 * Test if the element has an image
	 */
	@Test
	public void testGetImage() {
		
	}
	
	/**
	 * Test the setPermeability of the element
	 */
	@Test
	public void testSetPermeability() {
		this.element.setPermeability(Permeability.BLOCKING);
		assertEquals(permeability, this.element.getPermeability());
		
		
	}
	
	

}
