import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

public class SortTest {

	@Test
	public void testSort1()
	{
		Sort a = new Sort();
		Integer[] b = new Integer[] {1,0,2,6,9,1,2,4,5};
		a.sort(b);
		assertEquals("[0, 1, 1, 2, 2, 4, 5, 6, 9]", Arrays.toString(b));
	}
	
	@Test
	public void testSort2()
	{
		Sort a = new Sort();
		Integer[] b = new Integer[] {};
		a.sort(b);
		assertEquals("[]", Arrays.toString(b));
	}
	
	@Test
	public void testSort3()
	{
		Sort a = new Sort();
		Integer[] b = new Integer[] {1};
		a.sort(b);
		assertEquals("[1]", Arrays.toString(b));
	}
	
	@Test
	public void testSort4()
	{
		Sort a = new Sort();
		Integer[] b = new Integer[] {5,4,3,2,1,0};
		a.sort(b);
		assertEquals("[0, 1, 2, 3, 4, 5]", Arrays.toString(b));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
