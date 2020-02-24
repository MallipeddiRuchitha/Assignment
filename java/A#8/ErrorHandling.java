/*
Error Handling

Create three new types of exceptions. Write a class with a method that throws all three.
In main( ), call the method but only use a single catch clause that will catch all three types of exceptions. Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown.
 */


package assignment;
import java.util.*;
public class ErrorHandling {

 public void throwException()throws Exception{


     System.out.println("Select the exception to be thrown");
     System.out.println("1:UserException1");
     System.out.println("2:UserException2");
     System.out.println("3:UserException3");
     System.out.println("4:NullPointerException");
     System.out.println("enter the number");

     Scanner sc=new Scanner(System.in);
     int exceptionNumber=sc.nextInt();
     switch(exceptionNumber){

         case 1:
         throw new UserException1("UserException1");

         case 2:
         throw new UserException2("UserException2");

         case 3:
         throw new UserException3("UserException3");

         case 4:
             throw new NullPointerException();

     }

 }
 public static void main(String[] args){
     ErrorHandling errorHandling=new ErrorHandling();
     try {
         errorHandling.throwException();
     }
     catch(Exception e) {
         System.out.println(e.getMessage());
     }

     //finally  clause is executed ,even if a null pointer exception is thrown
     finally{
         System.out.println("In finally block");
     }


 }

}
// A new type of exception can be created by extending Exception class
 class UserException1 extends Exception{
    public  UserException1(String message){
        super(message);
        //it calls Exception class constructor
        }

}

 class UserException2 extends Exception{
    public  UserException2(String message){
          super(message);
    }


}
class UserException3 extends Exception{
    public  UserException3(String message){
         super(message);
    }
}


