package programmers.lv2;

/**
 * k 칸  OR (현재까지 온 거리) * 2 = 순간이동
 * 순간 이동을 하면 건전지 사용량이 줄지 않는다.
 * k칸 을 가능경우 k만큼 건전지가 소모된다.
 * 건전지 사용량을 줄이기 위해 점프로 이동하는 것을 최소로 해야함
 * 거리 N이 주어진 경우 건전지 사용량의 최솟값을 return
 * <p>
 * <p>
 * 1  J
 * 2  J J
 * 3  J   S
 * 4  J   S J
 * 5  J   S   S
 */
public class 점프와순간이동 {
    public int solution(int n) {

        // N이 1인경우 = 1 , N이 2인경우 = 2
        int ans = 1;
        while (n > 1) {
            //짝수
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            //홀수
            n -= 1;
            ans++;
        }

        return ans;
    }
}
