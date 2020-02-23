/*
Gruber Healthcare has different types of forms for their customer, one of which is a know your customer form ( KYC ) which has to be filled annually. Each form has a date which signifies the date the form was filled called the form date.

Due to government regulations the KYC form can only be filled within + or - 30 days of the signup anniversary of a customer. When filling it up, you have to provide the form date. If you are past the +-30 day anniversary then you can back-date it so that it falls in the +-30-day window. When filling it up you cannot use a future date for the form date.

For Example, assuming today is 4 Apr 2017 and I had signed up on 1st Mar 2014, my window for KYC submission this year would be 30 Jan 2017 to 31 Mar 2017. Since it is already 4th Apr - I would have to back-date the KYC to a date in this range.

Note: The KYC form can be filled only for the closest anniversary in the past or within 30 days range in future.
Anniversary refers to same day and month every year. If your birthday is 01-02-1992 -then your first anniversary will be 01-02-1993, the 2nd will be 01-02-1994 and so on. 01-02-1992 is not an anniversary.

Given the signup date and the current date, provide the allowable date range for the form date.

Input - First line is an integer n as the number of inputs to be passed. Next, n lines are n input for the program in the format dd-mm-yyyy dd-mm-yyyy Each line has two dates separated by space where the first date in signup date and the second date is the current date.

Output - Range of dates for KYC form in format dd-mm-yyyy dd-mm-yyyy

Test Input:
5
16-07-1998 27-06-2017
04-02-2016 04-04-2017
04-05-2017 04-04-2017
04-04-2015 04-04-2016
04-04-2015 15-03-2016

Test output:
16-06-2017 27-06-2017
05-01-2017 06-03-2017
No range
05-03-2016 04-04-2016
05-03-2016 15-03-2016
 */

package assignment;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public class DatesRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of inputs");
        int numberofInputs = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter signupDates and currentDates");
        DatesRange datesRangeObj = new DatesRange();
        ArrayList<String> datesArrayList=new  ArrayList();

        for (int i = 0; i < numberofInputs; i++) {

                    datesArrayList.add(scanner.nextLine());




        }
        datesRangeObj.datesRange(datesArrayList);
    }

    /**
     *
     * @param datesArrayList represents n lines,where each line has  two dates separated by space where the first date in signup date and the second date is the current date.
     *
     *
     */
    public void datesRange(ArrayList<String> datesArrayList) {
        for (String line : datesArrayList) {
            String[] dates = new String[2];
            dates = line.split(" +");
// DateTimeFormatter is used to format date in particular format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            LocalDate formStartDate, formEndDate;
            //System.out.println(dates.length);


            LocalDate currentDate = LocalDate.parse(dates[1], formatter);
            LocalDate signupDate = LocalDate.parse(dates[0], formatter);
            if (signupDate.compareTo(currentDate) > 0) {
                System.out.println("No range");
                continue;
            }
            signupDate = signupDate.withYear(currentDate.getYear());
            formStartDate = signupDate.minusDays(30);

            formEndDate = signupDate.plusDays(30);

            if (formEndDate.compareTo(currentDate) > 0) { //System.out.println(currentDate);
                formEndDate = currentDate;

            }


            String formStartDateString = formatter.format(formStartDate);
            String formEndDateString = formatter.format(formEndDate);


            System.out.println(formStartDateString+ "   " + formEndDateString);
        }
    }
}

