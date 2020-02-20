import edu.duke.*;
import java.util.*;
/**
 * Write a description of class CharactersInPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CharactersInPlay
{ private ArrayList<String> myCharacters;
    private ArrayList<Integer> myFreqs;
    
    public CharactersInPlay() {
        myCharacters = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void update(String person){
        int index = myCharacters.indexOf(person);
            if (index == -1){
                myCharacters.add(person);
                myFreqs.add(1);
            }
            else{
                 int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
            
    }
    public void findAllCharacters(){
        FileResource fr=new FileResource();
        for(String line:fr.lines())
        {   line=line.trim();
            int ind=line.indexOf(".");
            if(ind!=-1)
            {update(line.substring(0,ind));
            }
            
    }
    
   
}
public void tester(){
    findAllCharacters();
    for(int i=0;i<myCharacters.size();i++){
        String character =myCharacters.get(i);
        int count=myFreqs.get(i);
        if(count>1)
        System.out.println(character+" "+count);
    }
    System.out.println("enter num1 and num2 for method charactersWithNumParts(int num1,int num2)");
    Scanner sc=new Scanner(System.in);
    int num1=sc.nextInt();
    int num2=sc.nextInt();
    charactersWithNumParts(num1,num2);
}
public void charactersWithNumParts(int num1,int num2){
    
    if(num1<=num2){
    for(int i=0;i<myCharacters.size();i++){
        String character =myCharacters.get(i);
        int count=myFreqs.get(i);
        if(count>=num1&&count<=num2)
        System.out.println(character+" "+count);
    }
}
else
System.out.println("num1 is > num2");

}
}
