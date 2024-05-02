package programmers.lv2;

public class 두원사이의정수쌍 {
    public long solution(int r1, int r2) {
        long answer = 0;
        long temp = 0;
        for (int i = 0; i <= r2; i++) {
            double y1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
            double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));

            answer += ((long) y2 - (long) Math.ceil(y1) + 1);
            if (i == 0){
                temp = ((long) y2 - (long) Math.ceil(y1) + 1);
            }

        }

        return answer * 4L - temp * 4L;
    }

    public static void main(String[] args) {
        두원사이의정수쌍 두원사이의정수쌍 = new 두원사이의정수쌍();
        두원사이의정수쌍.solution(2, 3);
    }

}
