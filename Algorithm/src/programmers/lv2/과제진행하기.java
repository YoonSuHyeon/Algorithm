package programmers.lv2;

import java.util.*;
import java.util.stream.Collectors;

public class 과제진행하기 {
    public String[] solution(String[][] plans) {
        List<String> temp = new ArrayList<>();

        //plans 시간 오름 차순으로 정렬
        List<Plan> planList = Arrays.stream(plans)
                .map(p -> new Plan(p[0], parseMinute(p[1]), Integer.parseInt(p[2])))
                .sorted(Comparator.comparingInt(Plan::getStartMinute))
                .collect(Collectors.toList());

        //잔여 plan
        Stack<Plan> stack = new Stack<>();
        for (Plan plan : planList) {

            if (stack.isEmpty()) {
                stack.push(plan);
                continue;
            }

            Plan peek = stack.peek();
            int diff = plan.startMinute - peek.startMinute;
            while (diff >= peek.remainMinute && !stack.isEmpty()) {
                diff = diff - peek.remainMinute;
                stack.pop();
                temp.add(peek.subject);

                if (stack.isEmpty())
                    break;

                peek = stack.peek();
            }
            peek.remainMinute = peek.remainMinute - diff;

            int startMinute = plan.startMinute;
            stack.forEach(s -> s.startMinute = startMinute);

            stack.push(plan);
        }

        while (!stack.isEmpty())
            temp.add(stack.pop().subject);

        String[] answer = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++)
            answer[i] = temp.get(i);

        return answer;
    }

    private static class Plan {
        private String subject;
        private int startMinute;
        private int remainMinute;

        public Plan(String subject, int startMinute, int remainMinute) {
            this.subject = subject;
            this.startMinute = startMinute;
            this.remainMinute = remainMinute;
        }

        public int getStartMinute() {
            return startMinute;
        }
    }

    private int parseMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static void main(String[] args) {
        과제진행하기 과제진행하기 = new 과제진행하기();
        String[][] s = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
        과제진행하기.solution(s);
    }
}
