
/**
 * Write a description of class TestCaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class TestCaesarCipher
{ public int[] countLetters(String message){
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
        CaesarCipher cc = new CaesarCipher(18);
        String encrypted=cc.encrypt(fileContent);
        String decrypted=cc.decrypt(encrypted);
        System.out.println(fileContent+"  "+encrypted+"  "+decrypted);
        System.out.println("decryption using breakCaesarCipher method");
        decrypted=breakCaesarCipher(encrypted);
         System.out.println(fileContent+"  "+encrypted+"  "+decrypted);
        
    }
   public String  breakCaesarCipher(String input){
       int key=getKey(input);
       CaesarCipher cc = new CaesarCipher(key);
       
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
