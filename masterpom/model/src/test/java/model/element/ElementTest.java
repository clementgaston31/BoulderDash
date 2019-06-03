package model.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ElementTest {
	
	private Element element;
	final Sprite sprite = new Sprite('X', "player");
	private Permeability permeability = Permeability.BLOCKING;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

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

	@Test
	public void testGetPermeability() {
		assertNotNull(permeability);
		assertEquals(permeability, element.getPermeability());
	}

	@Test
	public void testSetSprite() {
		this.element.setSprite(sprite);
		assertEquals(sprite, this.element.getSprite());
		
		
	}

	@Test
	public void testGetImage() {
		
	}
	
	@Test
	public void testSetPermeability() {
		this.element.setPermeability(Permeability.BLOCKING);
		assertEquals(permeability, this.element.getPermeability());
		
		
	}
	
	

}
