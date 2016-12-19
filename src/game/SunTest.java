package game;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class SunTest {
	@Test
	public void testSunOriginalOpacity() 
	
	{
			Sun s = new Sun(); 
		
		    int actual = (int) s.getOpacity();
		   
			 assertEquals("test the original opacity", 1, actual);
			
		}
	
	@Test
	public void testSunSizeWidth() 
	
	{   Random rand= new Random();
	       int n = rand.nextInt();
			Sun s = new Sun(); 
		   	  s.setSizeWidth(n);
	        int actualx = (int) s.getSizeWidth();
			 assertEquals("test the original opacity", n, actualx);
			
		}
	
	@Test
	public void testtwoSunNotSame() 
	
	{
		Random rand= new Random();
	       int n = rand.nextInt();
			Sun s = new Sun(); 
		   	  s.setSizeWidth(n);
		   	  s.setX(n);
		       s.setOpacity(n);
		   
		      Sun s2 = new Sun();
		     s2.setX(n);
		     s2.setOpacity(n);
		     s2.setSizeHeight(n);
		     s2.setSizeWidth(n);
		     
		     assertNotSame("should not be same Object",s, s2);
			
		}
	
	
	@Test
	public void testSunSetXSame() 
	{
		Sun s = new Sun(); 
		Sun s2 = new Sun();
		  s.setX(2);
		  s2.setX(2);
		 int s_X= s.getX();
		 int s2_X= s2.getX();
		 assertSame("set x for two sun equally should be same", s_X, s2_X); 
		 
		
	}

}
