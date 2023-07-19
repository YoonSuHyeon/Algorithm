package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {

    private static final String[] ALP = {"A", "E", "I", "O", "U"};
    private static final List<String> list = new ArrayList<>();

    public int solution(String word) {
        bfs("");
        return list.indexOf(word);
    }

    public void bfs(String s) {
        list.add(s);

        if (s.length() == 5)
            return;

        for (String value : ALP)
            bfs(s + value);
    }

    public static void main(String[] args) {
        모음사전 모음사전 = new 모음사전();
        int idx = 모음사전.solution("AAAAE");
        System.out.println("idx = " + idx);
    }
}
