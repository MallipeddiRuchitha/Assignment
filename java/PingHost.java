/*Write a java function that will ping any host ( given as input ) and
computes the median of the time taken to ping.
Use the system ping utility, do not use any deprecated methods.*/


package assignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PingHost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the host name");
        String hostName = scanner.next();
        PingHost pingHost = new PingHost();

        ArrayList<String> commandList = new ArrayList<String>();

        commandList.add("ping");
        commandList.add("-c");
        commandList.add("6");
        commandList.add(hostName);
        try {
            System.out.print("the median of the time taken to ping." + pingHost.ping(commandList));
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }

    /**
     *
     * @param commandList to represent commands
     * @return median
     * @throws IOException
     */
    /*
    java function  will ping the  host  and
computes the median of the time taken to ping.
     */
    public double ping(ArrayList<String> commandList) throws IOException {
// ProcessBuilder is used to create operating system processes.
        ProcessBuilder build = new ProcessBuilder(commandList);
        Process process = build.start();

        // to read the output
        BufferedReader input = new BufferedReader(new InputStreamReader
                (process.getInputStream()));
        ArrayList<String> outputList = new ArrayList<String>();
       // System.out.println("Standard output: ");
        String outputLine = null;
        while ((outputLine = input.readLine()) != null) {
            if (outputLine.contains("time=")) {
                outputList.add(outputLine);
                //System.out.println(outputLine);
            }
        }
        double median;
        int size = outputList.size();
        String outputLine1, outputLine2;
        double time1, time2;

        if ((size % 2) == 1) {
            outputLine1 = outputList.get((size / 2));
            time1 = Double.parseDouble(outputLine1.substring(outputLine1.indexOf("time") + 5, outputLine1.indexOf(" ms")));
            return (time1);

        } else {
            outputLine1 = outputList.get(size / 2);
            time1 = Double.parseDouble(outputLine1.substring(outputLine1.indexOf("time") + 5, outputLine1.indexOf(" ms")));
            outputLine2 = outputList.get((size / 2) - 1);
            time2 = Double.parseDouble(outputLine2.substring(outputLine2.indexOf("time") + 5, outputLine2.indexOf(" ms")));

            return ((time1 + time2) / 2);
        }
    }
}
