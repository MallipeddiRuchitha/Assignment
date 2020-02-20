
/**
 * Write a description of class CodonCount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CodonCount
{
   private HashMap<String,Integer> codonMap;
   public CodonCount(){
       codonMap=new HashMap<String,Integer>();
       
    }
    public void BuildCodonMap(int start,String dna){
       codonMap.clear();
       for(int i=start;i<=dna.length()-3;i=i+3){
           String codon=dna.substring(i,i+3);
           if(codonMap.containsKey(codon))
           codonMap.put(codon,codonMap.get(codon)+1);
           else codonMap.put(codon,1);
        }
       
       
        
        
        
    }
    public String getMostCommonCodon(){
        int maxCount=0;
        String maxCodon="";
        for(String s:codonMap.keySet())
        
        {
            if(codonMap.get(s)>maxCount)
            {maxCount=codonMap.get(s);
                maxCodon=s;
            }
    }
    return maxCodon;
}
public void printCodonCounts (int start,int end){
    for(String s:codonMap.keySet())
        {
            if(codonMap.get(s)>=start&&codonMap.get(s)<=end)
            {System.out.println(s+"   "+codonMap.get(s));
            }
    
}
}
public void tester(){
    FileResource fr=new FileResource();
    for(String s:fr.words()){
        s=s.toUpperCase();
        System.out.println("Starting from 0");
        BuildCodonMap(0,s);
        System.out.println("Most common Codon "+getMostCommonCodon()+"count is"+codonMap.get(getMostCommonCodon()));
        System.out.println("Counts of codons between 1 and 5 inclusive are:");
        printCodonCounts (1,5);
        System.out.println("Starting from 1");
        BuildCodonMap(1,s);
         System.out.println("Most common Codon "+getMostCommonCodon()+"count is"+codonMap.get(getMostCommonCodon()));
        System.out.println("Counts of codons between 1 and 5 inclusive are:");
        printCodonCounts (1,5);
        System.out.println("Starting from 2");
        BuildCodonMap(2,s);
         System.out.println("Most common Codon "+getMostCommonCodon()+"count is"+codonMap.get(getMostCommonCodon()));
        System.out.println("Counts of codons between 1 and 5 inclusive are:");
        printCodonCounts (1,5);
        
        
    }
}
   
}
