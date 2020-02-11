import java.util.*;
/**
 * Write a description of class CaesarBreaker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarBreaker
{
    public String decrypt(String encrypted){
        CaesarCipher cc=new CaesarCipher();
        int[] freqs=countLetters(encrypted);
        int maxDex=maxIndex(freqs);
        int dkey=maxDex-4;
        if(maxDex<4){
            dkey=26-(4-maxDex);
        }
        return cc.encrypt(encrypted,26-dkey);
}
public int[] countLetters(String encrypted){
    String alpha="abcdefghijklmnopqrstuvwxyz";
    int counts[]=new int[26];
        Arrays.fill(counts,0);
        int index;
        char currChar;
        for(int i=0;i<encrypted.length();i++){
            currChar=Character.toLowerCase(encrypted.charAt(i));
            index=alpha.indexOf(currChar);
            if(index!=-1)
            counts[index]+=1;
        }
    return counts;
}
 public int maxIndex(int[] values){
        int maxInd=0;
        int maxLength=0;
        for(int i=1;i<values.length;i++){
            if(maxLength<values[i]){
                maxLength=values[i];
                maxInd=i;
            }
        }
        
        return maxInd;
        
    }
    public void testDecrypt(){
        System.out.print("Enter the String");
        Scanner sc=new Scanner(System.in);
         String text=sc.next();
        System.out.print("Enter the key");
       int key=sc.nextInt();
        CaesarCipher cc=new CaesarCipher();
        String encryptedText=cc.encrypt(text,key);
        System.out.println("Encrypted message  "+encryptedText);
        System.out.println("Decrypted message  "+decrypt(encryptedText)); 
        
        
        
        
    }
    public String halfOfString(String message,int start){
         StringBuilder sb=new StringBuilder("");
        
        for(int i=start;i<message.length();i=i+2){
            
            sb.append(message.charAt(i));
            
        }
        
        return sb.toString();
    }
    
    public int getKey(String s){
        int count[]=countLetters(s);
        int maxIndex=maxIndex(count);
        return maxIndex;
    }
    public String decryptTwoKeys(String encrypted){
        String encryptedHalf1=halfOfString(encrypted,0);
        String encryptedHalf2=halfOfString(encrypted,1);
        int key1=getKey(encryptedHalf1);
        int key2=getKey(encryptedHalf2);
        System.out.print("the two keys are "+key1+"  "+key2 );
         CaesarCipher cc=new CaesarCipher();
         return cc.encryptTwoKeys(encrypted,26-key1,26-key2);
        
    }
    
}
