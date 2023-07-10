package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 가장가까운같은글자 {

    public int[] solution(String s) {

        int length = s.length();
        int[] answer = new int[length];

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                answer[i] = -1;
            } else {
                answer[i] = i - map.get(c);
                map.put(c, i);
            }
        }

        return answer;
    }
}
