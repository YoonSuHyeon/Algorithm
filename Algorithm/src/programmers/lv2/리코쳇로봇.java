package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇 {
    public int solution(String[] board) {
        int startPosX, startPosY, endPosX, endPosY;
        startPosX = startPosY = endPosX = endPosY = 0;
        int maxPosX = board.length;
        int maxPosY = board[0].length();

        int[][] array = new int[maxPosX][maxPosY];
        for (int i = 0; i < maxPosX; i++) {
            for (int j = 0; j < maxPosY; j++) {
                char c = board[i].charAt(j);
                if (c == 'R') {
                    startPosX = i;
                    startPosY = j;
                } else if (c == 'D') {
                    array[i][j] = -1;
                } else if (c == 'G') {
                    endPosX = i;
                    endPosY = j;
                }
            }
        }

        boolean[][] visited = new boolean[maxPosX][maxPosY];
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, startPosX, startPosY));
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Pos poll = queue.poll();
            int currentXIdx = poll.posX;
            int currentYIdx = poll.posY;

            if (visited[currentXIdx][currentYIdx])
                continue;

            if (currentXIdx == endPosX && currentYIdx == endPosY)
                return poll.cnt;

            visited[currentXIdx][currentYIdx] = true;

            for (int i = 0; i < 4; i++) {
                int x = currentXIdx;
                int y = currentYIdx;
                while (check(x + dx[i], y + dy[i], maxPosX, maxPosY, array)) {
                    x += dx[i];
                    y += dy[i];
                }

                queue.add(new Pos(poll.cnt + 1, x, y));
            }
        }
        return -1;
    }

    private boolean check(int x, int y, int maxPosX, int maxPosY, int[][] array) {
        if (x < 0 || x >= maxPosX)
            return false;

        if (y < 0 || y >= maxPosY)
            return false;

        return array[x][y] != -1;
    }

    private static class Pos {
        private int cnt;
        private int posX;
        private int posY;

        public Pos(int cnt, int posX, int posY) {
            this.cnt = cnt;
            this.posX = posX;
            this.posY = posY;
        }
    }

    public static void main(String[] args) {
        리코쳇로봇 리코쳇로봇 = new 리코쳇로봇();
        리코쳇로봇.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
    }
}
