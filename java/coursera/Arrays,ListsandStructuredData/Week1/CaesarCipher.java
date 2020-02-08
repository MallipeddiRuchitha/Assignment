import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String capitalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallAlphabet="abcdefghijklmnopqrstuvwxyz";
        //Compute the shifted alphabet
        String shiftedSmallAlphabet = smallAlphabet.substring(key)+
        smallAlphabet.substring(0,key);
         String shiftedCapitalAlphabet = capitalAlphabet.substring(key)+
        capitalAlphabet.substring(0,key);
        
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
           int idx=-1;
           char newChar;
            char currChar = encrypted.charAt(i);
             if(Character.isUpperCase(currChar)){
            //Find the index of currChar in the alphabet (call it idx)
             idx = capitalAlphabet.indexOf(currChar);}
             else idx=smallAlphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                 if(Character.isUpperCase(currChar))
                 newChar = shiftedCapitalAlphabet.charAt(idx);
                else 
                newChar = shiftedSmallAlphabet.charAt(idx);
                
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public void testCaesar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    public String encryptTwoKeys(String input,int key1,int key2){
        StringBuilder sKey1=new StringBuilder("");
        StringBuilder sKey2=new StringBuilder("");
        for(int i=0;i<input.length();i++){
            if(i%2==0)
            sKey1.append(input.charAt(i));
            else
            sKey2.append(input.charAt(i));
            
        }
        String encryptedSkey1=encrypt(sKey1.toString(),key1);
        String encryptedSkey2=encrypt(sKey2.toString(),key2);
        StringBuilder encryptedString=new StringBuilder("");
        int k=0,l=0;
        for(int i=0;i<input.length();i++){
             if(i%2==0)
            encryptedString.append(encryptedSkey1.charAt(k++));
            else
            encryptedString.append(encryptedSkey2.charAt(l++));
            
        }
        System.out.println(encryptedString.toString());
        return encryptedString.toString();
        
    }
}

