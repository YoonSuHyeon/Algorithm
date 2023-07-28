package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 무인도여행 {
    public int[] solution(String[] maps) {

        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (!visited[i][j]) {
                    int groupSum = dfs(i, j, visited, maps);
                    if (groupSum > 0)
                        list.add(groupSum);
                }
            }
        }

        if (list.isEmpty())
            return new int[]{-1};

        return list.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public int dfs(int posX, int posY, boolean[][] visited, String[] maps) {
        if (posX < 0 || posX > visited.length - 1)
            return 0;

        if (posY < 0 || posY > visited[0].length - 1)
            return 0;

        if (visited[posX][posY])
            return 0;

        char c = maps[posX].charAt(posY);
        if (c == 'X')
            return 0;

        String s = String.valueOf(c);
        visited[posX][posY] = true;

        return Integer.parseInt(s) + dfs(posX + 1, posY, visited, maps) + dfs(posX - 1, posY, visited, maps) + dfs(posX, posY + 1, visited, maps) + dfs(posX, posY - 1, visited, maps);
    }

    public static void main(String[] args) {
        무인도여행 무인도여행 = new 무인도여행();
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
        무인도여행.solution(maps);
    }
}
