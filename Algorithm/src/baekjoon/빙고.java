package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 빙고 {

    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);

        // 빙고칸 2차원 배열 생성
        for (int i = 0; i < 5; i++) {
            String s = scanner.nextLine();
            List<Integer> s1 = Arrays.stream(s.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            bingoArr[i][0] = s1.get(0);
            bingoArr[i][1] = s1.get(1);
            bingoArr[i][2] = s1.get(2);
            bingoArr[i][3] = s1.get(3);
            bingoArr[i][4] = s1.get(4);
        }

        // 입력 값 리스트 생성
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String s = scanner.nextLine();
            List<Integer> s1 = Arrays.stream(s.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            input.addAll(s1);
        }
        int bingoCnt = 0;
        for (int i = 0; i < input.size(); i++) {
            int findNum = input.get(i);

            List<Integer> pos = check(findNum);
            bingoCnt += (isXBingo(pos.get(0)) + isYBingo(pos.get(1)) + isZBingo(pos.get(0), pos.get(1)));

            if (bingoCnt >= 3) {
                System.out.println(i + 1);
                return;
            }
        }

    }

    private static int[][] bingoArr = new int[5][5];

    private static List<Integer> check(int findNum) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingoArr[i][j] == findNum) {
                    bingoArr[i][j] = 0;
                    return Arrays.asList(i, j);

                }
            }
        }

        throw new RuntimeException();
    }

    /**
     * 가로 체크
     *
     * @param xPos
     * @return
     */
    private static int isXBingo(int xPos) {
        for (int j = 0; j < 5; j++) {
            if (bingoArr[xPos][j] != 0)
                return 0;

        }
        return 1;
    }


    /**
     * 세로 체크
     *
     * @param yPos
     * @return
     */
    private static int isYBingo(int yPos) {
        for (int j = 0; j < 5; j++) {
            if (bingoArr[j][yPos] != 0)
                return 0;

        }
        return 1;
    }


    /**
     * 대각선 체크
     *
     * @param yPos
     * @return
     */
    private static int isZBingo(int xPos, int yPos) {
        int bingoCnt = 0;

        // 오른쪽 하향 대각선
        boolean rightZ = xPos == yPos && IntStream.range(0, 5).allMatch(i -> bingoArr[i][i] == 0);
        if (rightZ)
            bingoCnt++;

        // 왼쪽 하향 대각선
        boolean leftZ = (xPos + yPos) % 4 == 0 && xPos + yPos > 0 && xPos + yPos < 8 && IntStream.range(0, 5).allMatch(i -> bingoArr[i][4 - i] == 0);
        if (leftZ)
            bingoCnt++;


        return bingoCnt;
    }


}
