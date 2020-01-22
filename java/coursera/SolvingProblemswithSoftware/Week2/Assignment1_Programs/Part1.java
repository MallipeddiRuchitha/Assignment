 

import java.util.*;
/**
 * Write a description of class Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1
{
    // instance variables - replace the example below with your own
    public String findSimpleGene(String dna){
        String result="";
        int initial=dna.indexOf("ATG");
        
        int last=dna.indexOf("TAA",initial+3);
        
        if(initial!=-1&&last!=-1&&(last-initial)%3==0){
            return dna.substring(initial,last+3);
            
            
            
        }
        return result;
        
}
 public void testSimpleGene(){
     String dna[]=new String[5];
      dna[0]="ACCGTGTCTAAATAGTA";
      dna[1]="ATGCCGACGCCGOCOGCTCGGT";
      dna[2]="ACGTCGAACGT.";
      dna[3]="ATGGCTTGCTAACAGAAA";
      dna[4]="ATGGCCGGCGTAAGCGAAGAC";
     for(int i=0;i<5;i++){
         System.out.print(dna[i]+"    ");
         System.out.println(findSimpleGene(dna[i]));
         
         
        }
     
     
     

}

}
