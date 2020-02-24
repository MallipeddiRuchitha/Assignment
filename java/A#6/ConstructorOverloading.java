
/*
Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.
 */
package assignment;

public class ConstructorOverloading {
    public static void main(String[] args){
        ConstructorOverloading constructorOverloadingObj= new ConstructorOverloading();

    }
    public ConstructorOverloading(){
        //calling the constructor with single parameter
        this(5);
    }
    public ConstructorOverloading(int i){
        System.out.println(i);

    }
}
