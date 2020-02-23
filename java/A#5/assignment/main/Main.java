package yourname.assignment.main;

import yourname.assignment.data.DefaultInitialization;
import yourname.assignment.singleton.StaticInitialization;

public class Main {
    public static void main(String[] args){
        DefaultInitialization  defaultInitialization=new DefaultInitialization();
        defaultInitialization.print();
        defaultInitialization.printLocalVariables();
        StaticInitialization staticInitializationObj= StaticInitialization.assign("data");
        staticInitializationObj.print();
    }
}
