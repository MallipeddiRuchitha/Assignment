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
public class TestClass implements Interface  {
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
    testClassObj.method1(testClassObj);
    testClassObj.method2(testClassObj);
    testClassObj.method3(testClassObj);
    testClassObj.method4(testClassObj);



}
}
