package game;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class MoneyTest {
	

	

	@Test
	public void testMoneyisFlag() {  
		
		Money p = new Money(5,6); 
		p.setFlag(true);
		assertTrue("test money as flag should be false", true);
		
		}
	
	@Test
	public void testMoneysetAlive() 
	
	{  
		Money p = new Money(5,6); 
		p.setLive(false);
		assertFalse("test money is not alive should be true",false);
	}
	
	@Test
	public void testMoneyOriginOpacity() 
	
	{
			Money m = new Money(5,6); 
		
		    int actual = (int) m.getOpacity();
			
			 assertEquals("test the original opacity", 1, actual);
			
		}
	
	@Test
	public void testMoneySetOpOpcaity() 
	
	{
		 Random rand= new Random();
	       int n = rand.nextInt();
			Money m = new Money(n,n); 
			int expected=2;
            m.setOpacity(expected);
		    int actual = (int) m.getOpacity();
			
			 assertEquals("test the setOpacity(float opacity) method in Money", expected, actual);
			
		}

	@Test
	public void testMoneySetOpSpeed() 
	
	{ Random rand= new Random();
      int n = rand.nextInt();
			Money m = new Money(n,n); 
			int expected=2;
            m.setOpSpeed(expected);
		    int actual = (int) m.getOpSpeed();
			
			 assertEquals("test the setOpSpeed(float opSpeed)  method in Money", expected , actual);
			
		}
}
	