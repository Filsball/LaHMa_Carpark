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
	public void Testtest() {
		String[]sequence = {"A","G"};
		s.isWellSorted(sequence);
		
		
		
	}

}
