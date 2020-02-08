import org.apache.commons.csv.*;
import edu.duke.*;
import java.util.*;
/**
 * Write a description of class ParsingExportData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ParsingExportData
{
   public void tester(){
       FileResource fr = new FileResource();
CSVParser parser = fr.getCSVParser();
Scanner sc=new Scanner(System.in);
System.out.println("Enter country for method countryInfo");
String country=sc.next();
System.out.println(countryInfo(parser,country));
parser = fr.getCSVParser();
System.out.println("Enter exportItem1 for  method listExportersTwoProducts");
String exportItem1=sc.next();
System.out.println("Enter exportItem2 for method listExportersTwoProducts");
String exportItem2=sc.next();
listExportersTwoProducts(parser,exportItem1,exportItem2);
parser = fr.getCSVParser();
System.out.println("Enter exportItem for method numberOfExporters");
String exportItem=sc.next();
System.out.println(numberOfExporters(parser,exportItem));
parser = fr.getCSVParser();
System.out.println("Enter amount for method bigExporters");
//bigExporters(parser,"$999,999,999");
String amount=sc.next();
bigExporters(parser,amount);
   
}
public String countryInfo(CSVParser parser,String country){
    for(CSVRecord record:parser){
        if(country.equals(record.get("Country")))
        { return (country+":"+record.get("Exports")+":"+record.get("Value (dollars)"));
            
        
}
}
return "NOT FOUND";
}
public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2){
    String export;
    for(CSVRecord record:parser){
         export=record.get("Exports");
        if(export.contains(exportItem1)&&export.contains(exportItem2))
        System.out.println(record.get("Country"));
    }
}
public int numberOfExporters(CSVParser parser,String exportItem){
    int countries=0;
    String export;
     for(CSVRecord record:parser){
         export=record.get("Exports");
        if(export.contains(exportItem))
       countries++;
    }
    return countries;
}
public void  bigExporters(CSVParser parser,String amount){
    int length=amount.length();
    String value;
    for(CSVRecord record:parser){
         value=record.get("Value (dollars)");
        if(value.length()>length)
        System.out.println(record.get("Country")+"   "+value);
    }
    
}
}
