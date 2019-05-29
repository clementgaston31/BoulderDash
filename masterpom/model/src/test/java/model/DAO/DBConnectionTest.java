package model.DAO;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBConnectionTest {
	
	DBConnection instance = null;
	final DBProperties dbProperties = new DBProperties();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new DBConnection();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance() {
		final String expected = "model.DAO.DBConnection@3ada9e37";
		assertNotNull(expected, instance.toString());
	}

	@Test
	public void testGetConnection() throws SQLException {
		final String expected = "com.mysql.jdbc.JDBC4Connection@7cef4e59";
		assertEquals(expected, DriverManager.getConnection(dbProperties.getURL(), dbProperties.getLogin(), dbProperties.getPassword()).toString());
	}

}
