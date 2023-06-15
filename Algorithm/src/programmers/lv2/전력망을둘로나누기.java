package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망을둘로나누기 {

    public int solution(int n, int[][] wires) {

        //wires 전선을 한번씩 끊고 계산
        int answer = n;

        // 인접 행렬 만들기(idx 0을 사용하지 않기 위함)
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        // 선 하나씩 끊으면서 bfs 탐색
        for (int i = 0; i < wires.length; i++) {

            int left = wires[i][0];
            int right = wires[i][1];

            // 선 끊기
            arr[left][right] = 0;
            arr[right][left] = 0;

            // bfs 선 제거후 한개의 집합을 찾음 (1부터 시작)
            answer = Math.min(answer, bfs(arr, n));

            // 끊었던 선 복구
            arr[left][right] = 1;
            arr[right][left] = 1;
        }

        return answer;
    }

    private int bfs(int[][] arr, int n) {
        int cnt = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp] = true;

            for (int i = 1; i < n + 1; i++) {
                if (arr[temp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    cnt++;
                }
            }
        }

        // cnt와 n - cnt는 각각 연결된 전력망
        return Math.abs(cnt - (n - cnt));
    }


    public static void main(String[] args) {

        전력망을둘로나누기 전력망을둘로나누기 = new 전력망을둘로나누기();
        int[][] wires = {{1, 4}, {6, 3}, {2, 5}, {5, 1}, {5, 3}};
        System.out.println("wires = " + 전력망을둘로나누기.solution(6, wires));
    }
}
