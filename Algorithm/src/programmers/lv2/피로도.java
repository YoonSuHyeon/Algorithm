package programmers.lv2;

import java.util.Arrays;

public class 피로도 {

    public int solution(int k, int[][] dungeons) {
        int result = 0;
        for (int i = 0; i < dungeons.length; i++) {
            int[] visited = new int[dungeons.length];
            result = Math.max(goDungeons(k, i, visited, dungeons), result);

        }
        return result;
    }

    private int goDungeons(int k, int pos, int[] visited, int[][] dungeons) {

        // 던전 탐험이 가능한 경우
        if (k >= dungeons[pos][0]) {
            k = k - dungeons[pos][1];
            visited[pos] = 1;
        } else {
            //불가능한 경우는 -1
            visited[pos] = -1;
        }


        int maxDungeons = (int) Arrays.stream(visited).filter(i -> i == 1).count();
        for (int i = 0; i < visited.length; i++) {

            //방문하지 않은 던전 방문하기
            if (visited[i] == 0) {
                int[] copyVisited = Arrays.copyOf(visited, visited.length);
                maxDungeons = Math.max(goDungeons(k, i, copyVisited, dungeons), maxDungeons);
            }
        }
        return maxDungeons;
    }

    public static void main(String[] args) {
        피로도 피로도 = new 피로도();
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(" = " + 피로도.solution(80, dungeons));
    }

}
