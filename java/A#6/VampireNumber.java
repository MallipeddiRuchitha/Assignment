/*
A vampire number v is a number with an even number of digits n,
that can be factored into two numbers x and y each with n/2 digits and
not both with trailing zeroes, where v contains precisely all the digits from x and from y, in any order. Write a java program to print first 100 vampire numbers.
 */


package assignment;
import java.util.*;
public class VampireNumber {
    public static void main(String[] args) {
        VampireNumber vampireNumberObj=new VampireNumber();
        vampireNumberObj.vampire();
    }
    public void vampire(){
        System.out.println("Vampire Numbers:");
        //vampire numbers start from 1260
        System.out.println(1260);
        int count = 1;
        int number = 1261;
        String numString;
        String numString1, numString2, numString3;
        //int number1,number2;
        int length = 0;
        int num, flag = 0, index;
        int a=1;
        for(count=1;count <100;number++) {

            numString = String.valueOf(number);

            //System.out.println(number);
            length = numString.length();
            if (length % 2 != 0)
                continue;

            for (num = (int) Math.pow(10, length / 2 - 1); num <= (int) (Math.pow(10, length / 2) - 1); num++) {

                if (number % num == 0) {

                    numString1 = String.valueOf(num);


                    numString2 = String.valueOf(number / num);
                    if (numString2.length() != length / 2)
                        continue;

                    numString3 = numString1 + numString2;
                    //System.out.println(numString3+"  "+numString);
                    char[] numberCharArray=numString.toCharArray();
                    Arrays.sort(numberCharArray);
                    char[] numberCharArray3=numString3.toCharArray();
                    Arrays.sort(numberCharArray3);

                    if (Arrays.equals(numberCharArray,numberCharArray3)) {
                        System.out.println(number);
                        count++;


                        break ;

                    }
                }


            }

        }


    }
}
