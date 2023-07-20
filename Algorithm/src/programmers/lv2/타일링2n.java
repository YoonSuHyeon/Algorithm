package programmers.lv2;

/**
 * 2 x n 타일링
 */
public class 타일링2n {
    private static final int MOD = 1000000007;

    public int solution(int n) {
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        for (int i = 2; i < n; i++)
            a[i] = (a[i - 2] + a[i - 1]) % MOD;

        return a[n - 1];
    }

    public static void main(String[] args) {
        타일링2n 타일링2n = new 타일링2n();
        int solution = 타일링2n.solution(4);
        System.out.println("solution = " + solution);
    }
}
