package views;
import static org.junit.Assert.assertNotNull;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InitFrameTest {
	
	private FrameFixture inif;
	
	@Before
	public void setUp() {
		try {
			inif = new FrameFixture( new InitFrame());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inif.show();
	}
	
	@After
	public void tearDown() {
		inif.cleanUp();
	}

	@Test
	public void testInitFrameNotNull() {
		
		assertNotNull("LessonMenu creation cannot be null", inif);
		}
}

