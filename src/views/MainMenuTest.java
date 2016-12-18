package views;
import java.awt.*;
import  static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.fest.swing.fixture.*;
import org.junit.*;

public class MainMenuTest {

private FrameFixture mm;
	
	@Before
	public void setUp() {
		
		MainMenu mmpanel= null;
		
		Image image = null;
		try {
			image = ImageIO.read(new File("images/dash/dashwith.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		mmpanel = new MainMenu(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame();
		frame.add(mmpanel);
		mm = new FrameFixture(frame);
		mm.show();
	}
	
	@After
	public void tearDown() {
		mm.cleanUp();
	}
	
	@Test
	public void testMainMenuNotNull() {
		
	  assertNotNull("MainMenu creation cannot be null", mm);
	}
	
	
		
	}