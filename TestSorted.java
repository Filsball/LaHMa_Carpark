package U02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TestSorted {

	
	Sortable s;
	
	@Before
	public void set(){
		s = new SortableImpl(new String[][] { {"A","C"},{"B","D"},{"C","E"},{"D","F"}});
		
	}
	
	@Test
	public void isWellSorted_firstElement_returnsTrue(){
		
		String[] sequence = {"A"};
		assertEquals(s.isWellSorted(sequence),true);
	}
	
	
	
	
	
	
	
	

}
