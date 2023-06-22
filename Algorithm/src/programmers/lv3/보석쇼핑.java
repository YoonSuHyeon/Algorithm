package programmers.lv3;

import java.util.*;
import java.util.stream.Collectors;

public class 보석쇼핑 {


    /**
     * 효율성 실패 투포인터로 다시 문제 풀어야함
     *
     * @param gems
     * @return
     */
    public int[] solution(String[] gems) {

        int totalSize = Arrays.stream(gems).collect(Collectors.toSet()).size();
        // gems의 길이 최고가 100000
        int[] answer = new int[2];
        answer[1] = 100000;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            for (int j = i; j < gems.length; j++) {
                ///모든 종류의 보석을 적어도 1개 이상 포함하는 경우
                set.add(gems[j]);

                if (set.size() == totalSize) {
                    if (answer[1] - answer[0] > j - i) {
                        answer[0] = i + 1;
                        answer[1] = j + 1;
                    }
                    break;
                }

            }

            set.clear();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        new 보석쇼핑().solution(gems);
    }
}
