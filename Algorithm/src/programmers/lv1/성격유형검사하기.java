package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {

    private static Map<Integer, String> idxMap = new HashMap<>();

    public String solution(String[] survey, int[] choices) {

        idxMap.put(0, "R");
        idxMap.put(1, "T");
        idxMap.put(2, "C");
        idxMap.put(3, "F");
        idxMap.put(4, "J");
        idxMap.put(5, "M");
        idxMap.put(6, "A");
        idxMap.put(7, "N");

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {

            String[] split = survey[i].split("");
            if (choices[i] < 4)
                map.merge(split[0], 4 - choices[i], Integer::sum);
            else if (choices[i] > 4)
                map.merge(split[1], choices[i] - 4, Integer::sum);

        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 8; i += 2) {
            int a = map.getOrDefault(idxMap.get(i), 0);
            int b = map.getOrDefault(idxMap.get(i + 1), 0);
            if (a < b)
                answer.append(idxMap.get(i + 1));
            else
                answer.append(idxMap.get(i));
        }


        return answer.toString();
    }

    public static void main(String[] args) {

        String[] survey = {"RT", "RT", "RT"};
        int[] choices = {4, 4, 4};

        성격유형검사하기 성격유형검사하기 = new 성격유형검사하기();
        성격유형검사하기.solution(survey, choices);
    }
}
