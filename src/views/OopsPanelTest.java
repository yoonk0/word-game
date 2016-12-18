package views;
import static org.junit.Assert.assertNotNull;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OopsPanelTest {
	

	
	private FrameFixture op;
	
    @Before
    public void setUp() {
	
	
    	OopsPanel oppanel= null;
		
		Image image = null;
		try {
			image = ImageIO.read(new File("images/end/oops/oops.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		oppanel = new OopsPanel(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame();
		frame.add(oppanel);
		op = new FrameFixture(frame);
		op.show();
	}
	
	@After
	public void tearDown() {
		op.cleanUp();
	}
	
	@Test
	public void testOopsPanelNotNull() {
		
	  assertNotNull("Oops panel cannot be null", op);
	}
	
	
		
	}
	

