import org.apache.commons.csv.*;
import edu.duke.*;
import java.util.*;
import java.io.*;
/**
 * Write a description of class BabyNames here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BabyNames
{
  public void totalBirths(FileResource fr){
      int totalBirths=0;
      int totalBoys=0;
      int totalGirls=0;
      for(CSVRecord rec:fr.getCSVParser(false)){
          int numBorn=Integer.parseInt(rec.get(2));
          totalBirths+=numBorn;
          if(rec.get(1).equals("M")){
              totalBoys +=numBorn;
              
            }
            else{
                totalGirls +=numBorn;
            }
          
        }
        System.out.println("Number of girls names  "+totalGirls);
        System.out.println("Number of boys names  "+totalBoys);
        System.out.println("Total  names in the file "+totalBirths);
    }
    public void testTotalBirths(){
        FileResource fr=new FileResource();
        totalBirths(fr);
    }
    public int getRank(int year,String name,String gender){
        //String filename="yob"+year+"short.csv";
        String filename="yob"+year+".csv";
        //String filepath="us_babynames_small/testing/"+filename;
         String filepath="us_babynames/us_babynames_by_year/"+filename;
        FileResource fr=new FileResource(filepath);
        CSVParser parser=fr.getCSVParser(false);
        int rankF=0;
            int rankM=0;
        for(CSVRecord row:parser){
            
            if(row.get(1).equals("M")){
                rankM++;
            }
            else rankF++;
            
            if(row.get(0).equals(name)&&row.get(1).equals(gender)){
                if(gender.equals("M"))
                return rankM;
                else return rankF;
            }
        }
        return -1;
        
    }
    
    public void testgetRank(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter year");
        int year=sc.nextInt();
        System.out.println("Enter name");
        String name=sc.next();
        System.out.println("Enter gender");
        String gender=sc.next();
        System.out.println("Rank is "+getRank(year,name,gender));
    }
    
    public String getName(int year,int rank,String gender){
       // String filename="yob"+year+"short.csv";
       String filename="yob"+year+".csv";
        //String filepath="us_babynames_small/testing/"+filename;
         String filepath="us_babynames/us_babynames_by_year/"+filename;
        FileResource fr=new FileResource(filepath);
        
        CSVParser parser=fr.getCSVParser(false);
        int rankF=0;
            int rankM=0;
        for(CSVRecord row:parser){
            
            if(row.get(1).equals("M")){
                rankM++;
            }
            else rankF++;
            
            if(row.get(1).equals(gender)){
                if((gender.equals("M")&&rankM==rank)||(gender.equals("F")&&rankF==rank))
                return row.get(0);
                
            }
        }
      return   "NO NAME";
}
public void testGetName(){
    Scanner sc=new Scanner(System.in);
        System.out.println("Enter year");
        int year=sc.nextInt();
        System.out.println("Enter rank");
        int rank=sc.nextInt();
        System.out.println("Enter gender");
        String gender=sc.next();
        System.out.println("Name is "+getName(year,rank,gender));
}
public  String whatIsNameInYear(String name,int year,int newYear,String gender){
    int rank=getRank( year,name,gender);
   return getName(newYear,rank,gender); 
}
public void testWhatIsNameInYear(){
    Scanner sc=new Scanner(System.in);
        System.out.println("Enter year");
        int year=sc.nextInt();
        System.out.println("Enter name");
        String name=sc.next();
        System.out.println("Enter gender");
        String gender=sc.next();       
        System.out.println("Enter new year");
         int newYear=sc.nextInt();
    System.out.println(name+"  born in "+year+" would be "+whatIsNameInYear(name,year,newYear,gender)+" if she was born in  "+newYear);
}
public int yearOfHighestRank(String name,String gender){
    int maxRank=Integer.MAX_VALUE,rank,curYear,maxRankYear=-1;
    System.out.println("Select list of files");
    DirectoryResource dr=new DirectoryResource();
    for(File f:dr.selectedFiles()){
        FileResource fr=new FileResource(f);
        CSVParser parser=fr.getCSVParser();
        curYear=Integer.parseInt(f.getName().substring(3,7));
        
       rank= getRank(curYear,name,gender);
       if(rank==-1)
       return -1;
       if(rank<maxRank)
       { maxRank=rank;
           maxRankYear=curYear;
           //System.out.println(maxRank+"   "+maxRankYear);
        }
        
        
        
    }
    return maxRankYear;
    
}
public void testYearOfHighestRank(){
     Scanner sc=new Scanner(System.in);
       
        System.out.println("Enter name");
        String name=sc.next();
        System.out.println("Enter gender");
        String gender=sc.next();       
   System.out.println("Year of Highest Rank is "+yearOfHighestRank( name, gender));
}
public double getAverageRank(String name,String gender){
    int totalRank=0,numFiles=0,curYear,rank;
    System.out.println("Select list of files");
    DirectoryResource dr=new DirectoryResource();
    for(File f:dr.selectedFiles()){
        numFiles++;
        FileResource fr=new FileResource(f);
        CSVParser parser=fr.getCSVParser();
        curYear=Integer.parseInt(f.getName().substring(3,7));
        
       rank= getRank(curYear,name,gender);
       if(rank==-1)
       return -1;
       totalRank+= rank;
       
        
        
        
    }
    return(((double)totalRank)/numFiles);
}
public void  testGetAverageRank(){
    Scanner sc=new Scanner(System.in);
       
        System.out.println("Enter name");
        String name=sc.next();
        System.out.println("Enter gender");
        String gender=sc.next();  
    System.out.println(getAverageRank(name,gender));
}
public int getTotalBirthsRankedHigher(int year,String name,String gender) {
     //String filename="yob"+year+"short.csv";
     String filename="yob"+year+".csv";
        //String filepath="us_babynames_small/testing/"+filename;
       String filepath="us_babynames/us_babynames_by_year/"+filename;
        FileResource fr=new FileResource(filepath);
        CSVParser parser=fr.getCSVParser(false);
        int rank=getRank(year,name,gender);
        int curRank,total=0;
        for(CSVRecord row:parser){
           
            if(row.get(1).equals(gender)){
                 curRank =getRank(year,row.get(0),gender);
                 if(curRank<rank)
                 total+= Integer.parseInt(row.get(2));
                 
            }
        }
        
        //System.out.println(total);
        return total;
        
        
        
}
public void testGetTotalBirthsRankedHigher()

{ Scanner sc=new Scanner(System.in);
    System.out.println("Enter name");
        String name=sc.next();
        System.out.println("Enter gender");
        String gender=sc.next(); 
        System.out.println("Enter year");
        int year=sc.nextInt();
        //System.out.println("before");
    System.out.println("Total births ranked higher "+getTotalBirthsRankedHigher(year,name,gender));
    //System.out.println("after");
}
}