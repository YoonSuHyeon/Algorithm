package programmers.lv1;

import java.util.PriorityQueue;

public class 명예의전당1 {

    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int length = score.length;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {

            queue.offer(score[i]);

            if (i >= k)
                queue.poll();

            answer[i] = queue.peek();
        }
        return answer;
    }

    public static void main(String[] args) {
        명예의전당1 명예의전당1 = new 명예의전당1();
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        명예의전당1.solution(3, score);
    }
}
