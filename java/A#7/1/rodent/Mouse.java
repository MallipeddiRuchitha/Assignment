package assignment.rodent;

public class Mouse extends Rodent {
    public Mouse(){
        System.out.println("Mouse");
    }

    @Override
    public String longevity() {
        return "2-7 years";
    }


    @Override
    public String foodType() {

    return "omnivores";

    }

}
