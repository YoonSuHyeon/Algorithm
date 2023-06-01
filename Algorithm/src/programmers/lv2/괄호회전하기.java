package programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 괄호회전하기 {


    public int solution(String s) {
        int answer = 0;
        int size = s.length();


        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < size; i++) {

            // 올바른지 확인
            if (check(s, map))
                answer++;
            //문자열 다시 생성
            s = s.substring(1) + s.charAt(0);
        }

        return answer;
    }

    public boolean check(String s, Map<Character, Character> map) {
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                list.add(c);
                continue;
            }

            if (list.isEmpty())
                return false;

            if (map.get(list.get(list.size() - 1)) != c)
                return false;

            list.remove(list.size() - 1);
        }

        return list.isEmpty();
    }


    public static void main(String[] args) {
        괄호회전하기 괄호회전하기 = new 괄호회전하기();
        System.out.println("괄호회전하기 = " + 괄호회전하기.solution("}]()[{"));
    }
}
