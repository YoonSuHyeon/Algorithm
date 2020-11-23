package Level2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepeatToBinary {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(String.valueOf(s.charAt(i)));
        }
        while (true) {
            List<String> collect = list.stream().filter(it -> it.equals("1")).collect(Collectors.toList());
            long addSize = collect.size();
            long removeSize = list.size() - addSize;
            String binaryString = Integer.toBinaryString(Long.valueOf(addSize).intValue());
            list.clear();
            for (int i = 0; i < binaryString.length(); i++) {
                list.add(String.valueOf(binaryString.charAt(i)));
            }

            answer[0] = answer[0] + 1;

            answer[1] = answer[1] + Long.valueOf(removeSize).intValue();
            if (addSize == 1) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        RepeatToBinary RepeatToBinary = new RepeatToBinary();
        RepeatToBinary.solution("110010101001");
    }
}
