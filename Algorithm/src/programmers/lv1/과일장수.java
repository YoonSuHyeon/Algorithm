package programmers.lv1;

import java.util.*;

public class 과일장수 {


    public int solution(int k, int m, int[] score) {

        //오름 차순 정렬
        Arrays.sort(score);
        score = Arrays.copyOfRange(score, score.length % m, score.length);

        int minValue = k + 1;
        int answer = 0;
        for (int i = score.length % m; i < score.length; i++) {
            minValue = Math.min(minValue, score[i]);

            if ((i + 1) / m > 0 && (i + 1) % m == 0) {
                answer += minValue;
                minValue = k + 1;
            }
        }

        return answer * m;
    }

    /**
     * 정렬이후  배열의 끝부터 접근해서  m길이만큼 앞에있는 수는 score[i]보다  작기 떄문에 해당 값을 사용하는 방법
     * 간단한  풀이 방법
     *
     * @param k
     * @param m
     * @param score
     * @return
     */
    public int solution2(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for (int i = score.length; i >= m; i -= m) {
            answer += score[i - m] * m;
        }

        return answer;
    }


    public static void main(String[] args) {
        과일장수 과일장수 = new 과일장수();
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        과일장수.solution(4, 3, score);
    }
}
