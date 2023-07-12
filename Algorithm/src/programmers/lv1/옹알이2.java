package programmers.lv1;

public class 옹알이2 {
    private static final String[] BABY = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;
        for (String s : babbling) {
            String beforeString = "";
            while (true) {
                boolean isChanged = false;

                for (String bs : BABY) {
                    if (s.startsWith(bs) && !beforeString.equals(bs)) {
                        s = s.substring(bs.length());
                        isChanged = true;
                        beforeString = bs;
                        break;
                    }
                }

                if (!isChanged)
                    break;

                if (s.isEmpty())
                    answer++;
            }

        }

        return answer;
    }
}
