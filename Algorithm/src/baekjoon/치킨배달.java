package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 치킨배달 {
    private static int minCityChickenDis = Integer.MAX_VALUE;

    // 집, 치킨집 위치를 담을 리스트
    private static List<Point> homes = new ArrayList<>();
    private static List<Point> chickens = new ArrayList<>();

    private static int n;
    private static int m;

    private static boolean[] visited;

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(Point p) {
            return Math.abs(x - p.x) + Math.abs(y - p.y);
        }
    }

    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");

        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);


        // 집, 치킨집 위치 리스트에 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = scanner.nextInt();
                if (value == 1)
                    homes.add(new Point(i, j));
                else if (value == 2)
                    chickens.add(new Point(i, j));
            }
        }

        visited = new boolean[chickens.size()];
        dfs(0, 0);

        System.out.println(minCityChickenDis);
    }

    private static void dfs(int depth, int findIdx) {

        // m인경우 거리 계산
        if (depth == m) {
            int sum = 0;
            for (Point home : homes) {
                int minDis = Integer.MAX_VALUE;
                for (int j = 0; j < visited.length; j++) {
                    if (visited[j])
                        minDis = Math.min(minDis, home.getDistance(chickens.get(j)));

                }
                sum += minDis;
            }
            minCityChickenDis = Math.min(minCityChickenDis, sum);
            return;
        }

        for (int i = findIdx; i < chickens.size(); i++) {
            //이미 방문한 경우
            if (visited[i])
                continue;

            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }


    }
}
