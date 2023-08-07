package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class 요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        int before = 0;
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));
        for (int[] target : targets) {
            if (target[0] >= before) {
                before = target[1];
                answer++;
            }
        }
        return answer;
    }
}
