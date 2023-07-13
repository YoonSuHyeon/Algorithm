package programmers.lv1;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 햄버거만들기 {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i : ingredient) {
            stack.push(i);

            if (stack.size() >= 4) {
                if (IntStream.range(stack.size() - 4, stack.size()).mapToObj(k -> String.valueOf(stack.get(k))).collect(Collectors.joining("")).equals("1231")) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                }

            }

        }
        return answer;
    }


    public static void main(String[] args) {
        new 햄버거만들기().solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1});
    }
}
