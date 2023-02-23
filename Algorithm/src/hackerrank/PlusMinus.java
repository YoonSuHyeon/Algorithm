package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * arr = [1,1,0,-1,-1]  : result = 0.4, 0.4, 0.2
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
 * Print the decimal value of each fraction on a new line with  places after the decimal.
 */
public class PlusMinus {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {

        int positiveCnt = 0;
        int negativeCnt = 0;
        int zeroCnt = 0;
        int size = arr.size();

        //use for loop
        for (Integer i : arr) {
            if (i == 0)
                zeroCnt++;
            else if (i < 0) {
                negativeCnt++;
            } else
                positiveCnt++;
        }

        System.out.printf("%.6f%n", (float) positiveCnt / size);
        System.out.printf("%.6f%n", (float) negativeCnt / size);
        System.out.printf("%.6f%n", (float) zeroCnt / size);

    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            PlusMinus.plusMinus(arr);

            bufferedReader.close();
        }
    }
}
