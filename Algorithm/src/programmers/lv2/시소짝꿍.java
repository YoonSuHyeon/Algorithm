package programmers.lv2;

import java.util.*;

public class 시소짝꿍 {
    public long solution(int[] weights) {

        Arrays.sort(weights);

        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        for (int i : weights) {
            double a = i * 1.0;
            double b = (i * 2.0) / 3.0;
            double c = (i * 1.0) / 2.0;
            double d = (i * 3.0) / 4.0;

            if (map.containsKey(a))
                answer += map.get(a);
            if (map.containsKey(b))
                answer += map.get(b);
            if (map.containsKey(c))
                answer += map.get(c);
            if (map.containsKey(d))
                answer += map.get(d);

            map.merge(i * 1.0, 1, Integer::sum);
        }

        return answer;
    }
}
