package baekjoon;

import java.util.*;
import java.util.stream.Collectors;

public class 숫자야구 {

    private static class BullsAndCows {
        private int num;
        private int strike;
        private int ball;

        public BullsAndCows(int num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }

    }

    /**
     * 0이 포함 되거나,중복된 수가 있는경우는 전부 제거
     *
     * @return
     */
    private static Set<Integer> init() {

        Set<Integer> set = new HashSet<>();
        for (int i = 123; i <= 987; i++) {
            String numString = Integer.toString(i);

            if (!numString.contains("0") && !isDuplicateNum(numString)) {
                set.add(i);
            }
        }

        return set;
    }

    private static boolean isDuplicateNum(String numString) {
        Set<Character> digitSet = new HashSet<>();

        for (char digit : numString.toCharArray()) {
            if (!digitSet.add(digit))
                return true; // 중복된 숫자가 있는 경우 true 반환

        }
        return false; // 중복된 숫자가 없는 경우 false 반환
    }

    public static void main(String[] args) {

        // 입력
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<BullsAndCows> input = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            List<Integer> s1 = Arrays.stream(s.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            input.add(new BullsAndCows(s1.get(0), s1.get(1), s1.get(2)));
        }

        Set<Integer> availableNums = init();

        for (BullsAndCows bac : input) {
            Set<Integer> removeNums = new HashSet<>();
            for (int i : availableNums) {
                //i가 정답인 경우 해당 입력 값에 값이 나오는지 확인
                if (!check(i, bac.num, bac.strike, bac.ball))
                    removeNums.add(i);

            }
            availableNums.removeAll(removeNums);
        }

        System.out.println(availableNums.size());
    }

    private static boolean check(int answer, int check, int strikeCnt, int ballCnt) {

        String answerStr = Integer.toString(answer);
        String checkStr = Integer.toString(check);

        int tempStrikeCnt = 0;
        int tempBallCnt = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean isSame = answerStr.charAt(i) == checkStr.charAt(j);
                if (i == j && isSame)
                    tempStrikeCnt++;
                else if (isSame)
                    tempBallCnt++;
            }
        }

        return strikeCnt == tempStrikeCnt && ballCnt == tempBallCnt;
    }


}

