package Test;

import java.util.ArrayList;

public class PLATEER {
    public int solution(int n) {
        int answer = 0;

        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            System.out.println("String.valueOf(s.charAt(i) = " +s.charAt(i));
            answer+=Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
    public int[] solution(int []arr) {

        ArrayList<Integer> list = new ArrayList<>();
        int preInt=-1;
        for (int i :
                arr) {
            if (!(preInt==i)){
                list.add(i);
                preInt=i;
            }
        }
        int[] answer = new int [list.size()];
        for(int i = 0 ; i<list.size();i++ ){
            answer[i]=list.get(i);
        }

        return  answer;
    }

    public static void main(String[] args) {
        new PLATEER().solution(123);
        int [] temp ={1,1,3,3,0,1,1};
        new PLATEER().solution(temp);
    }
}
