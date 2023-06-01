package programmers.lv2;

import java.util.Arrays;

public class n제곱배열자르기 {
    public int[] solution(int n, long left, long right) {

        int length = (int) (right - left + 1L);
        int[] answer = new int[length];
        long i, j;

        for (int idx = 0; idx < length; idx++) {
            i = left / n;
            j = left % n;

            answer[idx] = (int) Math.max(i, j) + 1;
            left++;
        }
        return answer;
    }

    public static void main(String[] args) {
        n제곱배열자르기 n제곱배열자르기 = new n제곱배열자르기();
        int[] solution = n제곱배열자르기.solution(3, 2, 5);
        Arrays.stream(solution).forEach(System.out::println);

    }
}
