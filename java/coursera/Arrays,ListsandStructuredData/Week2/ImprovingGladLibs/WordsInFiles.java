
/**
 * Write a description of class WordsInFiles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
import edu.duke.*;
public class WordsInFiles
{  private HashMap<String,ArrayList<String>> wordMap;
    public WordsInFiles(){
        wordMap=new HashMap<String,ArrayList<String>>();
    }
    
   private void addWordsFromFile (File f){
       FileResource fr=new FileResource(f);
       String fname=f.getName();
       for(String s:fr.words()){
           
           if(wordMap.containsKey(s))
           {ArrayList<String> al=wordMap.get(s);
               if(al.indexOf(fname)==-1)
               al.add(fname);
               
           wordMap.put(s,al);
        }
           else 
           {
               ArrayList<String> al=new ArrayList<String>();
                al.add(fname);
           wordMap.put(s,al);
        }
           
           
           
        }
       
    }
    public void buildWordFileMap(){
        wordMap.clear();
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()){
            addWordsFromFile (f);
            
        }
        
    }
    public int maxNumber(){
        int max=0;
        for(String s:wordMap.keySet()){
            int curSize=wordMap.get(s).size();
            if(curSize>max)
            max=curSize;
            
        }
        return max;
    }
    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> al=new ArrayList<String>();
        for(String s:wordMap.keySet()){
            int curSize=wordMap.get(s).size();
            if(curSize==number){
            al.add(s);
             //System.out.println(curSize+"    "+number);
        }
            
        }
        return al;
    }
    public void printFilesIn(String word){
         
             ArrayList<String> al=wordMap.get(word);
             
             System.out.println(word+"    ");
             for(String fName:al){
                 System.out.print(fName+"  ");
                 
            }
             
    }
    public void tester(){
        buildWordFileMap();
        int max=maxNumber();
        System.out.println("the maximum number of files any word is in "+max);
        ArrayList<String> al=wordsInNumFiles(4);
        System.out.println(al.size());
        /*for(String word:al){
            
            System.out.println();
            printFilesIn(word);
             System.out.println();
        }*/
    }
    
    
}
