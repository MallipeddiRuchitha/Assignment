
public class Part1{
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
public void testFindStopCodon(){
     System.out.println("startCodon    stopcodon        dna");
    System.out.println("ATG"+"       "+"TAA"+"  "+"GCTATGCGACTATAA"+"   "+findStopCodon("GCTATGCGACTATAA",3,"TAA"));
    System.out.println("ATG"+"       "+"GCA"+"  "+"CGCTATGCGACTATAA"+"   "+findStopCodon("CGCTATGCGACTATAA",5,"GCA"));
    
    System.out.println("ATG"+"       "+"TAA"+"  "+"GCTATGGGCGTAGTAACCTAA"+"   "+findStopCodon("GCTATGGGCGTAGTAACCTAA",3,"TAA"));
    System.out.println("ATG"+"        "+"TAA"+"  "+"GCTAAATGCGCGTCGTAAGTAA"+"   "+findStopCodon("GCTAAATGCGCGTCGTAAGTAA",3,"TAA"));
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
public void testFindGene(){
     System.out.println("ATCGTACGT"+"  "+findGene("ATCGTACGT"));
      System.out.println("ATGAGCGCTTAA"+"  "+findGene("ATGAGCGCTTAA"));
       System.out.println("ATGGCTTGATAATCGTAG"+"  "+findGene("ATGGCTTGATAATCGTAG"));
        System.out.println("ATGGTTAAGTAG"+"  "+findGene("ATGGTTAAGTAG"));
         System.out.println("ATGAGCGCTAATGCATGA"+"  "+findGene("ATGAGCGCTAATGCATGA"));
       
     
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
}