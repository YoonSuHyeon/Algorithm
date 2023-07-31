package programmers.lv2;

import java.util.Arrays;

public class 호텔대실 {
    public int solution(String[][] book_time) {

        int[] timeTable = new int[86401];
        for (String[] t : book_time) {
            String[] start = t[0].split(":");
            String[] end = t[1].split(":");

            int startMin = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endMin = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

            for (int i = startMin; i < endMin + 10; i++)
                timeTable[i]++;

        }

        return Arrays.stream(timeTable).max().orElse(0);
    }
}
