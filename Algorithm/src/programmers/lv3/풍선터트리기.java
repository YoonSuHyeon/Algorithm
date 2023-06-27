package programmers.lv3;

public class 풍선터트리기 {

    /**
     * 9,1,5 <br>
     * 9,10,5  <br>
     * 문제해결 : 왼쪽 끝과 오른쪽 끝은 무조건 가능하다.(왼쪽인 경우 오른쪽의 어떤수가 나와도 내가 작다면 큰 것을 터트리고 크다면 작은걸 터트리면 되기 떄문)
     * 처음과 끝을 제외한 경우 : 양쪽에 있는 수가 남기려고 하는 풍선의 적힌 수보다 작은 경우는 해당 풍선을 남길수 없다.
     * 어떤 방법으로 양쪽에 수가와도 특정 인덱스 양쪽에 왼쪽과 오른쪽의 최솟값이 오는 경우에도 남기려는 풍선의 수보다 작은경우는 이풍선을 남길수 없는 풍선이다.
     *
     * @param a
     * @return
     */
    public int solution(int[] a) {

        // a의 길이가 1이상이기떄문에 처리
        if (a.length == 1)
            return 1;


        // a의 길이가 2이상인 경우는 양쪽에 있는 값은 남길 수 있기 떄문에 기본값 2
        int answer = 2;

        if (a.length == 2)
            return 2;

        // 맨처음인덱스와 맨마지막 인덱스를 제외하고 왼쪽 오른쪽 min값을 갖을수 있는 2차원 배열 생성
        int[][] min = new int[a.length][2];

        // min값 생성
        int leftMin = a[0];
        int rightMin = a[a.length - 1];

        for (int i = 1; i < a.length; i++) {
            leftMin = Math.min(leftMin, a[i - 1]);
            min[i][0] = leftMin;

            rightMin = Math.min(rightMin, a[a.length - i]);
            min[a.length - 1 - i][1] = rightMin;
        }


        for (int i = 1; i < a.length - 1; i++) {

            if (min[i][0] < a[i] && min[i][1] < a[i])
                continue;

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};
        int solution = new 풍선터트리기().solution(a);
        System.out.println("solution = " + solution);
    }
}
