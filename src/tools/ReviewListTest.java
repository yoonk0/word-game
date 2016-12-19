package tools;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ReviewListTest {

   private ReviewList rl;
   ArrayList<String> expected = new ArrayList<>();
   ArrayList<String> actual = new ArrayList<>();
   
	@Before
	public void setUp() {
	  
		try {
			rl = new ReviewList("wordLists/test.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		expected.add("Arm");
		expected.add("Cheek");
		expected.add("Chin");
	}
	
	@Test
	public void testReviewListNotNull() {
		assertNotNull("ReviewList cannot be null", rl);
	}
	
	@Test
	public void testAddElement(){
		try {
			rl.addElement("yes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		expected.add("yes");
		actual = rl.getList();
		
		
		assertEquals("test the addElement() method in reviewList", expected, actual);
		
	}
	
	@Test
	public void testDeleteElement(){
		try {
			rl.deleteElement("yes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		expected.remove("yes");
		actual = rl.getList();
		

		
		assertEquals("test the deleteElement() method in reviewList", expected, actual);
		
	}
	
	@Test
	public void testGetList(){
//		actual.remove(actual.size() - 1);
//		expected = new ArrayList<>()
		actual = rl.getList();
		expected.add("yes");

		
		assertEquals("test the getList() method in reviewList", expected, actual);
		
//		for(int i = 0; i < expected.size(); i++){
//			assertEquals("test the getList() method in reviewList", expected.get(i), actual.get(i));
//		}
		

//		assertEquals("test the getList() method in reviewList", "Arm", actual.get(0));
		
	}	
	



	
	
}

