package programmers.lv1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class 숫자짝꿍 {
    public String solution(String X, String Y) {

        //X와 Y를  key : 숫자 , value : cnt map으로 생성
        Map<String, Long> xMap = Arrays.stream(X.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> yMap = Arrays.stream(Y.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //두개의 공통된 key를 가져와서 내림차순 정렬한다.
        List<String> intersectionKeys = xMap.keySet().stream()
                .filter(yMap::containsKey).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        //정렬한 keys 각각 value를 가져와서 X,Y에서 작은 값으로 answer에 더한다.
        StringBuilder answer = new StringBuilder();
        for (String s : intersectionKeys) {
            long min = Math.min(xMap.get(s), yMap.get(s));

            for (int i = 0; i < min; i++) {
                answer.append(s);
                if (answer.length() == 1 && s.equals("0"))
                    break;
            }

        }

        return answer.toString().isEmpty() ? "-1" : answer.toString();
    }

    public static void main(String[] args) {
        숫자짝꿍 숫자짝꿍 = new 숫자짝꿍();
        숫자짝꿍.solution("100", "2345");
    }
}
