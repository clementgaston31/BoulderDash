package model.DAO;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Map;

public class DAOMapTest {

	final DBProperties dbProperties = new DBProperties();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/*@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testFind() throws SQLException, IOException {
		Map map;
		final int idMapExpected = 999;
		final int widthExpected = 5;
		final int heightExpected = 2;
		final int playerStartXExpected = 3;
		final int playerStartYExpected = 1;
		final String StringMapExpected = "HELLO\r\nWORLD";
		final String sql = "{call MapById(?)}";
		final CallableStatement call = DriverManager.getConnection(dbProperties.getURL(), dbProperties.getLogin(), dbProperties.getPassword()).prepareCall(sql);
		call.setInt(1, idMapExpected);
		call.execute();
		ResultSet resultSet = call.getResultSet();
		if (resultSet.first()) {
		map = new Map(resultSet.getInt("idMap"), resultSet.getInt("width"), resultSet.getInt("height"), resultSet.getInt("playerStartX"), resultSet.getInt("playerStartY"), resultSet.getString("StringMap"));
		assertEquals(idMapExpected, map.getIdMap());
		assertEquals(widthExpected, map.getWidth());
		assertEquals(heightExpected, map.getHeight());
		assertEquals(playerStartXExpected, map.getPlayerStartX());
		assertEquals(playerStartYExpected, map.getPlayerStartY());
		assertEquals(StringMapExpected, map.getMapFromBDD());
		}
	}
}
