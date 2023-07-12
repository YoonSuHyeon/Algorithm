package programmers.lv1;

public class 문자열나누기 {

    public int solution(String s) {

        int answer = 0;
        int diffCnt = 0;
        int sameCnt = 0;
        Character beforeC = null;

        for (int i = 0; i < s.length(); i++) {

            if (beforeC == null)
                beforeC = s.charAt(i);

            if (s.charAt(i) == beforeC)
                sameCnt++;
            else
                diffCnt++;

            if (sameCnt == diffCnt) {
                answer++;
                beforeC = null;
            }
        }
        return beforeC != null ? answer + 1 : answer;
    }

}
