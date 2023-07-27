package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 줄서는방법 {

    private List<Integer> last = new ArrayList<>();

    public int[] solution(int n, long k) {

        List<Integer> list = new ArrayList<>();
        dfs(list, n, k);
        return last.stream().mapToInt(i -> i).toArray();
    }

    public void dfs(List<Integer> list, int n, long k) {

        if (last.size() == k)
            return;

        if (list.size() == n) {
            last = list;
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (!list.contains(i)) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(i);
                dfs(copy, n, k);
            }
        }
    }

    public int[] solution1(int n, long k) {
        int[] answer = new int[n];

        ArrayList<Integer> list = new ArrayList<>();
        long factorial = 1;

        // 팩토리얼 계산, 리스트 생성
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            list.add(i);
        }

        // 인덱스를 맞추기위함
        k--;

        int idx = 0;
        while (n > 0) {
            // 각 자리에 들어갈 경우의 수
            factorial /= n;
            // 자리 숫자 결정
            int val = (int) (k / factorial);
            // 정답 배열에 숫자 삽입
            answer[idx] = list.get(val);
            list.remove(val);

            // 다음 자리수를 구하기 위해 k값 변경
            k %= factorial;
            idx++;
            n--;
        }
        return answer;
    }

    public static void main(String[] args) {
        줄서는방법 줄서는방법 = new 줄서는방법();
        줄서는방법.solution(3, 5);
    }
}
