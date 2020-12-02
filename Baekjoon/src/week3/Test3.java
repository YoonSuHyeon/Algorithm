package week3;

import java.util.ArrayList;

public class Test3 {
    public int[] solution(int[] price) {
        int[] answer = new int[price.length];
        for (int i = 0; i < price.length; i++) {
            int count=1;

            for (int j = i+1; j < price.length; j++) {
                if(price[i]<price[j]) {
                    answer[i]=count;
                    break;
                }
                else{
                    if(j+1==price.length){
                       answer[i]=-1;
                    }
                    count++;
                }
            }


        }
        answer[price.length-1]=-1;
        return answer;
    }

    public static void main(String[] args) {
        int[] temp = {4,1,4,7,6};
        new Test3().solution(temp);
    }
}
