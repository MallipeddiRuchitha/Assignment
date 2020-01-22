 


/**
 * Write a description of class Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2
{
    
    public String findSimpleGene(String dna,String startCodon,String stopCodon){
        String result="";
        
        int initial=dna.indexOf(startCodon);
        
        int last=dna.indexOf(stopCodon,initial+3);
        
        if(initial!=-1&&last!=-1&&(last-initial)%3==0){
            return dna.substring(initial,last+3);
            
            
            
        }
        return result;
}
 public void testSimpleGene(){
     String dna[]=new String[5];
      dna[0]="ATGGCAAGTTAA";
      dna[1]="ATCAGCGCAGTCGCATAA";
      dna[2]="ATCTGCATGCATGCA";
      dna[3]="atggcaagttaa";
      dna[4]="catgcatcagcgcagt";
     for(int i=0;i<3;i++){
         
         System.out.print(dna[i]+"    ");
         System.out.print(findSimpleGene(dna[i],"ATG","TAA")+"   ");
         System.out.println(findSimpleGene(dna[i],"AGC","TAA")+"    ");
         
         
         
        }
         for(int i=3;i<5;i++){
         
         System.out.print(dna[i]+"    ");
         System.out.print(findSimpleGene(dna[i],"atg","taa")+"   ");
         System.out.println(findSimpleGene(dna[i],"agc","taa")+"    ");
         
         
         
        }
        
     
     
     

}
}
