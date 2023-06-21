package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS, BFS 구분
 * BFS : 최소 거리 문제 (예외) 노드당 특성을 갖고 있고 제한이 있는경우는 먼저 BFS로 가능한지 생각한후 아닌경우 DFS로 진행
 */
public class 게임맵최단거리 {


    public int solution(int[][] maps) {

        int answer = -1;
        // 시작은 (0,0)
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 1));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            //maps에 크기에 idx 조건이 맞는지 체크
            if (pos.x < 0 || pos.x >= maps.length)
                continue;

            // maps에 크기에 idx 조건이 맞는지 체크
            if (pos.y < 0 || pos.y >= maps[0].length)
                continue;

            if (maps[pos.x][pos.y] == 0)
                continue;

            // 도착한 경우
            if (pos.x == maps.length - 1 && pos.y == maps[0].length - 1) {
                answer = pos.distance;
                break;
            }


            queue.add(new Position(pos.x + 1, pos.y, pos.distance + 1));
            queue.add(new Position(pos.x - 1, pos.y, pos.distance + 1));
            queue.add(new Position(pos.x, pos.y + 1, pos.distance + 1));
            queue.add(new Position(pos.x, pos.y - 1, pos.distance + 1));

            maps[pos.x][pos.y] = 0;
        }
        return answer;
    }


    private static class Position {
        private int x;
        private int y;

        private int distance;

        public Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    // 아래는 DFS로 문제 풀이한 부분 (효율성이 좋지 않아 실패)
    private static int minDistance = Integer.MAX_VALUE;
    public int solutionDfs(int[][] maps) {
        // 시작은 (0,0)
        dfs(0, 0, 0, maps);
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public void dfs(int i, int j, int distance, int[][] maps) {

        // maps에 크기에 idx 조건이 맞는지 체크
        if (i < 0 || i >= maps.length)
            return;

        // maps에 크기에 idx 조건이 맞는지 체크
        if (j < 0 || j >= maps[0].length)
            return;

        //도착한 경우
        if (i == maps.length - 1 && j == maps[0].length - 1) {
            minDistance = Math.min(minDistance, distance + 1);
            return;
        }

        // 벽인 경우 , 이미 방문 한 경우
        if (maps[i][j] == 0 || maps[i][j] == -1)
            return;

        // 최소 거리 보다 큰경우
        if (minDistance <= distance)
            return;

        // 해당 i J 지나감.
        distance++;
        maps[i][j] = -1;

        int[][] copy = maps.clone();
        for (int k = 0; k < maps.length; k++) {
            copy[k] = maps[k].clone();
        }
        // 동서남북  탐색
        dfs(i, j + 1, distance, copy);
        dfs(i + 1, j, distance, copy);
        dfs(i, j - 1, distance, copy);
        dfs(i - 1, j, distance, copy);

    }

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        int solution = new 게임맵최단거리().solution(maps);
        System.out.println("solution = " + solution);
    }
}
