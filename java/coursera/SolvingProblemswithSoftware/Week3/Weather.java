
/**
 * Write a description of class Weather here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import org.apache.commons.csv.*;
import edu.duke.*;
import java.io.*;
import java.util.*;
public class Weather
{
   public  CSVRecord coldestHourInFile(CSVParser parser){
       CSVRecord coldestSoFar=null;
       double coldestTemperature=Integer.MAX_VALUE;
       double currentTemp;
       for(CSVRecord row:parser){
           if(coldestSoFar==null){
               coldestSoFar=row;
               coldestTemperature=Double.parseDouble(coldestSoFar.get("TemperatureF"));
            }
            else{
                currentTemp=Double.parseDouble(row.get("TemperatureF"));
                if(currentTemp<coldestTemperature&&currentTemp!=-9999){
                    coldestTemperature=currentTemp;
                    coldestSoFar=row;
                    
                }
               
            }
            
            
        }
        return coldestSoFar;
    }
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldRecord=coldestHourInFile(parser);
        System.out.println(coldRecord.get("DateUTC")+"   "+coldRecord.get("TemperatureF"));
    }
    public String fileWithColdestTemperature(){
        DirectoryResource dr=new DirectoryResource();
        double lowTemperature=Integer.MAX_VALUE;
        double curTemperature;
        
       String  lowTempFileName="";
        for (File f : dr.selectedFiles()){
           FileResource fr=new FileResource(f);
           curTemperature=Double.parseDouble(coldestHourInFile(fr.getCSVParser()).get("TemperatureF"));
            if(curTemperature<lowTemperature)
            { lowTemperature=curTemperature;
               lowTempFileName=f.getPath();
               
               
               
                
            }
        }
        return lowTempFileName;
    }
    public void  testFileWithColdestTemperature(){
       // DirectoryResource dr=new DirectoryResource();
        CSVParser parser;
       String fpath=fileWithColdestTemperature();
      System.out.println("Coldest day was in file "+fpath);
        FileResource fr=new FileResource(fpath);        
            parser = fr.getCSVParser();
            CSVRecord record=coldestHourInFile(parser);
            System.out.println("Coldest temperature on that day was "+record.get("TemperatureF"));
            System.out.println("All the Temperatures on the coldest day were:");
            parser = fr.getCSVParser();
            for(CSVRecord row:parser){
                System.out.println(row.get("DateUTC")+" "+row.get("TemperatureF"));
            }
           
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        double lowestHumidity=Double.MAX_VALUE;
        double curHumidity;
        CSVRecord  lowestHumidityRecord=null;
       for(CSVRecord row:parser){
           String humidity=row.get("Humidity");
           if(humidity.equals("N/A"))
           continue;
           curHumidity=Double.parseDouble(humidity);
           if( curHumidity<lowestHumidity)
           {  
              lowestHumidity =curHumidity; 
              lowestHumidityRecord=row;
        }
        
    }
    return lowestHumidityRecord;
    
}

 public CSVRecord lowestHumidityInManyFiles (){
     DirectoryResource dr=new DirectoryResource();
     CSVRecord curRecord,lowestHumidityRecord=null;
     double lowestHumidity=Double.MAX_VALUE,curLowHumid;
     
          for (File f : dr.selectedFiles()){
           FileResource fr=new FileResource(f);        
           CSVParser parser = fr.getCSVParser();
           curRecord=lowestHumidityInFile(parser);
           curLowHumid=Double.parseDouble(curRecord.get("Humidity"));
           if(lowestHumidity>curLowHumid)
           {  lowestHumidity=curLowHumid;
               lowestHumidityRecord=curRecord;
            }
           
    }
    return lowestHumidityRecord;
}
    public void  testLowestHumidityInManyFiles(){
         
CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest HUMIDITY was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }
 public double averageTemperatureInFile(CSVParser parser){
     double totalTemp=0.0;
     int count=0;
     for(CSVRecord row:parser){
         totalTemp=totalTemp+Double.parseDouble(row.get("TemperatureF"));
         count++;
        }
        return (totalTemp/count);
    }
    
public void testAverageTemperatureInFile(){
     FileResource fr = new FileResource();
CSVParser parser = fr.getCSVParser();
    System.out.println("Average temperature in file is "+averageTemperatureInFile(parser));
}

 public void  testLowestHumidityInFile(){
        FileResource fr = new FileResource();
CSVParser parser = fr.getCSVParser();
CSVRecord csv = lowestHumidityInFile(parser);
System.out.println("Lowest HUMIDITY was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));

    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value){
        double totalTemp=0.0;
     int count=0;
     String humidity;
     for(CSVRecord row:parser){
         humidity=row.get("Humidity");
          if(humidity.equals("N/A"))
           continue;
         if(Double.parseDouble(humidity)>=value){
         totalTemp=totalTemp+Double.parseDouble(row.get("TemperatureF"));
         count++;}
        }
        //System.out.println(totalTemp);
        if(count==0) count=1;
        return (totalTemp/count);
    }
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter humidity value");
        int value=sc.nextInt();
        double average=averageTemperatureWithHighHumidityInFile(parser,value);
        if(average==0.0)
        System.out.println("No temperatures with that humidity");
        else
        System.out.println("Average Temp when high Humidity is "+average);
        
    }
    
    
}
