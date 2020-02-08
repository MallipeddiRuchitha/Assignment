import java.util.*;

/**
 * Write a description of class WordPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordPlay
{
   public boolean isVowel(char ch){
       ch=Character.toUpperCase(ch);
       if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
       return true;
       else return false;
       
    }
    public void testIsVowel(){
        System.out.println("Enter a character to check whether it is a vowel or not");
        Scanner sc=new Scanner(System.in);
        char c=sc.next().charAt(0);
        System.out.println("isVowel is "+isVowel(c));
        
        
    }
    public String replaceVowels(String phrase,char ch){
        StringBuilder phraseSB=new StringBuilder(phrase);
        
        char curCh;
        for(int i=0;i<phraseSB.length();i++){
            curCh=phraseSB.charAt(i);
            if(isVowel(curCh))
            {  phraseSB.setCharAt(i,ch);
            }
            
        }
        return (phraseSB.toString());
    }
    public String emphasize(String phrase,char ch){
         StringBuilder phraseSB=new StringBuilder(phrase);
        char curCh,smallCh,capitalCh;
        if(Character.isLowerCase(ch)){
            smallCh=ch;
            capitalCh=Character.toUpperCase(ch);
        }
        else{
            capitalCh=ch;
            smallCh=Character.toLowerCase(ch);
        }
        
        for(int i=0;i<phraseSB.length();i++){
            curCh=phraseSB.charAt(i);
            
            if(curCh==smallCh||curCh==capitalCh)
            {  
                if(i%2==0)
                phraseSB.setCharAt(i,'*');
                else
                 phraseSB.setCharAt(i,'+');
            }
            
        }
        return (phraseSB.toString());
        
    }
}