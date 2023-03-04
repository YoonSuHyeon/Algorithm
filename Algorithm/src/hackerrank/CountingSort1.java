package hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


/**
 * Another sorting method, the counting sort, does not require comparison.
 * Instead, you create an integer array whose index range covers the entire range of values in your array to sort.
 * Each time a value occurs in the original array, you increment the counter at that index.
 * At the end, run through your counting array, printing the value of each non-zero valued index that number of times.
 */
public class CountingSort1 {

    public static List<Integer> countingSort(List<Integer> arr) {

        //init
        List<Integer> list = new ArrayList<Integer>(Collections.nCopies(60, 0));

        for (int n : arr) {
            int newValue = list.get(n) + 1;
            list.set(n, newValue);
        }

        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = CountingSort1.countingSort(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
