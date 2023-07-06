package programmers.lv1;

public class 크기가작은부분문자열 {
    public int solution(String t, String p) {
        int answer = 0;
        long pValue = Long.parseLong(p);
        int pLength = p.length();

        //5번
        for (int i = 0; i <= t.length() - pLength; i++) {
            long subValue = Long.parseLong(t.substring(i, i + pLength));

            if (subValue <= pValue)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "123";
        int i = Integer.parseInt(s.substring(0, 3));
        System.out.println("i = " + i);
    }
}
