package assignment.rodent;

public class Hamster extends Rodent{
    public Hamster(){
        System.out.println("Hamster");
    }

    @Override
    public String longevity() {
        return "2-3 years";
    }

    @Override
    public String foodType() {
        return "omnivores";
    }




}
