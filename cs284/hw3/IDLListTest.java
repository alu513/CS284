/**
 * 
 * 
 * @author Alexander Lu
 * I pledge my Honor that I have abided by the Stevens Honor System
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class IDLListTest {
    
    @Test
    public void testAdd() {
        IDLList<Integer> t = new IDLList<Integer>();
        assertEquals("", t.toString());
        t.add(1);
        assertEquals("1 ", t.toString());
        t.add(2);
        t.add(3);
        assertEquals("3 2 1 ", t.toString());
    }
    
    @Test
    public void testAppend()
    {
        IDLList<Integer> t = new IDLList<Integer>();
        assertEquals("", t.toString());
        t.append(1);
        assertEquals("1 ", t.toString());
        t.append(2);
        t.append(3);
        assertEquals("1 2 3 ", t.toString());
    }
    
    @Test
    public void testAddAtIndex()
    {
        IDLList<Integer> t = new IDLList<Integer>();
        assertEquals("", t.toString());
        t.add(0,1);
        assertEquals("1 ", t.toString());
        t.add(0,2);
        t.add(2,3);
        assertEquals("2 1 3 ", t.toString());
        t.add(3,5);
        t.add(3,6);
        t.add(4,6);
        assertEquals("2 1 3 6 6 5 ", t.toString());
    }
    
    @Test
    public void testGetAtIndex()
    {
        IDLList<Integer> t = new IDLList<Integer>();
        t.add(0,1);
        t.add(0,2);
        t.add(2,3);
        assertEquals((Integer)2 , t.get(0));
        assertEquals((Integer)1 , t.get(1));
        assertEquals((Integer)3 , t.get(2));
    }
    
    @Test
    public void testGetHead()
    {
        IDLList<Integer> t = new IDLList<Integer>();
        t.add(0,1);
        t.add(0,2);
        t.add(2,3);
        assertEquals((Integer)2 , t.getHead());
    }
    
    @Test
    public void testGetLast()
    {
        IDLList<Integer> t = new IDLList<Integer>();
        t.add(0,1);
        t.add(0,2);
        t.add(2,3);
        assertEquals((Integer)3 , t.getLast());
    }
    
    @Test
    public void testGetSize()
    {
        IDLList<Integer> t = new IDLList<Integer>();
        assertEquals(0 , t.size());
        t.add(0,1);
        t.add(0,2);
        t.add(2,3);
        assertEquals(3 , t.size());
    }
    
    @Test
    public void testRemoveFirst()
    {
        IDLList<Integer> t = new IDLList<Integer>();
        t.add(0,1);
        t.add(0,2);
        t.add(2,3);
        t.remove();
        assertEquals("1 3 ", t.toString());
    }
    
    @Test
    public void testRemoveLast()
    {
        IDLList<Integer> t = new IDLList<Integer>();
        t.add(0,1);
        t.add(0,2);
        t.add(2,3);
        t.removeLast();
        assertEquals("2 1 ", t.toString());
    }
    
    @Test
    public void testRemoveAtIndex()
    {
        IDLList<Integer> t = new IDLList<Integer>();
        t.add(0,1);
        t.add(0,2);
        t.add(2,3);
        t.add(3,5);
        t.add(3,6);
        t.removeAtIndex(0);
        assertEquals("1 3 6 5 ", t.toString());
        t.removeAtIndex(2);
        assertEquals("1 3 5 ", t.toString());
        t.removeAtIndex(2);
        assertEquals("1 3 ", t.toString());
    }
    
    @Test
    public void testRemoveElement()
    {
        IDLList<Integer> t = new IDLList<Integer>();
        t.add(0,1);
        t.add(0,2);
        t.add(2,3);
        t.add(3,5);
        t.add(3,6);
        t.remove(2);
        assertEquals("1 3 6 5 ", t.toString());
        t.remove(4);
        System.out.println(t.toString());
        assertEquals("1 3 6 5 ", t.toString());
        t.remove(6);
        assertEquals("1 3 5 ", t.toString());
    }
    
    @Test
    public void testToString()
    {
        IDLList<Integer> t = new IDLList<Integer>();
        t.add(0,1);
        t.add(0,2);
        t.add(2,3);
        assertEquals("2 1 3 ", t.toString());
    }
}