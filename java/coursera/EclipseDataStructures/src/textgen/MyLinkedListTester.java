/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		//System.out.print(shortList.get(0));
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		// TODO: Add more tests here
		MyLinkedList<String> testList=new MyLinkedList<String>();
		try {
			testList.remove(1);
			fail("check IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			testList.remove(-1);
			fail("check IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		testList.add("A");
		
		assertEquals("Remove: check element A is correct ", "A", testList.remove(0));
		testList.add("A");
		testList.add("B");
		testList.add("C");
		assertEquals("Remove: check element B is correct ", "B", testList.remove(1));
		assertEquals("Remove: check element C is correct ", "C", testList.remove(1));
		assertEquals("Remove: check size is correct ", 1, testList.size());
		
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		MyLinkedList<String> testList=new MyLinkedList<String>();
		
		
		
		try {
			testList.add(null);
			fail("check NullPointerException");
		}
		catch (NullPointerException e) {
		
		}
		testList.add("A");
		assertEquals("Check first", "A", testList.get(0));
		testList.add("B");
		assertEquals("Check second", "B", testList.get(1));
		
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	
	{  MyLinkedList<String> testList=new MyLinkedList<String>();
	    testList.add("A");
	    testList.add("B");
	    
	    assertEquals("Check size",2, testList.size());
	    testList.remove(1);
	    assertEquals("Check size",1, testList.size());
	    
		// TODO: implement this test
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
MyLinkedList<String> testList=new MyLinkedList<String>();
		
		
		
		try {
			testList.add(0,null);
			fail("check NullPointerException");
		}
		catch (NullPointerException e) {
		
		}
		testList.add(0,"A");
		assertEquals("Check first", "A", testList.get(0));
		testList.add(1,"B");
		assertEquals("Check second", "B", testList.get(1));
		testList.add(1,"C");
		assertEquals("Check second", "C", testList.get(1));
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
MyLinkedList<String> testList=new MyLinkedList<String>();
		
		
		
		try {
			testList.add(0,null);
			fail("check NullPointerException");
		}
		catch (NullPointerException e) {
		
		}
		try {
			testList.add(-1,"A");
			fail("check IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			testList.add(1,"A");
			fail("check IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		testList.add(0,"A");
		assertEquals("Check first", "A", testList.set(0,"a"));
		assertEquals("Check get", "a", testList.get(0));
		testList.add("B");
		assertEquals("Check second", "B", testList.set(1,"b"));
		assertEquals("Check get", "b", testList.get(1));
		
		
		
		
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
