package programmers.lv2;

public class 연속된부분수열의합 {

    public int[] solution(int[] sequence, int k) {
        int length = sequence.length - 1;
        int sum = sequence[length];
        int x = length;
        int y = length;
        int[] answer = {0, length};

        while (true) {
            if (k == sum) {
                if (y - x <= answer[1] - answer[0]) {
                    answer[0] = x;
                    answer[1] = y;
                }
                if (x == 0)
                    break;
                x--;
                sum += sequence[x];
            } else if (k > sum) {
                if (x == 0)
                    break;
                x--;
                sum += sequence[x];
            } else {
                if (x == y) {
                    if (x == 0)
                        break;
                    x--;
                    y--;
                    sum = sequence[x];
                } else {
                    sum -= sequence[y];
                    y--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        연속된부분수열의합 연속된부분수열의합 = new 연속된부분수열의합();
        연속된부분수열의합.solution(new int[]{2, 2, 2, 2, 2}, 6);
    }
}
