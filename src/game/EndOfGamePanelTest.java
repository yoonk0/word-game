package game;

import java.awt.*;
import  static org.junit.Assert.*;



import javax.swing.JFrame;

import org.fest.swing.fixture.*;
import org.junit.*;


public class EndOfGamePanelTest {

	private FrameFixture eog;

	@Before
	public void setUp() {
		EndOfGamePanel epanel = null;
			try {
				epanel = new EndOfGamePanel();
			} catch (Exception e) {
				e.printStackTrace();
			}
			JFrame frame = new JFrame();
			frame.add(epanel);
			eog = new FrameFixture(frame);
			eog.show();
		}
		@After
		public void tearDown() {
			eog.cleanUp();
		}

	
		
	@Test
	public void testEndOfGameNotNull() {
		
	  assertNotNull("EndOfGamePanel creation cannot be null", eog);
	}
}