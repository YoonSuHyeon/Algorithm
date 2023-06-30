package programmers.lv3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 최고의집합 {

    /**
     * 최고의 집합 이란  각원소의 합이 S와 같고 곱이 가장 큰 수
     * <p>
     * 곱이 가장 크게 나오긴 위해서는 수의 차이가 적어야 한다.
     *
     * @param n
     * @param s
     * @return
     */
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if (s / n < 1)
            return new int[]{-1};

        // answer 한개의 인덱스 마다  s/n 값을 넣는다.
        Arrays.fill(answer, s / n);

        // s%n 만큼 반복 하면서 뒤에서 부터 1씩 증가 시킨다.
        for (int i = 0; i < s % n; i++)
            answer[answer.length - i - 1]++;

        return answer;
    }


    public static void main(String[] args) {
        int[] a = {1, 2};

        Arrays.stream(a, 0, 1).min().getAsInt();
        IntStream.range(0, 1).map(i -> a[i]).parallel().min().getAsInt();
    }
}
