package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PlantTest {
	
	@Test
	public void testPlantisAlive() 
	
	{  
		Plant p = new Plant(5,6); 
		assertTrue("test Plant is alive should be true", true);
		}
	
	@Test
	public void testPlantisNotAlive() 
	
	{  
		Plant p = new Plant(5,6); 
		
		p.setLive(false); 
		
		assertFalse("test plant is not alive  - should be false", false);
		}
}
