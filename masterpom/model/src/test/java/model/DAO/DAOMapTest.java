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

/**
 * Test of the getter of the map from the dataBase.
 * @author Clément GASTON
 * @version 0.1
 */
public class DAOMapTest {

	/** The login of the dataBase. */
	DBProperties dbProperties;
	
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
		dbProperties = new DBProperties();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test if we got the correct map with the correct attributes of this one.
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public void testFind() throws SQLException, IOException {
		final int idMapExpected = 999;
		final int diamondToGetExpected = 1;
		final int widthExpected = 9;
		final int heightExpected = 1;
		final int playerStartXExpected = 4;
		final int playerStartYExpected = 1;
		final String StringMapExpected = "XWD EJ*RO";
		final String sql = "{call MapById(?)}";
		final CallableStatement call = DriverManager.getConnection(dbProperties.getURL(), dbProperties.getLogin(), dbProperties.getPassword()).prepareCall(sql);
		call.setInt(1, idMapExpected);
		call.execute();
		ResultSet resultSet = call.getResultSet();
		if (resultSet.first()) {
		map = new Map(resultSet.getInt("idMap"), resultSet.getInt("DiamondToGet"), resultSet.getInt("width"), resultSet.getInt("height"), resultSet.getInt("playerStartX"), resultSet.getInt("playerStartY"), resultSet.getString("StringMap"));
		assertEquals(idMapExpected, map.getIdMap());
		assertEquals(diamondToGetExpected, map.getDiamondToGet());
		assertEquals(widthExpected, map.getWidth());
		assertEquals(heightExpected, map.getHeight());
		assertEquals(playerStartXExpected, map.getPlayerStartX());
		assertEquals(playerStartYExpected, map.getPlayerStartY());
		assertEquals(StringMapExpected, map.getMapFromBDD());
		}
	}
}
