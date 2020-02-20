
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        
        logAnalyzer.readFile("LogEntry/short-test_log");
        logAnalyzer.printAll();
        
        
        // complete method
    }
    public void testUniqueIP()
    {
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        
        logAnalyzer.readFile("LogEntry/short-test_log");
        System.out.println("unique IPs:  "+logAnalyzer.countUniqueIPs());
       
       
        
    }
    public void testPrintAllHigherThanNum(){
          LogAnalyzer logAnalyzer=new LogAnalyzer();
        
        logAnalyzer.readFile("WebLogProgram/weblog1_log");
        
        System.out.println("records with status code higher than 300");
       logAnalyzer.printAllHigherThanNum(400);
    }
    public void testUniqueIPVisitsOnDay()
    {
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        
        logAnalyzer.readFile("WebLogProgram/weblog1_log");
        
       ArrayList<String> al=logAnalyzer.uniqueIPVisitsOnDay("Mar 17");
       System.out.println("uniqueIPVisitsOnDay(Mar 17)"+al.size());
       
    }
    public void testCountUniqueIPsInRange(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        
        logAnalyzer.readFile("WebLogProgram/weblog1_log");
        System.out.println("countUniqueIPsInRange 200 299     "+logAnalyzer.countUniqueIPsInRange(200,299));
    }
    public void testMostNumberVisitsByIP(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        
        logAnalyzer.readFile("WebLogProgram/weblog1_log");
         HashMap<String, Integer> counts=logAnalyzer.countVisitsPerIP();
          System.out.println("MostNumberVisitsByIP  "+ logAnalyzer.mostNumberVisitsByIP(counts));
    }
     public void testIPsMostVisits(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        
        logAnalyzer.readFile("WebLogProgram/weblog1_log");
         HashMap<String, Integer> counts=logAnalyzer.countVisitsPerIP();
          System.out.println("iPsMostVisits "+ logAnalyzer.iPsMostVisits (counts));
    }
    public void testIPsForDays(){
         LogAnalyzer logAnalyzer=new LogAnalyzer();
        
        logAnalyzer.readFile("WebLogProgram/weblog1_log");
         HashMap<String, ArrayList<String>> ipsForDays=logAnalyzer.iPsForDays();
         for(String date:ipsForDays.keySet()){
         System.out.print(date+"   ");
         for(String ip:ipsForDays.get(date))
         { System.out.print(ip+"   ");
            }
         System.out.println();
        }
        
    }
    public void testDayWithMostIPVisits(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        
        logAnalyzer.readFile("WebLogProgram/weblog1_log");
         HashMap<String, ArrayList<String>> ipsForDays=logAnalyzer.iPsForDays();
        System.out.println("DayWithMostIPVisits is "+logAnalyzer.dayWithMostIPVisits(ipsForDays));
    }
    
    public void testIpsWithMostVisitsOnDay(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        
        logAnalyzer.readFile("WebLogProgram/weblog1_log");
        HashMap<String, ArrayList<String>> ipsForDays=logAnalyzer.iPsForDays();
         System.out.println("iPsWithMostVisitsOnDay   "+logAnalyzer.iPsWithMostVisitsOnDay(ipsForDays,"Mar 17"));
    }
    
}
