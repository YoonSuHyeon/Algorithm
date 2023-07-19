package programmers.lv2;

import java.util.*;

public class 뒤에있는큰수찾기 {

    public int[] solution(int[] numbers) {

        int[] answer = new int[numbers.length];

        answer[answer.length - 1] = -1;
        int maxIdx = numbers.length - 1;

        for (int i = answer.length - 2; i >= 0; i--) {

            if (numbers[i] > numbers[maxIdx]) {
                //큰 경우
                answer[i] = -1;
                maxIdx = i;
            } else if (numbers[i] == numbers[maxIdx]) {
                answer[i] = answer[maxIdx];
            } else {
                //작은 경우
                for (int j = i + 1; j <= maxIdx; j++) {
                    if (numbers[i] < numbers[j]) {
                        answer[i] = numbers[j];
                        break;
                    } else if (numbers[i] == numbers[j]) {
                        answer[i] = answer[j];
                        break;
                    }

                }
            }

        }
        return answer;
    }

    /**
     * stack과 인덱스를 활용해서 푸는 방법 (참고)
     *
     * @param numbers
     * @return
     */
    public int[] solution2(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < numbers.length; i++) {
            while (!s.isEmpty()) {
                int idx = s.pop();
                if (numbers[i] > numbers[idx]) { // 뒤가 더 클때
                    answer[idx] = numbers[i];
                } else { // 앞이 더 크거나 같을 때
                    s.push(idx);
                    break;
                }
            }
            s.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        뒤에있는큰수찾기 뒤에있는큰수찾기 = new 뒤에있는큰수찾기();
        뒤에있는큰수찾기.solution(new int[]{2, 3, 3, 5});
    }
}
