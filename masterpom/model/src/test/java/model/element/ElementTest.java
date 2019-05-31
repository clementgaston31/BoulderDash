package model.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ElementTest {
	
	private Element element;
	final Sprite sprite = new Sprite('X', "player");

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
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Check if the element has a sprite
	 */
	
	@Test
	public void testGetSprite() {
		final Sprite expected = new Sprite('X', "player");
		
		Assert.assertEquals(expected.getClass(), element.getSprite().getClass());
	}

	@Test
	public void testGetPermeability() {
		final Permeability expected = Permeability.BLOCKING;
		
		assertEquals(expected, element.getPermeability());
	}

	@Test
	public void testSetSprite() {
		
	}

	@Test
	public void testGetImage() {
		
	}

}
