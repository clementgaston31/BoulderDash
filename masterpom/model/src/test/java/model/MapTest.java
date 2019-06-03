package model;;

public class MapTest {

	/*Map map = new Map(999, 5, 2, 3, 1, "X     \r\n    XX");
	Sprite spriteSpace = null;
	//IElement elementSpace = new Element(spriteSpace, Permeability.BLOCKING);
	Sprite spriteX = new Sprite('X', "Chapeau.png");
	//IElement elementX = new Element(spriteX, Permeability.BLOCKING);
	
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

	@Test
	public void testGetIdMap() {
		final int expected = 999;
		assertEquals(expected, map.getIdMap());
	}

	@Test
	public void testGetWidth() {
		final int expected = 5;
		assertEquals(expected, map.getWidth());
	}

	@Test
	public void testGetHeight() {
		final int expected = 2;
		assertEquals(expected, map.getHeight());
	}

	@Test
	public void testGetPlayerStartX() {
		final int expected = 3;
		assertEquals(expected, map.getPlayerStartX());
	}

	@Test
	public void testGetPlayerStartY() {
		final int expected = 1;
		assertEquals(expected, map.getPlayerStartY());
	}

	@Test
	public void testGetMapFromBDD() {
		final String expected = "X     \r\n" + "    XX";
		assertEquals(expected, map.getMapFromBDD());
	}

	@Test
	public void testLoadMap() throws IOException {
		final char expectedChar = 'X';
		final char expectedSpace = ' ';
		String line = map.getMapFromBDD();
		Reader inputString = new StringReader(line);
		BufferedReader reader = new BufferedReader(inputString);
		map.onTheMap = new IElement[map.getWidth()][map.getHeight()];
		line = reader.readLine();
		int y = 0;
		while (line != null) {
			for (int x = 0; x < map.getWidth(); x++) {
				map.setOnTheMapXY(getFromFileSymbol(line.toCharArray()[x]), x, y);
				
				if (line.toCharArray()[x] == 'X') {
					assertEquals(expectedChar, line.toCharArray()[x]);
				}
				
				if (line.toCharArray()[x] == ' ') {
					assertEquals(expectedSpace, line.toCharArray()[x]);
				}
			}
			line = reader.readLine();
			y++;
		}
		reader.close();
	}

	private IElement getFromFileSymbol(char c) {
		if (c == 'X')
		{
			//return elementX;
		}
		return null /*elementSpace*//*;
	}*/

	/*
	@Test
	public IElement testGetOnTheMapXY() {
		int x = 1;
		int y = 1;
		return map.onTheMap[x][y];
	}

	@Test
	public void testUpdateMap() {
		fail("Not yet implemented");
	}*/

}
