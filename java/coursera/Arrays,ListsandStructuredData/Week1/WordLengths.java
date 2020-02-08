
import edu.duke.*;
import java.util.*;
/**
 * Write a description of class WordLengths here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordLengths
{
  public int[] countWordLengths(FileResource resource,int []counts){
        Arrays.fill(counts,0);
        int countLength=counts.length;
        int currLength;
        for(String s:resource.words()){
            currLength=s.length();
            if(!Character.isLetter(s.charAt(currLength-1)))
            currLength--;
            if(!Character.isLetter(s.charAt(0)))
            currLength--;
            if(currLength>=countLength)
            counts[countLength-1]++;
            else
            counts[currLength]++;
            
    }
    return counts;
}
   public void  testCountWordLengths(){
       FileResource fr=new FileResource();
       int[] counts=new int[31];
       counts=countWordLengths(fr,counts);
       for(int i=0;i<counts.length;i++){
           System.out.println(counts[i]+" words of length "+""+i);
           
        }
        System.out.println("maximum word length is  "+indexOfMax(counts));
       
       
    }
    public int indexOfMax(int[] values){
        int maxInd=0;
        int maxLength=0;
        for(int i=1;i<values.length;i++){
            if(maxLength<values[i]){
                maxLength=values[i];
                maxInd=i;
            }
        }
        
        return maxInd;
        
    }
    
    
    
}
