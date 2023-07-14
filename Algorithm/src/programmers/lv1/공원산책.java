package programmers.lv1;

public class 공원산책 {

    private static int[] answer = new int[2];

    public int[] solution(String[] park, String[] routes) {

        for (int i = 0; i < park.length; i++) {
            if (park[i].indexOf('S') != -1) {
                answer[0] = i;
                answer[1] = park[i].indexOf('S');
                break;
            }
        }

        for (String route : routes) {
            String[] s = route.split(" ");

            String direction = s[0];
            int distance = Integer.parseInt(s[1]);

            move(answer[0], answer[1], direction, distance, 0, park);

        }
        return answer;
    }

    public void move(int currentX, int currentY, String direction, int distance, int sum, String[] park) {

        if (distance == sum && park[currentX].charAt(currentY) != 'X' ) {
            answer[0] = currentX;
            answer[1] = currentY;
        }

        if (distance == sum)
            return;

        if(park[currentX].charAt(currentY) == 'X')
            return;

        if (direction.equals("N") && answer[0] - distance >= 0)
            move(currentX - 1, currentY, direction, distance, sum + 1, park);
        else if (direction.equals("S") && answer[0] + distance < park.length)
            move(currentX + 1, currentY, direction, distance, sum + 1, park);
        else if (direction.equals("W") && answer[1] - distance >= 0)
            move(currentX, currentY - 1, direction, distance, sum + 1, park);
        else if (direction.equals("E") && answer[1] + distance < park[0].length())
            move(currentX, currentY + 1, direction, distance, sum + 1, park);

    }

    public static void main(String[] args) {
        공원산책 공원산책 = new 공원산책();
        String[] park = {"SOO", "OXX", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};
        공원산책.solution(park, routes);
    }
}
