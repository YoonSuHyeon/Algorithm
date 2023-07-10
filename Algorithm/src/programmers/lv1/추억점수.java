package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억점수 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++)
            map.put(name[i], yearning[i]);


        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            String[] names = photo[i];

            int sum = Arrays.stream(names).mapToInt(n -> map.getOrDefault(n, 0)).sum();
            answer[i] = sum;
        }
        return answer;
    }
}
