package programmers.lv1;

public class 둘만의암호 {
    public String solution(String s, String skip, int index) {

        StringBuilder answer = new StringBuilder();
        for (char c : s.toCharArray()) {

            int addCnt = index;
            while (addCnt > 0) {

                if (c == 'z')
                    c = 'a';
                else
                    c++;

                if (skip.indexOf(c) == -1)
                    addCnt--;

            }
            answer.append(c);
        }
        return answer.toString();
    }

}
