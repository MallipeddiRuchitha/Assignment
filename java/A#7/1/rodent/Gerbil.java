package assignment.rodent;

public class Gerbil extends Rodent {
    public  Gerbil(){
        System.out.println("Gerbil");
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
