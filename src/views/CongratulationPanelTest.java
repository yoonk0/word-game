
package views;
import java.awt.*;
import  static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.fest.swing.fixture.*;
import org.junit.*;

public class CongratulationPanelTest {
private FrameFixture ls;
	
	@Before
	public void setUp() {
		Image image=null;
		try {
			image = ImageIO.read(new File("images/end/finishLesson/lessonfinished.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated cat
			
			e1.printStackTrace();
		}

	  CongratulationsPanel cpanel = null;
		try {
			cpanel = new CongratulationsPanel(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame();
		frame.add(cpanel);
		ls = new FrameFixture(frame);
		ls.show();
	}
	@After
	public void tearDown() {
		ls.cleanUp();
	}
	
	@Test
	public void testLessonMenuNotNull() {
		
	  assertNotNull("LessonMenu creation cannot be null", ls);
	}
}

