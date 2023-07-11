package programmers.lv1;

public class 카드뭉치 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {

        int i = 0;
        int j = 0;
        int k = 0;
        while (true) {

            if (i < cards1.length && goal[k].equals(cards1[i])) {
                k++;
                i++;
            } else if (j < cards2.length && goal[k].equals(cards2[j])) {
                k++;
                j++;
            } else {
                return "No";
            }

            if (k == goal.length)
                break;
        }
        return "Yes";
    }

    public static void main(String[] args) {
        카드뭉치 카드뭉치 = new 카드뭉치();
        String[] cards1 = {"a", "b", "c"};
        String[] cards2 = {"d", "e", "f"};
        String[] goal = {"a", "d", "f"};
        카드뭉치.solution(cards1, cards2, goal);
    }
}
