package programmers.lv3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 단어변환 {

    /**
     * 문제 해결 : begin을 시작해서 words로 bfs 진행
     * bfs : 이미 방문한 word를 제외하고 단어중 한개만 다른경우에만 탐색한다.
     * 탐색중 target와 동일한 경우 종료
     *
     * @param begin
     * @param target
     * @param words
     * @return
     */
    public int solution(String begin, String target, String[] words) {

        Queue<WordDepth> queue = new LinkedList<>();
        queue.add(new WordDepth(begin, 0));

        Set<String> visited = new HashSet<>();
        int answer = 0;

        while (!queue.isEmpty()) {
            WordDepth wd = queue.poll();

            // target과 동일한 경우
            if (wd.s.equals(target)) {
                answer = wd.depth;
                break;
            }

            // bfs 탐색
            for (String word : words) {

                // 문자열 같거나 두개이상 다른경우, 이미 탐색을 한경우
                if (!check(wd.s, word) || visited.contains(word))
                    continue;


                // 방문할 wordDepth추가 및 방문 기록 추가
                WordDepth wordDepth = new WordDepth(word, wd.depth + 1);
                visited.add(word);
                queue.add(wordDepth);
            }

        }

        return answer;
    }

    private static class WordDepth {
        private String s;
        private int depth;

        public WordDepth(String s, int depth) {
            this.s = s;
            this.depth = depth;
        }

    }

    private boolean check(String s, String word) {
        int diffCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != word.charAt(i)) {
                diffCnt++;
                if (diffCnt > 1)
                    return false; // 2개 이상 다른 문자가 있으면 false를 반환
            }
        }

        return diffCnt == 1;
    }

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        new 단어변환().solution("hit", "cog", words);
    }
}
