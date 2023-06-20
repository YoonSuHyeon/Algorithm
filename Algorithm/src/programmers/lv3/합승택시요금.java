package programmers.lv3;

public class 합승택시요금 {

    private static int[][] dist;

    /**
     * 100000 * (n - 1)  : 최대 비용  n 은  200이하 이기 때문에 안전하게 200을 곱한 값을 사용 <br>
     * 가장 큰값을 Integer.MAX_VALUE로 하지 않은 이유는 위 처럼 int 범위를 넘어 갈수 있기 떄문이다.
     */
    private static final int MAX_F = 20000000;

    public int solution(int n, int s, int a, int b, int[][] fares) {

        //dist 초기화
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j)
                    dist[i][j] = MAX_F;
            }
        }

        // 초기 경로 값 지정
        for (int[] fare : fares) {
            dist[fare[0] - 1][fare[1] - 1] = fare[2];
            dist[fare[1] - 1][fare[0] - 1] = fare[2];
        }

        //플로이드 워셜 알고리즘을 사용해서 각 노드당 최단 거리 생성
        for (int k = 0; k < n; k++) {
            // 노드 i에서 j로 가는 경우.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int result = MAX_F;
        for (int i = 0; i < n; i++)
            result = Math.min(result, dist[s - 1][i] + dist[i][a - 1] + dist[i][b - 1]);

        return result;
    }

    public static void main(String[] args) {
        합승택시요금 합승택시요금 = new 합승택시요금();
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        합승택시요금.solution(6, 4, 6, 2, fares);
    }
}
