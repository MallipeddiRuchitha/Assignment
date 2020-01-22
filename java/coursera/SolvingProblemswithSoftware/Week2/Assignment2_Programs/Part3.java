
/**
 * Write a description of class Part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3
{
    public int findStopCodon(String dna,int startIndex,String stopCodon){
        int stopIndex;
        stopIndex=dna.indexOf(stopCodon,startIndex+3);
        while(stopIndex!=-1){
            if((stopIndex-startIndex)%3==0){
                return stopIndex;
                
                
    }
    stopIndex=dna.indexOf(stopCodon,stopIndex+3);
   
        
}
return dna.length();
}

    public String findGene(String dna){
    int firstIndex=dna.indexOf("ATG");
    if(firstIndex==-1){
        return "";
    
}
int lTAA=findStopCodon( dna,firstIndex,"TAA");
int lTAG=findStopCodon( dna,firstIndex,"TAG");
int lTGA=findStopCodon( dna,firstIndex,"TGA");
int stopIndex=Math.min(Math.min(lTAA,lTAG),lTGA);
if(stopIndex!=dna.length())
return dna.substring(firstIndex,stopIndex+3);
return "";

    
}
public void printAllGenes(String dna){
    String gene;
    while(true){
        gene=findGene(dna);
        if(gene=="")
        break;
        else{
            System.out.println(gene);
            dna=dna.substring((dna.indexOf(gene)+gene.length()));
        }
        
        
        
        
    }
}
public int countGenes(String dna){
     String gene;
     int count=0;
    while(true){
        gene=findGene(dna);
        if(gene=="")
        break;
        else{
            //System.out.println(gene);
            count++;
            dna=dna.substring((dna.indexOf(gene)+gene.length()));
        }
        
        
        
        
    }
    return count;
}
public void testCountGenes(){
    System.out.println("ATGTAAGATGCCCTAGT"+"         "+countGenes("ATGTAAGATGCCCTAGT"));
    System.out.println("ATGTAA"+"         "+countGenes("ATGTAA"));
    System.out.println("ATGTAC"+"         "+countGenes("ATGTAC"));
    System.out.println("ATGGCTTAATGTAG"+"         "+countGenes("ATGGCTTAATCGTAG"));
    
}

    

}
