package assignment;
interface Interface1{
    void I1Method1();
    void I1Method2();
}
interface Interface2{
    void I2Method1();
    void I2Method2();
}
interface Interface3{
    void I3Method1();
    void I3Method2();
}
interface Interface extends Interface1,Interface2,Interface3{
    void IMethod();
}
class ConcreteClass{
    public ConcreteClass(){
        System.out.println("Concrete class constructor");
    }
    public void mathod(){
        System.out.println("concrete class method");

    }

}
public class TestClass extends ConcreteClass  implements Interface {
   public void I1Method1(){
        System.out.println("I1method1");
    }
   public void I1Method2(){
        System.out.println("I1method2");
    }
    public void I2Method1(){
        System.out.println("I2method1");
    }
   public void I2Method2(){
        System.out.println("I2method2");
    }
   public void I3Method1(){
        System.out.println("I3method1");
    }
   public void I3Method2(){
        System.out.println("I3method2");
    }
   public void IMethod(){
        System.out.println("Imethod");
    }
    public void method1(Interface1 interface1){
        System.out.println("method1");

    }
    public void method2(Interface2 interface2){
        System.out.println("method2");

    }
    public void method3(Interface3 interface3){
        System.out.println("method3");

    }
    public void method4(Interface nterfaceI){
        System.out.println("method4");

    }


    public static void main(String[] args){
        TestClass testClassObj=new TestClass();
        //the following method prints "method1"
        testClassObj.method1(testClassObj);
        //the following method prints "method2"
        testClassObj.method2(testClassObj);
        //the following method prints "method3"
        testClassObj.method3(testClassObj);
        //the following method prints "method4"
        testClassObj.method4(testClassObj);



    }
}