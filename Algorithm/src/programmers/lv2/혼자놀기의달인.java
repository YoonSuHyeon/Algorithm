package programmers.lv2;

public class 혼자놀기의달인 {
    public int solution(int[] cards) {

        boolean[] visited = new boolean[cards.length];
        int[] max = new int[2];

        for (int i = 0; i < cards.length; i++) {

            int cnt = 0;
            int temp = cards[i] - 1;
            while (!visited[temp]) {

                cnt++;
                visited[temp] = true;
                temp = cards[temp] - 1;
            }

            if (max[0] == 0) {
                max[0] = cnt;
            } else if (max[1] == 0) {
                max[1] = cnt;
            } else if (max[0] > max[1]) {
                max[1] = Math.max(max[1], cnt);
            } else if (max[0] < max[1]) {
                max[0] = Math.max(max[0], cnt);
            } else if (max[0] == max[1]) {
                max[1] = Math.max(max[1], cnt);
            }

        }
        return max[0] * max[1];
    }

    public static void main(String[] args) {
        혼자놀기의달인 혼자놀기의달인 = new 혼자놀기의달인();
        System.out.println("혼자놀기의달인 = " + 혼자놀기의달인.solution(new int[]{2, 1, 3}));
    }
}
