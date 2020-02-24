package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		/*head=new LLNode(null);
		tail=new LLNode(null);
		size=0;
		head.next=tail;
		tail.prev=null;
		*/
		head=null;
		tail=null;
		size=0;

		
		// TODO: Implement this method
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element==null)
			throw new NullPointerException();
		LLNode tempNode=new LLNode(element);
		
		
		if(head==null)
		{
			head=tempNode;
			tail=tempNode;
		}
		else {
			tail.next=tempNode;
			tail.next.prev=tail;
			tail=tempNode;
			
		}
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index<0||index>=size)
			throw new IndexOutOfBoundsException();
		LLNode temp=head;
		
		int count=0;
		
		
		while(count<index)		
		{
			
				
			count++;
			temp=temp.next;
				
		}
		
		return (E)temp.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element==null)
			throw new NullPointerException();
		if(index<0||index>size)
			throw new IndexOutOfBoundsException();
		
		LLNode newNode=new LLNode(element);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
		}
		else if(index==0) {
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
		}
		else if(index==size) {
			tail.next=newNode;
		     newNode.prev=tail;
		     
		
			tail=newNode;
			
			
		}
		else {
			LLNode  temp=head;
			
			int count=1;
			while(count<index)		
			{
								count++;
				temp=temp.next;
					
			}
			
			newNode.next=temp.next;
			temp.next.prev=newNode;
			temp.next=newNode;
			newNode.prev=temp;
			
		}
		size++;

		
		
		
		
		
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index<0||index>=size)
			throw new IndexOutOfBoundsException();
		
		E data;
		if(size==1)
		{ data=head.data;
			head=null;
			tail=null;
			
		}
		else if(index==0)
		{
			data=head.data;
			head=head.next;
			head.prev=null;
			
		}
		
		
		else {
			LLNode  temp=head;
			
			int count=1;
			while(count<index)		
			{
								count++;
				temp=temp.next;
					
			}
			data=(E)temp.next.data;
			
			
			if(size-1==index) {
				temp.next=temp.next.next;
				tail=temp;
			}
			else {
				temp.next.next.prev=temp;
				temp.next=temp.next.next;
			}
			
		}
		size--;

		
		
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		E data;
		if(element==null)
			throw new NullPointerException();
		if(index<0||index>=size)
			throw new IndexOutOfBoundsException();
		LLNode  temp=head;
		
		int count=0;
		while(count<index)		
		{
							count++;
			temp=temp.next;
				
		}
		
		data=(E)temp.data;
		temp.data=element;
		
		return data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
