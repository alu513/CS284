import static org.junit.Assert.*;

import org.junit.Test;

public class TreapTest {

	@Test
	public void test() {
		Treap<Integer> testTree = new Treap <Integer>();
		
		assertEquals(true, testTree.add (4 ,19));
		assertEquals(true, testTree.add (2 ,31));
		assertEquals(true, testTree.add (6 ,70));
		assertEquals(true, testTree.add (1));
		assertEquals(true, testTree.add (3 ));
		assertEquals(true, testTree.add (5 ));
		assertEquals(true, testTree.add (7 ));
		assertEquals(false, testTree.add (4 ,19));
		assertEquals(false, testTree.add (2 ,31));
		assertEquals(false, testTree.add (6 ,77));
		
		assertEquals(4, (int)testTree.find(4));
		assertEquals(null, testTree.find(10));
		
		assertEquals(true, testTree.delete(1));
		assertEquals(true, testTree.delete(5));
		assertEquals(true, testTree.delete(7));
		assertEquals(true, testTree.delete(2));
		assertEquals(false, testTree.delete(11));
		assertEquals(false, testTree.delete(12));
		assertEquals(false, testTree.delete(13));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
