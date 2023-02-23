package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Given five positive integers,
 * find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 */
public class MiniMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        // ascending sort
        Collections.sort(arr);

        int min = arr.get(0);
        int max = arr.get(arr.size() - 1);
        long sum = IntStream.range(1, arr.size() - 1).mapToLong(arr::get).sum();
        System.out.println((sum + min) + " " + (sum + max));
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            MiniMaxSum.miniMaxSum(arr);

            bufferedReader.close();
        }
    }
}
