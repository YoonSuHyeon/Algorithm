package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {

    public int solution(int[] elements) {

        Set<Integer> set = new HashSet<>();
        int length = elements.length;

        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length + i; j++) {

                if (i == j - length)
                    break;

                sum += j < length ? elements[j] : elements[j - length];
                set.add(sum);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        연속부분수열합의개수 연속부분수열합의개수 = new 연속부분수열합의개수();
        int[] elements = {7, 9, 1, 1, 14};
        System.out.println("size = " + 연속부분수열합의개수.solution(elements));


    }
}
