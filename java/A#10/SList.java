
/*
Generics, Arrays and Containers

Create a generic, singly linked list class called SList, which, to keep things simple, does not implement the List interface.

Each Link object in the list should contain a reference to the next element in the list, but not the previous one (LinkedList, in contrast, is a doubly linked list, which means it maintains links in both directions).

Create your own SListIterator which, again for simplicity, does not implement ListIterator. The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.

The only way to insert and remove elements from an SList is through SListIterator. Write code to demonstrate SList.
 */
package assignment;

public class SList<E> {
    public SListIterator getListIterator(){
        SListIterator<E> sListIterator=new SListIterator();
        return (sListIterator);
    }


}
class LNode<E>
{

    LNode<E> next;
    E data;




    public LNode(E data)
    {
        this.data = data;

        this.next = null;
    }

}
class SListIterator<E> {
    LNode <E> head;
    LNode <E> tail;
    int size;
    public SListIterator(){

        head=null;
        tail=null;
        size=0;

    }

    /**
     *
     * @param index position at which new node must be inserted
     * @param element represents data of the node which will be inserted at given index
     */
    //the add method add's the element at given index
    public void add(int index, E element )
    {

        if(element==null) {
            throw new NullPointerException();
        }
        if(index<0||index>size)
            throw new IndexOutOfBoundsException();

        LNode newNode=new LNode(element);
        if(head==null)
        {
            head=newNode;
            tail=newNode;
        }
        else if(index==0) {
            newNode.next=head;

            head=newNode;
        }
        else if(index==size) {
            tail.next=newNode;



            tail=newNode;


        }
        else {
            LNode  temp=head;

            int count=1;
            while(count<index)
            {
                count++;
                temp=temp.next;

            }

            newNode.next=temp.next;

            temp.next=newNode;


        }
        size++;







    }

    /**
     *
     * @param index represents position from where node must be deleted
     * @return data value of the deleted node
     */
    //the remove method deletes node at given index
    public E remove(int index)
    {

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


        }


        else {
            LNode  temp=head;

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

                temp.next=temp.next.next;
            }

        }
        size--;



        return data;
    }

    /**
     *
     * @param index represents index position of the node whose value must be returned
     * @return data value of the node at given index
     */

    public E get(int index)
    {

        if(index<0||index>=size)
            throw new IndexOutOfBoundsException();
        LNode temp=head;

        int count=0;


        while(count<index)
        {


            count++;
            temp=temp.next;

        }

        return (E)temp.data;
    }


}