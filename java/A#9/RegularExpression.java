/*
String and Type Information

Using the documentation for java.util.regex.Pattern as a resource, write and test a regular expression that checks a sentence to see that it begins with a capital letter and ends with a period.
 */

package assignment;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String sentence=scanner.nextLine();
        RegularExpression regularExpressionObj=new RegularExpression();
        System.out.print(regularExpressionObj.checkSentence(sentence));
    }
    public boolean checkSentence(String sentence){
        //the regular expression represents a sequence of characters that begins with a capital letter and ends with a period.
       String regularExpression="[A-Z].*.";
       // pattern variable represents a Pattern object which is a compiled representation of a regular expression.
        Pattern pattern = Pattern.compile(regularExpression);
        //  Matcher object m interprets the pattern and performs match operations against  input string sentence.
        Matcher m = pattern.matcher(sentence);
        while (m.find()){
            return true;
        }
        return false;

    }
}
