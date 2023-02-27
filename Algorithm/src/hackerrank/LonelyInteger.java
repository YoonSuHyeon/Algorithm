package hackerrank;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Given an array of integers, where all elements but one occur twice, find the unique element.
 */
public class LonelyInteger {
    public static int lonelyInteger(List<Integer> a) {
        return a.stream().collect(groupingBy(s -> s, counting())).entrySet().stream().filter(e -> e.getValue() != 2).map(Map.Entry::getKey).findFirst().get();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).toList();

        int result = LonelyInteger.lonelyInteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
