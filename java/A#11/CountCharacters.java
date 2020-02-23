/*
I/O

Using TextFile and a Map<Character,Integer>,
create a program that takes the file name as a command line argument and
counts the occurrence of all the different characters. Save the results in a text file.
 */

package assignment;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CountCharacters {
    //static int count;
    public static void main(String[] args) {
        CountCharacters countCharactersObj = new CountCharacters();
        String fileName = args[0];
        try {
            // "count1.txt" represents the file to which results must be saved.
            FileWriter fileWriter = new FileWriter("count1.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            HashMap<Character, Integer> hashMap = countCharactersObj.charactersCount(fileName);

            for (Character character : hashMap.keySet()) {
                bufferedWriter.write(character);
                bufferedWriter.write("   " + String.valueOf(hashMap.get(character)));
                bufferedWriter.newLine();
            }

            for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    /**
     * @param fileName represents file from which characters must be read
     * @return HashMap<Character, Integer> which maps characters to the respective counts in the file.
     */

    public HashMap<Character, Integer> charactersCount(String fileName) {
        System.out.println("Hi hello");
        File textFile = new File(fileName);
        HashMap<Character, Integer> hashMap = new HashMap();


        try {
            FileReader reader = new FileReader(textFile);
            BufferedReader br = new BufferedReader(reader);
            //
            int c;
            while ((c = br.read()) != -1) {

                if (hashMap.containsKey((char) c)) {
                    hashMap.put((char) c, hashMap.get((char) c) + 1);

                } else
                    hashMap.put((char) c, 1);


            }
            br.close();
            reader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(count);
        return hashMap;


    }

}
