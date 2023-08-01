package programmers.lv2;

import java.util.*;
import java.util.stream.Collectors;

public class 광물캐기 {
    public int solution(int[] picks, String[] minerals) {
        //minerals를  25 / 5 / 1 로 변경해서 5개 씩 잘라서 합을 구함
        List<Mineral> mineralList = new ArrayList<>();

        List<Integer> list = Arrays.stream(minerals).map(s -> {
            if (s.equals("diamond"))
                return 25;
            else if (s.equals("iron"))
                return 5;
            return 1;
        }).collect(Collectors.toList());


        int a = picks[0];
        int b = picks[1];
        int c = picks[2];
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i <= (a + b + c) * 5; i++) {

            if (i > minerals.length)
                break;

            sum += list.get(i - 1);
            cnt++;
            if (i % 5 == 0) {
                mineralList.add(new Mineral(cnt, sum));
                sum = 0;
                cnt = 0;
            } else if (i == minerals.length) {
                mineralList.add(new Mineral(cnt, sum));
                sum = 0;
                cnt = 0;
            }
        }

        mineralList.sort(Comparator.comparingInt(Mineral::getSum).reversed());

        int answer = 0;
        for (Mineral m : mineralList) {

            if (a > 0) {
                answer += m.cnt;
                a--;
            } else if (b > 0) {
                if (m.sum == 5) {
                    answer += m.cnt;
                } else if (m.sum == 25) {
                    answer += 5;
                } else {
                    answer += m.sum / 5 + m.sum % 5;
                }
                b--;
            } else if (c > 0) {
                answer += m.sum;
                c--;
            }
        }
        return answer;
    }

    private class Mineral {
        private int cnt;
        private int sum;

        public Mineral(int cnt, int sum) {
            this.cnt = cnt;
            this.sum = sum;
        }

        public int getSum() {
            return sum;
        }

    }

    public static void main(String[] args) {
        광물캐기 광물캐기 = new 광물캐기();
        int solution = 광물캐기.solution(new int[]{1, 0, 1}, new String[]{"iron", "iron", "iron", "iron", "diamond", "diamond", "diamond"});
        System.out.println("solution = " + solution);
    }
}
