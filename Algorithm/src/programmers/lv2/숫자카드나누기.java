package programmers.lv2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 철수와 영희는 선생님으로부터 숫자가 하나씩 적힌 카드들을 절반씩 나눠서 가진 후, 다음 두 조건 중 하나를 만족하는 가장 큰 양의 정수 a의 값을 구하려고 합니다.
 * <p>
 * 철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고 영희가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
 * 영희가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, 철수가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
 * 예를 들어, 카드들에 10, 5, 20, 17이 적혀 있는 경우에 대해 생각해 봅시다. 만약, 철수가 [10, 17]이 적힌 카드를 갖고,
 * 영희가 [5, 20]이 적힌 카드를 갖는다면 두 조건 중 하나를 만족하는 양의 정수 a는 존재하지 않습니다.
 * 하지만, 철수가 [10, 20]이 적힌 카드를 갖고, 영희가 [5, 17]이 적힌 카드를 갖는다면,
 * 철수가 가진 카드들의 숫자는 모두 10으로 나눌 수 있고, 영희가 가진 카드들의 숫자는 모두 10으로 나눌 수 없습니다.
 * 따라서 철수와 영희는 각각 [10, 20]이 적힌 카드, [5, 17]이 적힌 카드로 나눠 가졌다면 조건에 해당하는 양의 정수 a는 10이 됩니다.
 * <p>
 * 철수가 가진 카드에 적힌 숫자들을 나타내는 정수 배열 arrayA와 영희가 가진 카드에 적힌 숫자들을 나타내는 정수 배열 arrayB가 주어졌을 때,
 * 주어진 조건을 만족하는 가장 큰 양의 정수 a를 return하도록 solution 함수를 완성해 주세요. 만약, 조건을 만족하는 a가 없다면, 0을 return 해 주세요.
 */
public class 숫자카드나누기 {
    public static int solution(int[] arrayA, int[] arrayB) {


        int gcdA = gcd(arrayA);
        int gcdB = gcd(arrayB);
        List<Integer> all = new ArrayList<>();

        if (gcdA == 1) {
            for (int aa = 1; aa <= gcdB; aa++) {
                if ((gcdB % aa) == 0)
                    all.add(aa);
            }

            int max = all.stream().filter(i -> Arrays.stream(arrayA).allMatch(b -> b % i != 0)).max(Integer::compareTo).orElse(1);

            return max == 1 ? 0 : max;

        } else if (gcdB == 1) {


            for (int aa = 1; aa <= gcdA; aa++) {
                if ((gcdA % aa) == 0)
                    all.add(aa);
            }

            int max = all.stream().filter(i -> Arrays.stream(arrayB).allMatch(b -> b % i != 0)).max(Integer::compareTo).orElse(1);

            return max == 1 ? 0 : max;

        } else {
            for (int aa = 1; aa <= gcdA; aa++) {
                if ((gcdA % aa) == 0)
                    all.add(aa);
            }

            for (int bb = 1; bb <= gcdB; bb++) {
                if ((gcdA % bb) == 0 && !all.contains(bb)) {
                    all.add(bb);
                }

            }

            int a = all.stream().max(Integer::compareTo).orElse(1);
            if (a == 1)
                return 0;
            return a;
        }


    }

    private static int gcd(int[] array) {

        if (array.length == 1)
            return array[0];

        int be = array[0];
        for (int i = 1; i < array.length; i++) {
            BigInteger a1 = BigInteger.valueOf(be);
            BigInteger a2 = BigInteger.valueOf(array[i]);

            be = a1.gcd(a2).intValue();
        }

        return be;
    }

    public static void main(String[] args) {
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};
        System.out.println("result " + 숫자카드나누기.solution(arrayA, arrayB));
    }
}
