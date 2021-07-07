
package assignment.cycleFactories;

public class TestFactories {
    public static void main(String[] args) {


    UniCycleFactory uniCycleFactoryObj = new UniCycleFactory();
    UniCycle uniCycleObj = uniCycleFactoryObj.getUnicycleObj();
    //it prints "UniCycle move"
       System.out.println( uniCycleObj.move());
        //it prints "UniCycle stop"
        System.out.println( uniCycleObj.stop());

        BiCycleFactory biCycleFactoryObj = new BiCycleFactory();
        BiCycle biCycleObj = biCycleFactoryObj.getBicycleObj();
        //it prints "BiCycle move"
        System.out.println( biCycleObj.move());
        //it prints "BiCycle stop"
        System.out.println( biCycleObj.stop());

        TriCycleFactory triCycleFactoryObj = new TriCycleFactory();
        TriCycle triCycleObj = triCycleFactoryObj.getTricycleObj();
        //it prints "TriCycle move"
        System.out.println( triCycleObj.move());
        //it prints "TriCycle stop"
        System.out.println( triCycleObj.stop());




}






}
