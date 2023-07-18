package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    public int solution(String[] maps) {

        int startX = 0, startY = 0;

        char[][] map = new char[maps.length][maps[0].length()];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
                map[i][j] = maps[i].charAt(j);
            }
        }

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(startX, startY, 0));
        int answer = -1;

        boolean[][] visited = new boolean[map.length][map[0].length];
        // 레버 최단 거리
        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            if (pos.x < 0 || pos.x >= map.length)
                continue;

            if (pos.y < 0 || pos.y >= map[0].length)
                continue;

            if (map[pos.x][pos.y] == 'X')
                continue;

            // 레버를 당기지 않은상태인데 간곳을 다시 간경우
            if (visited[pos.x][pos.y])
                continue;

            // 탈출 한경우
            if (map[pos.x][pos.y] == 'L') {
                queue.clear();
                queue.add(pos);
                break;
            }

            queue.add(new Position(pos.x - 1, pos.y, pos.time + 1));
            queue.add(new Position(pos.x + 1, pos.y, pos.time + 1));
            queue.add(new Position(pos.x, pos.y - 1, pos.time + 1));
            queue.add(new Position(pos.x, pos.y + 1, pos.time + 1));

            visited[pos.x][pos.y] = true;
        }


        // 도착 최단 거리
        visited = new boolean[map.length][map[0].length];
        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            if (pos.x < 0 || pos.x >= map.length)
                continue;

            if (pos.y < 0 || pos.y >= map[0].length)
                continue;

            if (map[pos.x][pos.y] == 'X')
                continue;

            // 레버를 당기지 않은상태인데 간곳을 다시 간경우
            if (visited[pos.x][pos.y])
                continue;

            // 탈출 한경우
            if (map[pos.x][pos.y] == 'E') {
                answer = pos.time;
                break;
            }

            queue.add(new Position(pos.x - 1, pos.y, pos.time + 1));
            queue.add(new Position(pos.x + 1, pos.y, pos.time + 1));
            queue.add(new Position(pos.x, pos.y - 1, pos.time + 1));
            queue.add(new Position(pos.x, pos.y + 1, pos.time + 1));

            visited[pos.x][pos.y] = true;
        }

        return answer;
    }


    private class Position {
        private int x;
        private int y;
        private int time;

        public Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        미로탈출 미로탈출 = new 미로탈출();
        미로탈출.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
    }
}
