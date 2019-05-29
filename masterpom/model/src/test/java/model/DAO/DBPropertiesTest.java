package model.DAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBPropertiesTest {

	private DBProperties dbproperties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.dbproperties = new DBProperties();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetURL() {
		final String expected = "jdbc:mysql://localhost:3308/boulderdash?autoReconnect=true&useSSL=false";
		assertEquals(expected, dbproperties.getURL());
	}

	@Test
	public void testGetLogin() {
		final String expected = "root";
		assertEquals(expected, dbproperties.getLogin());
	}

	@Test
	public void testGetPassword() {
		final String expected = "";
		assertEquals(expected, dbproperties.getPassword());
	}

}
