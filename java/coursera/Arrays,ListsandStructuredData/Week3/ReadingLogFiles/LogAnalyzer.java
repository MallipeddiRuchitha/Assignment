
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



import edu.duke.*;
import java.sql.Date;
import java.util.*;



public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
records=new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
           String ipAddress;
     Date accessTime;
     String accessTimeString;
      String request;
     int statusCode;
      int bytesReturned;
      String status_code;
      int date;
      int month;
      int year;
      HashMap<String,Integer> months=new HashMap<>();
      months.put("Jan",1);
      months.put("Feb",2);
      months.put("Mar",3);
      months.put("Apr",4);
      months.put("May",5);
      months.put("Jun",6);
      months.put("Jul",7);
      months.put("Aug",8);
      months.put("Sep",9);
      months.put("Oct",10);
      months.put("Nov",11);
      months.put("Dec",12);
         
         FileResource fr=new FileResource(filename);
         for(String line:fr.lines()){
             LogEntry le = WebLogParser.parseEntry(line);
             /*ipAddress=line.substring(0,line.indexOf(" ",1));
             accessTimeString=(line.substring(line.indexOf("[")+1,line.indexOf("]")));
             date=Integer.valueOf(accessTimeString.substring(0,accessTimeString.indexOf("/")));
             accessTimeString=accessTimeString.substring(accessTimeString.indexOf("/")+1);
             month=Integer.valueOf(months.get(accessTimeString.substring(0,accessTimeString.indexOf("/"))));
              accessTimeString=accessTimeString.substring(accessTimeString.indexOf("/")+1);
              year=Integer.valueOf(accessTimeString.substring(0,accessTimeString.indexOf(":")));
             accessTime=Date.valueOf(year+"-"+month+"-"+date);
             int endingQuotesIndex=line.indexOf('"',line.indexOf('"')+1);
             
             request=line.substring(line.indexOf('"')+1,endingQuotesIndex);
             
             
             //System.out.print(date+"   "+month+"   "+year);
             status_code=line.substring(endingQuotesIndex+2);
             statusCode=Integer.valueOf(status_code.substring(0,status_code.indexOf(" ")));
             bytesReturned=Integer.valueOf(status_code.substring( status_code.indexOf(" ")+1));
             
              LogEntry le = new LogEntry(ipAddress,accessTime,request,statusCode,bytesReturned);*/
              records.add(le);
              
              //System.out.print(ipAddress+"  "+accessTime +request,statusCode,bytesReturned);
            }
         
         
     }
        public int countUniqueIPs()
        {  ArrayList<String> uniqueIPs=new ArrayList<String>();
            
            for(LogEntry le:records)
            { String ipAddr=le.getIpAddress();
                if(!uniqueIPs.contains(ipAddr)){
                    uniqueIPs.add(ipAddr);
                }
            }
            return uniqueIPs.size();
            
        }
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
             
         }
     }
     public void printAllHigherThanNum(int num){
          for(LogEntry le:records)
            { int statusCode=le.getStatusCode();
                if(statusCode>num){
                    System.out.println(le);
                }
            }
        }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday)
     
     {
         ArrayList<String> uniqueIPs=new ArrayList<String>();
            
            for(LogEntry le:records)
            { String ipAddr=le.getIpAddress();
                String accessTime=le.getAccessTime().toString();
                String date=accessTime.substring(4,7)+" "+accessTime.substring(8,10);
                //System.out.println(s);
                
                if(date.equals(someday)&&!uniqueIPs.contains(ipAddr)){
                    uniqueIPs.add(ipAddr);
                }
            }
            return uniqueIPs;
            
        }
        public int countUniqueIPsInRange(int low,int high)
        {
            ArrayList<String> uniqueIPs=new ArrayList<String>();
            
            for(LogEntry le:records)
            { String ipAddr=le.getIpAddress();
                int statusCode=le.getStatusCode();
                if((statusCode>=low&&statusCode<=high)&&!uniqueIPs.contains(ipAddr)){
                    uniqueIPs.add(ipAddr);
                }
            }
            return uniqueIPs.size();
            
        }
        public HashMap<String, Integer> countVisitsPerIP(){
            HashMap<String,Integer> counts=new HashMap<String,Integer>();
           for(LogEntry  le:records){
            String ip=le.getIpAddress();
            if(!counts.containsKey(ip)){
                counts.put(ip,1);
        }
        else{
            counts.put(ip,counts.get(ip)+1);
        }
     
     
}
return counts;
}
public int mostNumberVisitsByIP(HashMap<String, Integer> counts){
    int maxCount=0;
    for(String ip:counts.keySet()){
        if(counts.get(ip)>maxCount)
        maxCount=counts.get(ip);
    
}
return maxCount;
}
public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts){
    int max=mostNumberVisitsByIP(counts);
    ArrayList<String> iPs=new ArrayList<String>();
   
    for(String ip:counts.keySet()){
        if(counts.get(ip)==max)
        iPs.add(ip);
    }
    return iPs;
}
public HashMap<String, ArrayList<String>> iPsForDays(){
    HashMap<String, ArrayList<String>> ipsForDays=new  HashMap<String, ArrayList<String>>();
     for(LogEntry le:records)
            { String ipAddr=le.getIpAddress();
                String accessTime=le.getAccessTime().toString();
                String date=accessTime.substring(4,7)+" "+accessTime.substring(8,10);
                //System.out.println(s);
                ArrayList<String> iPs;
                if(!ipsForDays.keySet().contains(date)){
                    iPs=new ArrayList<String>();
                    iPs.add(ipAddr);
                    ipsForDays.put(date,iPs);
                   
                }
                else{
                    iPs=ipsForDays.get(date);
                    iPs.add(ipAddr);
                    ipsForDays.put(date,iPs);
                    
                }
            }
            return ipsForDays;
}
public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> ipsForDays){
    int maxIPs=0;
    String  dateMaxIps="";
    int currIpsNum=0;
    for(String date:ipsForDays.keySet()){
        
         
       currIpsNum= ipsForDays.get(date).size();
       if(currIpsNum>maxIPs){
           maxIPs=currIpsNum;
           dateMaxIps=date;
        }
        
}
return dateMaxIps;
}
public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>>ipsForDays,String date){
    ArrayList<String> iPs;
    HashMap<String,Integer> counts=new HashMap<String,Integer>();
    for(String Curdate:ipsForDays.keySet()){
        if(Curdate.equals(date)){
            iPs=ipsForDays.get(date);
            
             
           for(String ip:iPs){
           
            if(!counts.containsKey(ip)){
                counts.put(ip,1);
        }
        else{
            counts.put(ip,counts.get(ip)+1);
        }
    }
            break;
        }
   
}
 return iPsMostVisits(counts);}
 
}