
import edu.duke.*;
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
   
    if(Character.isUpperCase((dna.charAt(0)))){
    int firstIndex=dna.indexOf("ATG");
    if(firstIndex==-1){
        return "";
    
}
int indexTAA=findStopCodon( dna,firstIndex,"TAA");
int indexTAG=findStopCodon( dna,firstIndex,"TAG");
int indexTGA=findStopCodon( dna,firstIndex,"TGA");
int stopIndex=Math.min(Math.min(indexTAA,indexTAG),indexTGA);
if(stopIndex!=dna.length())
return dna.substring(firstIndex,stopIndex+3);
return "";}
else{
    int firstIndex=dna.indexOf("atg");
    if(firstIndex==-1){
        return "";
    
}
int indextaa=findStopCodon( dna,firstIndex,"taa");
int indextag=findStopCodon( dna,firstIndex,"tag");
int indextga=findStopCodon( dna,firstIndex,"tga");
int stopIndex=Math.min(Math.min(indextaa,indextag),indextga);
if(stopIndex!=dna.length())
return dna.substring(firstIndex,stopIndex+3);
return "";
    
}

    
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
public StorageResource getAllGenes(String dna){
    String gene;
    StorageResource sr=new StorageResource();
    
    
    while(true){
        gene=findGene(dna);
        if(gene=="")
        break;
        else{
            //System.out.println(gene);
            sr.add(gene);
            dna=dna.substring((dna.indexOf(gene)+gene.length()));
        }
        
        
        
        
    }
    return sr;
}
public float cgRatio (String dna){
    int total=0;
    int countCG=0;
    char character;
    for(int index=0;index<dna.length();index++){
        character=dna.charAt(index);
        if(character=='C'||character=='G'||character=='c'||character=='g')
        countCG++;
        total++;        
    }
    return((float)countCG/total);
    
    
}
public int countCTG(String dna){
    
    int index=dna.indexOf("CTG");
    int countCtg=0;
    while(index!=-1){
        countCtg++;
        index=dna.indexOf("CTG",index+3);
        
}
return countCtg;
}
public void printStorageResource(StorageResource r){
    for(String s:r.data()){
        System.out.print(s+"      ");
        
    
    
}   
}
public void testGetAllGenes( ){
    

    System.out.println("ATGTAAGATGCCCTAGT");
    StorageResource r=getAllGenes("ATGTAAGATGCCCTAGT");
    printStorageResource(r);
    System.out.println();
    System.out.println("ATGTAA");
    r=getAllGenes("ATGTAA");
    printStorageResource(r);
    System.out.println();
    System.out.println("ATGTAC");
    r=getAllGenes("ATGTAC");
    printStorageResource(r);
    System.out.println();
    
    
    
}
public void processGenes(StorageResource sr){
    int count_longer=0;
    int  count_higherCGA=0;
    int  longest_length=0;
    int length=0;
    for(String dna:sr.data()){
        length=dna.length();
        if(length>longest_length)
        longest_length=length;
        if(length>60){
            System.out.println("String in sr that are longer than 60 characters    "+dna);
            count_longer++;
            
        }
        if(cgRatio(dna)>0.35){
            System.out.println("String in sr whose C-G-ratio is higher than 0.35    "+dna);
            count_higherCGA++;
    }
}
System.out.println("number of Strings in sr that are longer than 60 characters  " +count_longer);
System.out.println("number of strings in sr whose C-G-ratio is higher than 0.35  "+count_higherCGA);   
System.out.println("length of the longest gene    "+longest_length);
}

public void testProcessGenes(){
    String dna;
    StorageResource sr;
    
    /*dna="ATGATTGAATAAATGGCTAA";
     sr=getAllGenes(dna);
     System.out.println(dna);
     processGenes(sr);
     dna="ATGATTTAAATGGCTAA";
     sr=getAllGenes(dna);
     System.out.println(dna);
     processGenes(sr);
     dna="ATGCCATAGATGCCATAG";
     sr=getAllGenes(dna);
     System.out.println(dna);
     processGenes(sr);
      dna="ATGCCATAGATGAAATAG";
     sr=getAllGenes(dna);
     System.out.println(dna);
     processGenes(sr);
     dna="ATGCCACCGTAGATGCCCACATAG";
     sr=getAllGenes(dna);
     System.out.println(dna);
     processGenes(sr);*/
     
     FileResource fr = new FileResource("tagFinder2/brca1line.fa");
       dna = fr.asString();
       System.out.print(dna);
       sr=getAllGenes(dna);
       processGenes(sr);
       
      
     
     
     
    
    
}

}