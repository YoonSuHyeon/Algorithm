package programmers.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 다트게임 {
    public int solution(String dartResult) {

        String pattern = "([0-9]|10)([SDT])([#*]?)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(dartResult);

        List<Integer> list = new ArrayList<>();

        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group(1));
            String bonus = matcher.group(2);
            String option = matcher.group(3);

            if (bonus.equals("D"))
                num = (int) Math.pow(num, 2);
            else if (bonus.equals("T"))
                num = (int) Math.pow(num, 3);


            if (option.equals("*")) {
                num *= 2;
                if (list.size() != 0)
                    list.set(list.size() - 1, list.get(list.size() - 1) * 2);

            } else if (option.equals("#")) {
                num *= -1;
            }

            list.add(num);
        }
        return list.stream().mapToInt(i -> i).sum();
    }

    public static void main(String[] args) {
        다트게임 다트게임 = new 다트게임();
        int solution = 다트게임.solution("10S1S0S*");

        System.out.println("solution = " + solution);
    }
}
