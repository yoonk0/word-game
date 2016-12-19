package game;
import java.awt.*;
import  static org.junit.Assert.*;

import javax.swing.JFrame;

import org.fest.swing.fixture.*;
import org.junit.*;

public class QuestionPanelTest {
	private FrameFixture qp;

	@Before
	public void setUp() {
		EndOfGamePanel qpanel = null;
			try {
				qpanel = new EndOfGamePanel();
			} catch (Exception e) {
				e.printStackTrace();
			}
			JFrame frame = new JFrame();
			frame.add(qpanel);
			qp = new FrameFixture(frame);
			qp.show();
		}
		@After
		public void tearDown() {
			qp.cleanUp();
		}

	
		
	@Test
	public void testQuestionPanelNotNull() {
		
	  assertNotNull("QuestionPanel creation cannot be null", qp);
	}

}
