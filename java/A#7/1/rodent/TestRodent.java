package assignment.rodent;

public class TestRodent {
    public static void main(String[] args){
        Rodent[] rodentArr = new Rodent[3];
        rodentArr[0]=new Mouse();
        rodentArr[1]=new Gerbil();
        rodentArr[2]=new Hamster();
for(int i=0;i<3;i++){
    System.out.println(rodentArr[i].foodType()+"  "+rodentArr[i].longevity());
}
    }




}
