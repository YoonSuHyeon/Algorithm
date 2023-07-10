package programmers.lv1;

public class 푸드파이트대회 {
    public String solution(int[] food) {

        // 왼쪽 선수 음식을 만든다.
        StringBuilder leftString = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int cnt = food[i] / 2;
            for (int j = 0; j < cnt; j++)
                leftString.append(i);

        }

        StringBuilder rightString = new StringBuilder(leftString).reverse();
        return leftString + "0" + rightString;
    }
}
