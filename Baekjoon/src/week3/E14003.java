package week3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class E14003 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[0];
        int size = 0;
        try {
            size = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pair[] idx = new Pair[size];
        int[] dp = new int[size];
        dp[0] = arr[0];
        idx[0] = new Pair(0, arr[0]);
        int index = 0;

        for (int i = 1; i < size; i++) {
            if (dp[index] < arr[i]) {
                dp[++index] = arr[i];
                idx[i] = new Pair(index, arr[i]);
            } else {
                int temp = lower_bound(index, arr[i], dp);
                dp[temp] = arr[i];
                idx[i] = new Pair(temp, arr[i]);
            }

        }
        System.out.println(index + 1);
        Stack<Integer> answer = new Stack<>();
        for (int j = idx.length - 1; j >= 0; j--) {
            if (idx[j].getIdx() == index) {
                answer.push(idx[j].getValue());
                index--;
            }
        }
        while (answer.size() != 0) {
            System.out.print(answer.pop() + " ");
        }
    }

    private static int lower_bound(int index, int i, int[] dp) {
        int start = 0;

        while (start < index) {
            int mid = (start + index) / 2;
            if (dp[mid] >= i) {
                index = mid;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }

   static class Pair{
        int idx;
        int value;

        public Pair(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

       public int getIdx() {
           return idx;
       }

       public void setIdx(int idx) {
           this.idx = idx;
       }

       public int getValue() {
           return value;
       }

       public void setValue(int value) {
           this.value = value;
       }
   }
}
