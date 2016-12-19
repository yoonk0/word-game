package game;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ElementTest {
	  Element e= new Element(5);
	  Element e1= new Element(5,5);
	  Element e2= new Element();

	@Test
	public void testdifferntElements(){
//	  Element e= new Element(5);
//	  Element e1= new Element(5,5);
//	  Element e2= new Element();
	  assertNotSame("should not be same Object", e, e2);
	  assertNotSame("should not be same Object", e1, e2);
	  assertNotSame("should not be same Object", e, e1);
	}
	
	
	@Test
	public void testSetSpeedandMove(){
		e2.setSpeed(3);
		e2.move();
		int actual=e.getX();
	    int expected = 5; 
	    
	    assertEquals("after movement x should be same", expected, actual);
	  
	}
	
	@Test
	public void testYandMovement(){
		e.setX(5);
		e.setY(2);
		e.move();
		int eX=e.getX();
		
		e1.setY(7);
		e1.move();
		int e1X=e1.getX();
	
		 assertEquals("y does not affect the movement", eX, e1X);
	}
	
}
