package views;

import java.awt.*;
import  static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.fest.swing.fixture.*;
import org.junit.*;
public class LessonMenuTest {
	
	private FrameFixture lsm;
	
	@Before
	public void setUp() {
		
		//LessonMenu lmpanel= null;
		
		Image image = null;
		try {
			image = ImageIO.read(new File("images/dash/dashwith.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LessonMenu lmpanel= null;
		try {
		lmpanel = new LessonMenu(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame();
		frame.add(lmpanel);
		lsm = new FrameFixture(frame);
		lsm.show();
	}
	
	@After
	public void tearDown() {
		lsm.cleanUp();
	}
	
	@Test
	public void testLessonMenuNotNull() {
		
	  assertNotNull("LessonMenu creation cannot be null", lsm);
	}
	
	
		
	}
	

