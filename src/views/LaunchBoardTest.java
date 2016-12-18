package views;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;





public class LaunchBoardTest {
	

	 private LaunchBoard lb; 
	  
	   
		@Before
		public void setUp() {
			try {
				lb= new LaunchBoard();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		  
		@Test
		public void testReviewListNotNull() {
			assertNotNull("LaunchBoard cannot be null", lb);
		}
		
}
