package programmers.lv1;

public class 기사단원의무기 {

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int temp = 0;
            int sqrt = (int) Math.sqrt(i);

            for (int j = 1; j <= sqrt; j++) {

                if (i % j == 0) {
                    temp += 2;

                    if (i / j == sqrt)
                        temp--;
                }
            }

            if (temp > limit)
                temp = power;

            answer += temp;
        }
        return answer;
    }

    /**
     * 나눌 필요도 없다.
     *
     * @param number
     * @param limit
     * @param power
     * @return
     */
    public int solution2(int number, int limit, int power) {
        int[] count = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                count[i * j]++;
            }
        }

        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        기사단원의무기 기사단원의무기 = new 기사단원의무기();
        기사단원의무기.solution(5, 3, 2);
    }
}
