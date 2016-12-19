package game;
import java.awt.*;
import  static org.junit.Assert.*;



import javax.swing.JFrame;

import org.fest.swing.fixture.*;
import org.junit.*;
public class GamePanelTest {

	private FrameFixture gp;

	@Before
	public void setUp() {
		EndOfGamePanel gpanel = null;
			try {
				gpanel = new EndOfGamePanel();
			} catch (Exception e) {
				e.printStackTrace();
			}
			JFrame frame = new JFrame();
			frame.add(gpanel);
			gp = new FrameFixture(frame);
			gp.show();
		}
		@After
		public void tearDown() {
			gp.cleanUp();
		}

	
		
	@Test
	public void testGamePanelNotNull() {
		
	  assertNotNull("GamePanel creation cannot be null", gp);
	}
}
