package programmers.lv1;

public class 덧칠하기 {

    public int solution(int n, int m, int[] section) {

        int answer = 0;
        int temp = section[0] + m;
        answer++;

        for (int i = 1; i < section.length; i++) {
            if (temp > section[i])
                continue;

            temp = section[i] + m;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        덧칠하기 덧칠하기 = new 덧칠하기();
        int[] section = {2, 3, 6};
        덧칠하기.solution(8, 4, section);

    }
}
