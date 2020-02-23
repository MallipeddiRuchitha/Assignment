/*Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. Add a balance( ) method to Unicycle and Bicycle, but not to Tricycle. Create instances of all three types and upcast them to an array of Cycle. Try to call balance( ) on each element of the array and observe the results. Downcast and call balance( ) and observe what happens.
*/

        package assignment.cycle;

public class TestCycle {
    public static void main(String[] args){
        Cycle [] cycleArray=new Cycle[3];
        cycleArray[0]=(Cycle)new Unicycle();
        cycleArray[1]=(Cycle)new Bicycle();
        cycleArray[2]=(Cycle)new Tricycle();
        System.out.println("After Upcasting");
        //the following 3 statements  will give  "cannot resolve balance in cycle"  error
        cycleArray[0].balance();
        cycleArray[1].balance();
        cycleArray[2].balance();



        cycleArray[0]=new Unicycle();
        cycleArray[1]=new Bicycle();
        cycleArray[2]=new Tricycle();
        //the following 3 statements  will give  "cannot resolve balance in cycle"  error
        cycleArray[0].balance();
        cycleArray[1].balance();
        cycleArray[2].balance();


    }
}
