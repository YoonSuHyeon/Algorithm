package programmers.lv3;

import java.util.*;
import java.util.stream.Collectors;

public class 보석쇼핑 {


    public int[] solution2(String[] gems) {

        //보석 개수
        Set<String> set = Arrays.stream(gems).collect(Collectors.toSet());
        int gemSize = set.size();

        // 투 포인터 사용
        int[] answer = new int[2];
        int start = 0;
        int end = 0;

        //보석별 ,count  Map
        Map<String, Integer> gemCountMap = new HashMap<>();
        gemCountMap.put(gems[0], 1);

        //최소길이
        int min = gems.length;
        while (start < gems.length) {

            // 모든 보석을 얻은 경우
            if (gemCountMap.size() >= gemSize) {

                //min 보다 작은경우 값 저장
                if (min > end - start) {
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                    min = end - start;
                }

                gemCountMap.compute(gems[start], (k, v) -> {
                    if (v - 1 == 0)
                        return null;
                    else
                        return v - 1;
                });
                start++;
            } else {
                // 모든 보석을 얻을 수 없는 경우
                if (end + 1 >= gems.length)
                    break;
                else {
                    //end를 늘려주면서
                    end++;
                    gemCountMap.merge(gems[end], 1, Integer::sum);
                }

            }
        }
        return answer;
    }

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
        int[] ints = new 보석쇼핑().solution2(gems);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
