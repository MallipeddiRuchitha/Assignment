
/**
 * Write a description of class TestCaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class TestCaesarCipherTwo
{public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length(); k++){
            int dex = alph.indexOf(Character.toLowerCase(message.charAt(k)));
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
     public String halfOfString(String message,int start){
         StringBuilder sb=new StringBuilder("");
        
        for(int i=start;i<message.length();i=i+2){
            
            sb.append(message.charAt(i));
            
        }
        
        return sb.toString();
    }
    
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int k=0; k < vals.length; k++){
            if (vals[k] > vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
    }
     public void simpleTests(){
        System.out.println("Select file");
        FileResource fr=new FileResource();
        String fileContent=fr.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(17,3);
        String encrypted=cc.encrypt(fileContent);
        String decrypted=cc.decrypt(encrypted);
        System.out.println(fileContent+"  "+encrypted+"  "+decrypted);
        System.out.println("decryption using breakCaesarCipher method");
        decrypted=breakCaesarCipher(encrypted);
         System.out.println(fileContent+"  "+encrypted+"  "+decrypted);
        
    }
     public String  breakCaesarCipher(String input){
         StringBuilder sKey1=new StringBuilder("");
        StringBuilder sKey2=new StringBuilder("");
        for(int i=0;i<input.length();i++){
            if(i%2==0)
            sKey1.append(input.charAt(i));
            else
            sKey2.append(input.charAt(i));
            
        }
       int key1=getKey(sKey1.toString());
       int key2=getKey(sKey2.toString());
       CaesarCipherTwo cc = new CaesarCipherTwo(key1,key2);
       
        String decrypted=cc.decrypt(input);
        return decrypted;
         //System.out.println(input+"  "+decrypted);
    }
   private int getKey(String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int mostCommonPos = 'e' - 'a';
        int dkey = maxDex - mostCommonPos;
        if (maxDex < mostCommonPos) {
            dkey = 26 - (mostCommonPos-maxDex);
        }
        return dkey;
    }
    
}
