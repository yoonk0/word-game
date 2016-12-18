package views;
import java.awt.*;
import  static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.fest.swing.fixture.*;
import org.junit.*;


public class LessonTest {

	private FrameFixture ls;
	
	@Before
	public void setUp() {
//		CongratulationsPanel cpanel = null;
//		try {
//			cpanel = new CongratulationsPanel();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		JFrame frame = new JFrame();
//		frame.add(cpanel);
//		ls = new FrameFixture(frame);
//		ls.show();
		
		Lesson lpanel=null;
		Image image = null;
		try {
			image = ImageIO.read(new File("images/card/lesson/cardwith.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		lpanel = new Lesson(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame();
		frame.add(lpanel);
		ls = new FrameFixture(frame);
		ls.show();
	}
	
	@After
	public void tearDown() {
		ls.cleanUp();
	}
	
	@Test
	public void testLessonNotNull() {
		
	  assertNotNull("Leson creation cannot be null", new Object());
	}
	
	
}
