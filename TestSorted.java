import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

//import static org.junit.Assert.assertEquals;
//import org.junit.Before;
//import org.junit.Test;



public class TestSorted {

	
	Sortable s;
	
	@Before
	public void setUp(){
		System.out.println("Hi");
		s = new SortableImpl(new String[][] { {"A","C"},{"B","D"},{"C","E"},{"D","F"}});
		
	}
	
	@Test
	public void isWellSorted_firstElement_returnsTrue(){
		
		String[] sequence = {"A"};
		System.out.println(s);
		assertEquals(s.isWellSorted(sequence),true);
	}
	
	
	
	
	
	
	
	

}
