package programmers.lv1;

import java.util.Arrays;

public class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (char c : targets[i].toCharArray()) {
                int idx = Arrays.stream(keymap).mapToInt(k -> k.indexOf(c)).filter(k -> k != -1).min().orElse(-1);
                if (idx == -1) {
                    sum = -1;
                    break;
                }

                sum += idx + 1;
            }
            answer[i] = sum;
        }

        return answer;
    }
}
