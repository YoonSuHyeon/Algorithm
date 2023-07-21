package programmers.lv2;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 2개이하로 다른비트
 */
public class 다른비트2개이하로 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {

            //짝수 인경우
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
                continue;
            }

            //홀수 인경우
            String s = Long.toBinaryString(numbers[i]);
            int idx = s.lastIndexOf("01");
            //1. 이진수로 표현시  전부 1인경우
            if (idx == -1) {

                //최상위 비트를 삭제하고 10으로 대체
                answer[i] = Long.parseLong("10" + s.substring(1), 2);
                continue;
            }
            //2. 이외
            //뒤에서 부터 01을 찾아서 10으로 교체
            answer[i] = Long.parseLong(s.substring(0, idx) + "10" + s.substring(idx + 2), 2);


        }
        return answer;
    }

    public int countOnes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new 다른비트2개이하로().solution(new long[]{2, 7});
    }
}
