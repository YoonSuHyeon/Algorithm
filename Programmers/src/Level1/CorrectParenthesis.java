package Level1;

public class CorrectParenthesis {
    boolean solution(String s) {
        boolean answer = true;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                if (left == 0) {
                    answer = false;
                } else {
                    left--;
                }

            }
        }
        if(left !=0) answer=false;
        System.out.println("answer = " + answer);

        return answer;
    }

    public static void main(String[] args) {
        new CorrectParenthesis().solution("(()(");
    }
}
