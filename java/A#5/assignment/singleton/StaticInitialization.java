package yourname.assignment.singleton;

public class StaticInitialization{
    String string;
    public static  StaticInitialization assign(String string){
        /*this.string =string;

         */
        //non static members cannot be accessed inside static functions;
       return new StaticInitialization();
    }
    public void  print(){
        System.out.println(string);
    }

}
