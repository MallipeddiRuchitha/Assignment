package textgen;

import static org.junit.Assert.assertEquals;

public class TestLinkedList {
public static void main(String[] args) {
	/*MyLinkedList<Integer> list1=new  MyLinkedList();
	list1 = new MyLinkedList<Integer>();
	list1.add(65);
	list1.add(21);
	list1.add(42);
	int a = list1.remove(0);
	System.out.println( "65  "+ a);
	System.out.println("21  "+list1.get(0));
	System.out.println( "2  "+list1.size());*/
	MyLinkedList<String> testList=new MyLinkedList<String>();
    testList.add("A");
    testList.add("B");
    
    System.out.println( "2  "+testList.size());
    testList.remove(1);
    System.out.println( "1  "+testList.size());
	
}

}