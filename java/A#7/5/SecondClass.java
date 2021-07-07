package assignment;

public class SecondClass {

    public class InnerSecondClass extends FirstClass.InnerFirstClass {
        public InnerSecondClass(FirstClass firstClassObj ){
            //when u call super, constructor of FirstInnerClass which is a inner class of FirstClass is called;
            firstClassObj.super("inner second class");

        }

    }
    public static void main(String[] args){

        FirstClass firstClassObj=new FirstClass();

        SecondClass secondClassObj=new SecondClass();


        secondClassObj.new InnerSecondClass(firstClassObj);

    }
}
