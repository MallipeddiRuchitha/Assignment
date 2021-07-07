package assignment.rodent;

public abstract class Rodent {
   private String colour;
   public Rodent(){
       System.out.println("Rodent");
   }
    public void setColour(String colour){
        this.colour=colour;

    }

    public String getColour(){
        return colour;
    }

    public  abstract String longevity();

    public String foodType(){
        return "few are omnivores and few are herbivores";
    }


}
