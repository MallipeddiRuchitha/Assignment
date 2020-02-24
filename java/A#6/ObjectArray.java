/*Create a class with a constructor that takes a String argument. During construction, print the argument. Create an array of object references to this class,
but don’t actually create objects to assign into the array.
When you run the program, notice whether the initialization messages from the constructor calls are printed.

   Complete the previous exercise by creating objects to attach to the array of references.*/



package assignment;

public class ObjectArray {
    public static void main(String[] args){
        //ObjectArray objectArrayObj=new ObjectArray();
        ObjectArray[] objArr=new ObjectArray[1];
        /*If objects are not created to assign into the array.
When you run the program,  the initialization messages from the constructor calls are  not printed.

         */
        objArr[0]=new ObjectArray("Object created");
    }

    public ObjectArray(String string){
        System.out.println(string);


    }
}
