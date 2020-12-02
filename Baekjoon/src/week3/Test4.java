package week3;

import java.util.ArrayList;
import java.util.Collections;

public class Test4 {
    public int[] solution(int[][] customer, int K) {

        ArrayList<String> rooms = new ArrayList<>();//방
        ArrayList<String> line=new ArrayList<>();//대기자
        for (int[] t:customer) {
            if(t[1]==1){
                if(rooms.size()<K){//예약
                    if(!rooms.contains(String.valueOf(t[0]))){
                        rooms.add(String.valueOf(t[0]));
                    }
                }else{//대기
                    if(!line.contains(String.valueOf(t[0]))){
                        line.add(String.valueOf(t[0]));
                    }

                }
            }else{//취소
                if(rooms.contains(String.valueOf(t[0]))){
                    rooms.remove(String.valueOf(t[0]));
                    if(!line.isEmpty()){
                        rooms.add(line.get(0));
                        line.remove(0);
                    }
                }else{
                    line.remove(String.valueOf(t[0]));
                }
            }
        }
        int[] answer = new int[rooms.size()];
        Collections.sort(rooms);
        for (int i = 0; i < rooms.size(); i++) {
            answer[i]=Integer.parseInt(rooms.get(i));
        }
        rooms.forEach(it-> System.out.println("it = " + it));
        for (int i = 0; i < answer.length; i++) {
            System.out.println("answer = " + answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] temp = {{2, 1}, {1, 1}, {3,1}, {4, 1}, {5, 1},{6,1},{6,1},{7,1},{8,1}};
        new Test4().solution(temp, 5);
    }
}
