package model.DAO;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test of the connection between eclipse and the dataBase.
 * 
 * @author Clément GASTON
 * @version 0.1
 */
public class DBConnectionTest {

	/** The instance of the connection to the dataBase. */
	DBConnection instance;

	/** The login of the dataBase. */
	DBProperties dbProperties;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new DBConnection();
		dbProperties = new DBProperties();

	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test of the instance.
	 */
/*	@Test
	public void testGetInstance() {
		
		final String expected = "com.mysql.jdbc.JDBC4Connection@5ecddf8f";
		assertNotNull(expected, instance.getConnection());
	}*/

	/*
	 * Test of the connection to the dataBase.
	 */
	/*@Test
	public void testGetConnection() throws SQLException {
		final String expected = "com.mysql.jdbc.JDBC4Connection@7cef4e59";
		assertEquals(expected, DriverManager
				.getConnection(dbProperties.getURL(), dbProperties.getLogin(), dbProperties.getPassword()).toString());
	}*/

}
