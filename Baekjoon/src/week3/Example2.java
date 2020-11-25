package week3;

import java.util.*;

public class Example2 {
    //가장큰걸 찾고
    public String solution(String s) {
        String answer = "";
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            String sTemp = String.valueOf(s.charAt(i));
            if (i == 0) temp.add(sTemp);
            else {
                int idx = check(temp, sTemp);
                if (idx == temp.size()) { //맨뒤에 들어가는 경우
                    temp.add(sTemp);
                } else if (idx == 0) { //맨 앞에 들어가는 경우
                    temp.clear();
                    temp.add(sTemp);
                } else {//사이에 들어가는 경우

                    System.out.println(idx);
                    ArrayList<String> subList = new ArrayList<String>();
                    for (int j = 0; j < idx; j++) {
                        subList.add(temp.get(j));
                    }
                    temp.clear();

                    for (int j = 0; j < subList.size(); j++) {
                        temp.add(subList.get(j));
                    }
                    temp.add(sTemp);
                }
            }
        }
        for (String it :
                temp) {
            answer += it;
        }
        System.out.println(answer);
        return answer;

    }

    private  int check(ArrayList<String> temp, String s) {
        for (int i = 0; i < temp.size(); i++) {
            if ((temp.get(i).compareTo(s)) < 0) { //클때
                return i;
            }
        }
        return temp.size();
    }

    public static void main(String[] args) {
        new Example2().solution("fedae");
    }
}
