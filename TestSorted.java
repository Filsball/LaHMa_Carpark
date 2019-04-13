//package U02;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class TestSorted {

	
	Sortable s;
	
	@Before
	public void set(){
		s = new SortableImpl(new String[][] {{"A","C"},{"B","D"},{"C","E"},{"D","F"}});
		
	}
	
	@Test
	public void isWellSorted_FollowingElements_returnsFalse() {

		String[] sequence = {"A","B"};
		assertEquals(s.isWellSorted(sequence),true);


	}
	
    @Test(expected = NoSuchElementException.class)
	public void isWellSorted_NoSuchElement_ExceptionThrow() {
		String[]sequence = {"A","G"};
		s.isWellSorted(sequence);
	}
    
    @Test(expected = NullPointerException.class)
    public void isWellSorted_Null_NullPointer() {
    	String[] sequence = {"A",null};
    	s.isWellSorted(sequence);
    }
    
    @Test
    public void isWellSorted_twice_returnsfalse()
    {
    	String[] sequence = {"A","C","B","D","C"};
    	assertEquals(s.isWellSorted(sequence), false);
    }

}