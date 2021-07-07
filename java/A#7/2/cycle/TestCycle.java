/*Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. Add a balance( ) method to Unicycle and Bicycle, but not to Tricycle. Create instances of all three types and upcast them to an array of Cycle. Try to call balance( ) on each element of the array and observe the results. Downcast and call balance( ) and observe what happens.
*/

        package assignment.cycle;

public class TestCycle {
    public static void main(String[] args){
        Cycle [] cycleArray=new Cycle[3];
        cycleArray[0]=new Unicycle();
        cycleArray[1]=new Bicycle();
        cycleArray[2]=new Tricycle();
        System.out.println("After Upcasting");
        //the following 3 statements  will give  "cannot resolve balance in cycle"  error because balance method is not there in Cycle class.
        cycleArray[0].balance();
        cycleArray[1].balance();
        cycleArray[2].balance();



        cycleArray[0]=(Unicycle)cycleArray[0];
        cycleArray[1]=(Bicycle)cycleArray[1];
        cycleArray[2]=(Tricycle)cycleArray[2];
      
        cycleArray[0].balance();
        cycleArray[1].balance();
            //the following statement will give an error because there is no balance method in TriCycle class.
        cycleArray[2].balance();


    }
}
