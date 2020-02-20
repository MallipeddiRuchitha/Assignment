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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter regular expression to search files");
        String regularExpression = sc.next();
        FileSearchRegularExpression fileSearchRegularExpression = new FileSearchRegularExpression();

        File homeDirectory = new File("/home/ruchitha");

        //System.out.println(System.getProperty("user.home"));
        fileSearchRegularExpression.searchFiles(regularExpression, homeDirectory);


    }

    public void searchFiles(String regularExpression, File homeDirectory) {

        /*
        This method  searches through the homeDirectory file
        and looks for files that match a regular expression.First it checks if the file ia a directory or not ,
        if it is then the  method is recursively called with that file as parameter
        */


        for (File file : homeDirectory.listFiles()) {


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
