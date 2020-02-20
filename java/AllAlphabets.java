/*Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive).
 Write time and space complexity of your solution as comments in the source file.*/

package assignment;

import java.util.*;

public class AllAlphabets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input data");
        String data = scanner.next();

        AllAlphabets allAlphabetsObj = new AllAlphabets();
        System.out.println(allAlphabetsObj.checkAllAlphabets(data));


    }

    /*
    Space Complexity:Amount of space occupied
       Each character occupies 1 byte memory and integer 2 or 4 bytes depending on compiler(Here it is considered as 4).
       Let n be the number of characters in input data.
       Set occupies n*1=n bytes.
       one char variable (character)=1 byte
       one int variable (i)=4 bytes;
        total space=n+1+4=n+5=O(n)(highest order of n is 1);
        space complexity is linear

        Time Complexity:Time taken by the  program to complete its execution.
        Let n be the input length;
        A statement will have constant(c) time complexity.

        The for loop is iterated over n times.
        Here worst case time complexity is considered.(if statement(Character.isAlphabetic(character)) is always evaluated to be true).

        time taken=2*c+n*(c+c+c)+c
        time complexity=3*c+n*3*c=(n+1)*3*c=O(n)(highest order of n is 1);
        time complexity is linear

     */
    public boolean checkAllAlphabets(String data) {
        Set<Character> lettersInData = new HashSet<Character>();
        char character;
        for (int index = 0; index < data.length(); index++) {
            character = data.charAt(index);
            if (Character.isAlphabetic(character)) {
                lettersInData.add(character);

            }
        }
        if (lettersInData.size() == 26)
            return true;
        else return false;
    }
}
