package hackerrank;

import java.io.*;

/**
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
 */
public class TimeConversion {

    public static String timeConversion(String s) {

        int hour = Integer.parseInt(s.substring(0, 2)) % 12;
        if (s.endsWith("PM"))
            hour += 12;

        return String.format("%02d", hour) + s.substring(2, 8);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = TimeConversion.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
