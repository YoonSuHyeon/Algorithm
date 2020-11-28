package Level3;

import java.util.Arrays;
import java.util.OptionalInt;

public class OvertimeIndex {
    public long solution(int n, int[] works) {
        long answer = 0;
        Arrays.sort(works); //오름 차순 정렬
        int presentSum = Arrays.stream(works).sum();
        int sum = Arrays.stream(works).sum();

        sum -= n;
        if (sum <= 0) return 0;
        for (int i = 0; i < works.length; i++) {
            if (sum == 0) break;
            if (works[i] * (works.length - i) >= sum) {

                int mount = sum / (works.length - i);

                sum = sum - mount * (works.length - i);

                distribute(mount, i, works, sum);
                sum = 0;
            } else {
                sum = sum - works[i];
            }
        }

        for (int i = 0; i < works.length; i++) {
            answer = answer + works[i] * works[i];
        }


        Arrays.stream(works).forEach(it-> System.out.println("it = " + it));

        System.out.println(" = " +Arrays.stream(works).sum() );
        System.out.println("presentSum = " + presentSum);

        return answer;

        //효율성실패
        /*for (int i = 0; i < n; i++) {
            OptionalInt max = Arrays.stream(works).max();
            for (int j = works.length-1; j >= 0; j--) {
                if(works[j]==max.getAsInt()&&works[j]!=0){
                    works[j]--;
                    break;
                }
            }
        }*/


    }

    private void distribute(int disNum, int pos, int[] works, int sum) {
        for (int i = pos; i < works.length; i++) {
            if (sum != 0) {
                works[i] = disNum + 1;
                sum--;
            } else {
                works[i] = disNum;
            }
        }

        System.out.println(sum);
    }


    public static void main(String[] args) {
       int[] works = {159,218,114,214,321,451,11,25,59,14,54,428,559};
     //   int[]works ={4,3,3};
        new OvertimeIndex().solution(1400, works);
    }
}
