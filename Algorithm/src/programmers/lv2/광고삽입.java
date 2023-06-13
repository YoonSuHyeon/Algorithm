package programmers.lv2;

import java.util.stream.IntStream;

public class 광고삽입 {


    public String solution(String play_time, String adv_time, String[] logs) {

        // 재생 시간을 초로 변환
        int playTime = convertToSecond(play_time);

        // playerTime(초) 크기 만큼 배열 생성
        int[] secArray = new int[playTime + 1];

        // logs를 확인해서 초마다 실시간 유저 시청하고 있는 사람을 확인함.
        for (String log : logs) {
            //log는 H1:M1:S1-H2:M2:S2
            String[] temp = log.split("-");

            int startSecond = convertToSecond(temp[0]);
            int endSecond = convertToSecond(temp[1]);

            // 해당 초마다 시청 중이라는 것을 +1을 해서 남겨둔다.
            IntStream.rangeClosed(startSecond + 1, endSecond).forEach(i -> secArray[i]++);
        }


        // 광고 시간을 초르 변환
        int advTime = convertToSecond(adv_time);

        // 누적 재생 시간 (입력제한에서 최대치를 사용하는 경우 Integer.MAX_VALUE를 넘기 때문에 long으로 사용)
        long max = 0;
        for (int i = 0; i < advTime; i++)
            max += secArray[i];

        long beforeSum = max;
        int maxIdx = 0;
        for (int i = advTime; i <= playTime; i++) {

            beforeSum = beforeSum + secArray[i] - secArray[i - advTime];
            if (max < beforeSum) {
                max = beforeSum;
                maxIdx = i - advTime;
            }

        }

        return convertToStr(maxIdx);
    }

    /**
     * HH:MM:SS 형식을 초 단위로 변경
     *
     * @param time
     * @return
     */
    private int convertToSecond(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 3600 + Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);

    }

    private String convertToStr(int time) {
        int h = time / 3600;
        int m = (time - 3600 * h) / 60;
        int s = time - 3600 * h - 60 * m;

        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public static void main(String[] args) {
        String play_time = "99:59:59";
        String adv_time = "25:00:00";

        String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};

        광고삽입 광고삽입 = new 광고삽입();
        System.out.println("광고삽입 = " + 광고삽입.solution(play_time, adv_time, logs));


    }
}