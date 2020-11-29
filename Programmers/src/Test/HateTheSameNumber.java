package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HateTheSameNumber {

    public int[] solution(int []arr) {


        int[] temp = IntStream.range(0, arr.length)
                .filter(i -> {
                             if(i==0) {
                            return true;
                            }else if(arr[i] != arr[i - 1])return true;
                             else return false;
                        }
                ).toArray();
        int[] answer = new int[temp.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr[temp[i]];
        }

        return answer;
    }


    public static void main(String[] args) {

        int [] temp = {1,1,3,3,0,1,1};
        new HateTheSameNumber().solution(temp);
    }
}
