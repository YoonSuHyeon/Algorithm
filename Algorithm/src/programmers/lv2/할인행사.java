package programmers.lv2;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;

        for (int i = 0; i < discount.length - 9; i++) {
            // i ~ i + 9 까지 map으로 생성
            Map<String, Long> map = Arrays.stream(discount, i, i + 10).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
            // want와 number로 해당 값이 맞는지 확인
            boolean checked = true;
            for (int j = 0; j < want.length; j++) {
                String s = want[j];
                int cnt = number[j];
                if (cnt != map.getOrDefault(s, 0L)) {
                    checked = false;
                    break;
                }
            }
            if (checked)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
