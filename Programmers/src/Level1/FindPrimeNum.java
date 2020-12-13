package Level1;

import java.util.Arrays;

public class FindPrimeNum {

    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];

        for (int i = 2; i <= n; i++) {
            if(arr[i]==1) continue;
            for(int j=2*i;j<=n;j+=i){
                arr[j]=1;
            }
        }

        long count = Arrays.stream(arr).filter(it -> it == 0).count();
        return (int) count-2;  //0과 1 제외
    }

    public static void main(String[] args) {
        new FindPrimeNum().solution(10);
    }
}
