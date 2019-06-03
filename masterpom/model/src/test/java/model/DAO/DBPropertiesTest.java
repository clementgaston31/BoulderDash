package model.DAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test of the different getters of the login of the dataBase.
 * 
 * @author Clem
 * @version 0.1
 */
public class DBPropertiesTest {

	/** The login of the dataBase. */
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

	/**
	 * Test of the getter of the URL.
	 */
	@Test
	public void testGetURL() {
		final String expected = "jdbc:mysql://localhost:3308/boulderdash?autoReconnect=true&useSSL=false";
		assertEquals(expected, dbproperties.getURL());
	}

	/**
	 * Test of the getter of the login.
	 */
	@Test
	public void testGetLogin() {
		final String expected = "root";
		assertEquals(expected, dbproperties.getLogin());
	}

	/**
	 * Test of the getter of the password.
	 */
	@Test
	public void testGetPassword() {
		final String expected = "";
		assertEquals(expected, dbproperties.getPassword());
	}

}
