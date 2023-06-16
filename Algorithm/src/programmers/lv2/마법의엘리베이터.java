package programmers.lv2;

public class 마법의엘리베이터 {


    /**
     * 로직 : 1236 -> 일의 자리 부터 시작을해서 6보다 크거나, 5보다 크고 현재 자리보다 앞의 자리가 5보다 크면  부족한 수를 더해주고 다음 자리수로 올려준다라는것이 기본 로직
     *
     * @param storey
     * @return
     */
    public int solution(int storey) {

        int answer = 0;
        int size = Integer.toString(storey).length() + 2;

        for (long i = 10; i < Math.pow(10, size); i = i * 10) {

            if (storey % i >= 6 * i / 10) {
                long diff = i - storey % i;
                storey += diff;
                answer += diff % i / (i / 10);
            } else if (storey % i >= 5 * i / 10 && (storey / i % 10) >= 5) {
                long diff = i - storey % i;
                storey += diff;
                answer += diff % i / (i / 10);
            } else {
                answer += storey % i / (i / 10);
                storey -= storey % i;

            }

        }
        return answer;
    }

    /**
     * 정리 한 코드
     *
     * @param storey
     * @return
     */
    public int solution1(int storey) {

        int answer = 0;
        while (storey > 0) {

            int currentNum = storey % 10;
            int nextNum = storey % 100 / 10;

            if (currentNum >= 6 || (currentNum >= 5 && nextNum >= 5)) {
                storey += 10;
                answer = answer + (10 - currentNum);
            } else
                answer += currentNum;

            storey /= 10;

        }
        return answer;
    }

    public static void main(String[] args) {
        마법의엘리베이터 마법의엘리베이터 = new 마법의엘리베이터();
        System.out.println("마법의엘리베이터 = " + 마법의엘리베이터.solution(555));

    }
}
