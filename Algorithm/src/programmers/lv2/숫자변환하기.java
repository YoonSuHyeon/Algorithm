package programmers.lv2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 숫자변환하기 {
    public int solution(int x, int y, int n) {
        int answer = -1;

        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (visited.contains(node.sum))
                continue;

            visited.add(node.sum);

            if (node.sum == y) {

                answer = node.cnt;
                break;
            }

            if (node.sum > y)
                continue;

            queue.add(new Node(node.sum + n, node.cnt + 1));
            queue.add(new Node(node.sum * 2, node.cnt + 1));
            queue.add(new Node(node.sum * 3, node.cnt + 1));
        }
        return answer;
    }


    private static class Node {
        private int sum;
        private int cnt;

        public Node(int sum, int cnt) {
            this.sum = sum;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        숫자변환하기 숫자변환하기 = new 숫자변환하기();
        숫자변환하기.solution(10, 40, 30);
    }
}
