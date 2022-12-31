package programmers.lv2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
 * str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
 * 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
 */
public class 최댓값과최솟값 {

    public static String solution(String s) {
        List<Integer> nums = Arrays.stream(s.split(" ")).map(Integer::new).collect(Collectors.toList());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {

            if (max < num)
                max = num;

            if (min > num)
                min = num;
        }

        return min + " " + max;
    }

    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println("result = " + solution(s));
    }
}
