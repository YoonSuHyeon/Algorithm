package programmers.lv2;

import java.math.BigInteger;
import java.util.*;

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

        int maxA = get(arrayA,arrayB);
        int maxB = get(arrayB,arrayA);

        int result = Math.max(maxA, maxB);
        return result <= 1 ? 0 : result;
    }

    private static int get(int[] arrayA, int[] arrayB) {
        //ArrayA의 최대 공약수를 구한다.
        int maxA = gcd(arrayA);

        //나온 값의 약수를 구한다.
        List<Integer> divisors = getDivisors(maxA);

        //내림차순 정렬
        divisors.sort(Comparator.reverseOrder());

        for (int num : divisors) {
            if (Arrays.stream(arrayB).allMatch(i -> i % num != 0))
                return num;
        }

        return 1;
    }

    private static List<Integer> getDivisors(int n) {
        int sqrt = (int) Math.sqrt(n);
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                arr.add(i);
                if (n / i != i) {
                    arr.add(n / i);
                }
            }
        }
        return arr;
    }

    private static int gcd(int[] array) {

        if (array.length == 1)
            return array[0];

        int gcd = array[0];
        for (int i = 1; i < array.length; i++) {
            BigInteger a1 = BigInteger.valueOf(gcd);
            BigInteger a2 = BigInteger.valueOf(array[i]);

            gcd = a1.gcd(a2).intValue();
        }

        return gcd;
    }

    public static void main(String[] args) {
        int[] arrayA = {10, 20};
        int[] arrayB = {5, 17};
        System.out.println("result " + 숫자카드나누기.solution(arrayA, arrayB));
    }
}
