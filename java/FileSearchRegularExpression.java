/*Create a java program to search through the home directory
and look for files that match a regular expression.
The program should be able to take inputs repeatedly and should print out the full
absolute path of the matching files found.*/


package assignment;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class FileSearchRegularExpression {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter regular expression to search files");
        String regularExpression = scanner.next();
        FileSearchRegularExpression fileSearchRegularExpression = new FileSearchRegularExpression();

        File homeDirectory = new File("/home/ruchitha");

        //System.out.println(System.getProperty("user.home"));
        fileSearchRegularExpression.searchFiles(regularExpression, homeDirectory);


    }

    public void searchFiles(String regularExpression, File homeDirectory) {

        /*
        This method  searches through the homeDirectory file
        and looks for files that match a regular expression.*/
        


        for (File file : homeDirectory.listFiles()) {
/*Each file in home direcrtory is checked whether it is a directory or not ,
if it is then the method(searchFiles) is called with this file as the  parameter.*/

            if (file.isDirectory()) {
                searchFiles(regularExpression, file);
            } else if (file.isFile()) {
                Pattern pattern = Pattern.compile(regularExpression);
                Matcher m = pattern.matcher(file.getName());
                while (m.find()) {
                    System.out.println(file.getAbsolutePath());
                    break;
                }
            }

        }

    }

}
