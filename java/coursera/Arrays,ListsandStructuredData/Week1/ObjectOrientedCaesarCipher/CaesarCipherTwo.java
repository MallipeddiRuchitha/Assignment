
/**
 * Write a description of class CaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipherTwo
{ private  String alphabet,shiftedAlphabet1,shiftedAlphabet2;
    private int key1,key2;
    public CaesarCipherTwo(int key1,int key2){
        this.key1=key1;
        this.key2=key2;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //System.out.println(key%26);
        shiftedAlphabet1 = alphabet.substring(key1%26) +
                            alphabet.substring(0,key1%26);
        alphabet = alphabet + alphabet.toLowerCase();
        shiftedAlphabet1 = shiftedAlphabet1 + shiftedAlphabet1.toLowerCase();
        shiftedAlphabet2 = alphabet.substring(key2%26) +
                            alphabet.substring(0,key2%26);
                            
        shiftedAlphabet2 = shiftedAlphabet2 + shiftedAlphabet2.toLowerCase();
    }
    public String encrypt(String input){
     StringBuilder sKey1=new StringBuilder("");
        StringBuilder sKey2=new StringBuilder("");
        for(int i=0;i<input.length();i++){
            if(i%2==0)
            sKey1.append(input.charAt(i));
            else
            sKey2.append(input.charAt(i));
            
        }
        CaesarCipher cc1 = new CaesarCipher(key1);
        String encryptedSkey1=cc1.encrypt(sKey1.toString());
          CaesarCipher cc2 = new CaesarCipher(key2);
        String encryptedSkey2=cc1.encrypt(sKey2.toString());
        
        StringBuilder encryptedString=new StringBuilder("");
        int k=0,l=0;
        for(int i=0;i<input.length();i++){
             if(i%2==0)
            encryptedString.append(encryptedSkey1.charAt(k++));
            else
            encryptedString.append(encryptedSkey2.charAt(l++));
            
        }
        //System.out.println(encryptedString.toString());
        return encryptedString.toString();
    }
    public String decrypt(String input){
         StringBuilder sKey1=new StringBuilder("");
        StringBuilder sKey2=new StringBuilder("");
        for(int i=0;i<input.length();i++){
            if(i%2==0)
            sKey1.append(input.charAt(i));
            else
            sKey2.append(input.charAt(i));
            
        }
        CaesarCipher cc1 = new CaesarCipher(key1);
        String decryptedSkey1=cc1.decrypt(sKey1.toString());
          CaesarCipher cc2 = new CaesarCipher(key2);
        String decryptedSkey2=cc1.decrypt(sKey2.toString());
        
        StringBuilder decryptedString=new StringBuilder("");
        int k=0,l=0;
        for(int i=0;i<input.length();i++){
             if(i%2==0)
            decryptedString.append(decryptedSkey1.charAt(k++));
            else
            decryptedString.append(decryptedSkey2.charAt(l++));
            
        }
        //System.out.println(encryptedString.toString());
        return decryptedString.toString();
        
    }
    
}
