
/**
 * Write a description of class CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipher
{
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public  CaesarCipher(int key){
        mainKey=key;
         alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //System.out.println(key%26);
        shiftedAlphabet = alphabet.substring(key%26) +
                            alphabet.substring(0,key%26);
        alphabet = alphabet + alphabet.toLowerCase();
        shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase();
    }
    public String encrypt(String input) {
        return transform(input, alphabet, shiftedAlphabet);
    }
      private String transform(String input, String from, String to){
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            c = transformLetter(c, from, to);
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }
     private char transformLetter(char c, String from, String to) {
        int idx = from.indexOf(c);
        if (idx != -1) {
            return to.charAt(idx);
        }
        return c;
        
    }
    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return(cc.encrypt(input));
        
    }
    
}
