package baekjoon;

import java.util.*;
import java.util.stream.Collectors;

public class 트럭 {

    /**
     * 모든 트럭들이 다리를 건너는 최단 시간 반환<br>
     * 조건 : 다리위에는 w대의 트럭만 동시에 올라갈 수 있다.
     * 1초에 한개씩 이동함.
     * 동시에 올라가는 경우 다리 최대 하중보다 작거나 같아야함.
     *
     * @param n
     * @param w
     * @param L
     * @param truckWeights
     * @return
     */
    private static int solution(int n, int w, int L, List<Integer> truckWeights) {
        // 첫번쨰 트럭이 나가기 위해서는 기본적으로 w만큼의 시간이 필요하기 떄문에 초기화
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++)
            bridge.add(0);

        int answer = 0;
        int totalWeight = 0;
        int currIdx = 0;

        while (!bridge.isEmpty()) {
            totalWeight -= bridge.poll();
            answer++;

            if (currIdx < n) {
                int truckWeight = truckWeights.get(currIdx);
                if (truckWeight + totalWeight <= L) {
                    bridge.add(truckWeight);
                    totalWeight += truckWeight;
                    currIdx++;
                } else {
                    bridge.add(0);
                }
            }

        }
        return answer;
    }


    public static void main(String[] args) {

        // 입력
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        //트럭의 개수
        int n = Integer.parseInt(input[0]);
        // 다리길이
        int w = Integer.parseInt(input[1]);
        // 다리최대 하중
        int L = Integer.parseInt(input[2]);

        // 트럭
        List<Integer> truckWeights = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        // 모든 트럭들이 다리를 건너는 최단시간 구하기
        int solution = solution(n, w, L, truckWeights);
        System.out.println(solution);
    }
}
