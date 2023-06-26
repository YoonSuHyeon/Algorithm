package programmers.lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 미로탈출명령어 {

    private static final String IMPOSSIBLE = "impossible";

    // ----------- 세번쨰 시도 ------------------
    // 사전순으로 dfs를한다.(멈춰야하는 경우
    public String solution3(int n, int m, int x, int y, int r, int c, int k) {

        // k거리를 이동해서 갈 수 없는 경우
        int distance = Math.abs(r - x) + Math.abs(c - y);
        if (distance > k)
            return IMPOSSIBLE;

        // 최소거리로 간후 남은 거리를 (lr,rl,ud,du)와 같은 방법으로 할수 없는경우
        if ((k - distance) % 2 == 1)
            return IMPOSSIBLE;

        //d -> l -> r -> u 진행 시킬수 있는 값
        int downCnt = Math.max(r - x, 0);
        int leftCnt = Math.max(y - c, 0);
        int rightCnt = Math.max(c - y, 0);
        int upCnt = Math.max(x - r, 0);

        // 원상 복귀하는 경우(lr,rl,ud,du)
        int pairCnt = (k - distance) / 2;

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (downCnt > 0 || pairCnt > 0 && x < n) {
                //down
                answer.append("d");

                if (downCnt > 0)
                    downCnt--;
                else {
                    pairCnt--;
                    upCnt += 1;
                }
                x++;
            } else if (leftCnt > 0 || pairCnt > 0 && y > 1) {
                //left
                answer.append("l");

                if (leftCnt > 0)
                    leftCnt--;
                else {
                    pairCnt--;
                    rightCnt += 1;
                }
                y--;

            } else if (rightCnt > 0 || pairCnt > 0 && y < m) {
                //right
                answer.append("r");

                if (rightCnt > 0)
                    rightCnt--;
                else {
                    pairCnt--;
                    leftCnt += 1;
                }
                y++;

            } else {
                //up
                answer.append("u");

                if (upCnt > 0)
                    upCnt--;
                else {
                    upCnt--;
                    downCnt += 1;
                }
                x--;
            }
        }
        return answer.toString();
    }


// ---------------------- 첫번째 시도 (k만큼 u,d,l,r을 사용해서 만들 수 있는 경우를 전부 생성후 실제로 탈출 시도롤 해본다)---------------------------------------------------------------


    private String[][] maze;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        //미로 생성
        maze = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i == x - 1 && j == y - 1)
                    maze[i][j] = "S";
                else if (i == r - 1 && j == c - 1)
                    maze[i][j] = "E";
                else
                    maze[i][j] = ".";

            }
        }

        // l r u d 를 k길이로 가능한 경우 수를 생성 (사전순으로 정렬)
        List<String> list = generate(k);

        for (String s : list) {

            if (escape(s, x, y))
                return s;
        }

        return IMPOSSIBLE;
    }


    /**
     * l r u d 를 k길이로 가능한 경우 수를 생성 (사전순으로 정렬)
     *
     * @param k
     * @return
     */
    private List<String> generate(int k) {
        List<String> list = new ArrayList<>();
        make(list, "", k);

        //사전순으로 정렬
        Collections.sort(list);
        return list;
    }

    private void make(List<String> list, String current, int k) {
        if (current.length() == k) {
            list.add(current);
            return;
        }

        make(list, current + "l", k);
        make(list, current + "r", k);
        make(list, current + "u", k);
        make(list, current + "d", k);
    }

    private boolean escape(String cmd, int x, int y) {
        int startX = x - 1;
        int startY = y - 1;

        for (char c : cmd.toCharArray()) {

            if (c == 'l') {
                startY--;
            } else if (c == 'r') {
                startY++;
            } else if (c == 'u') {
                startX--;
            } else {
                startX++;
            }

            if (startY < 0 || startY >= maze[0].length)
                return false;

            if (startX < 0 || startX >= maze.length)
                return false;
        }


        return maze[startX][startY].equals("E");
    }

    public static void main(String[] args) {
        미로탈출명령어 미로탈출명령어 = new 미로탈출명령어();
        System.out.println("미로탈출명령어 = " + 미로탈출명령어.solution3(3, 3, 1, 2, 3, 3, 4));
    }
}
