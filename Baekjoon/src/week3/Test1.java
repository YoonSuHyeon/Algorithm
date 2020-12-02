package week3;

public class Test1 {

    public String solution(String[] strs) {
        String answer = "";
        boolean same = true;
        for(int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length() <= i) {
                    same = false;
                    break;
                }
                else if(temp == strs[j].charAt(i)) {
                    continue;
                }
                same = false;
                break;
            }

            if(same) answer+=temp;
            else break;
        }

        return answer;
    }
    public static void main(String[] args) {
        String[]  temp={"abcaefg", "abcdefg", "abcdhfg"};
        new Test1().solution(temp);
    }
}
