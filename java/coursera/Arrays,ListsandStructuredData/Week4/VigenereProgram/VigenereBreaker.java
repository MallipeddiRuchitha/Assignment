import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    FileResource fr;
    public VigenereBreaker(){
        fr=new FileResource();
    }
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
       
        StringBuilder slice=new StringBuilder();
        for(int i=0;i<message.length();i=i+totalSlices){
            if(i+whichSlice<message.length())
            slice.append(message.charAt(i+whichSlice));
            
        }
        return slice.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker caesarCracker=new CaesarCracker(mostCommon);
        
        for(int i=0;i<klength;i++){
            if(i>=encrypted.length())
            break;
            String slice=sliceString(encrypted,i,klength);
         key[i]=caesarCracker.getKey(slice);
        }
        //WRITE YOUR CODE HERE
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        String fileContent=fr.asString();
        int[] key=tryKeyLength(fileContent,4,'e');
       /* for(int i=0;i<key.length;i++)
        System.out.println(key[i]);*/
        
       /* VigenereCipher vigenereCipher=new VigenereCipher(key);
       String decrypted= vigenereCipher.decrypt(fileContent);
       System.out.println(decrypted);*/
        //FileResource fr=new FileResource();
        HashMap<String,HashSet<String>> languages=new HashMap<String,HashSet<String>>();
        DirectoryResource dr=new DirectoryResource();
        for(File file:dr.selectedFiles()){
        FileResource fr=new FileResource(file);
        HashSet<String> dictionaryWords=readDictionary(fr);
        languages.put(file.getName(),dictionaryWords);
        System.out.println(file.getName());
    }
        System.out.println(breakForAllLangs(fileContent,languages));
       //System.out.println("decryption after trying all key lengths from 1 to 100");
       // System.out.println(breakForLanguage(fileContent,dictionaryWords));
        //breakForLanguage(fileContent,dictionaryWords);
         
    }
    public  HashSet<String> readDictionary(FileResource fr){
        
        HashSet<String> words =new  HashSet<String>();
        for(String line:fr.lines()){
             words.add(line.toLowerCase());
        }
       
        return words ;
        
    }
    public int countWords(String message,HashSet<String> dictionary){
        int count=0;
        for(String words:message.toLowerCase().split("\\W+")){
            if(dictionary.contains(words))
              count++;
        }
        
        return count;
    }
    public String breakForLanguage(String encrypted,HashSet<String> dictionary){
       int maxCountWords=0,currWords;
       String bestDecrypted="";
       int[] key;
       int keyLength=0;
        for(int i=1;i<=100;i++){
         //key=tryKeyLength(encrypted,i,'e');
         key=tryKeyLength(encrypted,i,mostCommonCharIn(dictionary));
        VigenereCipher vigenereCipher=new VigenereCipher(key);
       String decrypted= vigenereCipher.decrypt(encrypted);
        currWords=countWords(decrypted,dictionary);
        if(i==38)
        System.out.println("valid words  for key length 38 "+currWords);
        if(currWords>maxCountWords){
           maxCountWords= currWords;
           bestDecrypted=decrypted;
           keyLength=i;
        }
    }
         System.out.println("key length used  "+keyLength);
        System.out.println("valid words   "+maxCountWords);
        return bestDecrypted;
        
    }
    public char  mostCommonCharIn(HashSet<String> dictionary){
        String mostCommonChar="";
        int maxCount=0;
        //String alphabet="abcdefghijklmnopqrstuvwxyz";
        HashMap<String,Integer> alphabetCount=new HashMap<String,Integer>();
        
        for(String s:dictionary){
            for(int i=0;i<s.length();i++){
                String currChar=s.charAt(i)+"";
                if(alphabetCount.containsKey(currChar))
                alphabetCount.put(currChar, alphabetCount.get(currChar)+1);
                else
                alphabetCount.put(currChar,1);
            }
        }
            for(String character:alphabetCount.keySet()){
                int count=alphabetCount.get(character);
                if(count>maxCount)
                { maxCount=count;
                   mostCommonChar=character; 
                }
                
            }
            
         return   mostCommonChar.charAt(0); 
    }
    
    public String breakForAllLangs(String encrypted,HashMap<String,HashSet<String>> languages){
        String bestDecrypted="";
        int maxValidWords=0,validWords;
        for(String language:languages.keySet()){
        String decrypted=breakForLanguage( encrypted,languages.get(language));
       validWords= countWords(decrypted,languages.get(language));
       if( validWords>maxValidWords){
           maxValidWords=validWords;
           bestDecrypted=decrypted;
        }
        
    }
    return bestDecrypted;
    }
    
    
}
    

