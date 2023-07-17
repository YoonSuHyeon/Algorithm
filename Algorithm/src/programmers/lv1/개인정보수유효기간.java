package programmers.lv1;

import java.util.*;

public class 개인정보수유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {


        // Map 초기화
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }

        int[] todays = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();

        int todaySum = todays[0] * 12 * 28 + todays[1] * 28 + todays[2];

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");

            int[] split = Arrays.stream(s[0].split("\\.")).mapToInt(Integer::parseInt).toArray();

            int addDays = map.get(s[1]) * 28;

            int year = split[0] * 12 * 28;
            int month = split[1] * 28;
            int day = split[2] - 1;

            int sum = year + month + day + addDays;


            if (todaySum > sum)
                answer.add(i + 1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        개인정보수유효기간 개인정보수유효기간 = new 개인정보수유효기간();

        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        개인정보수유효기간.solution("2022.05.19", terms, privacies);
    }
}
