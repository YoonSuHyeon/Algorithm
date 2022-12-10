package programmers.lv2;

import java.util.PriorityQueue;

/**
 * 준호는 요즘 디펜스 게임에 푹 빠져 있습니다. 디펜스 게임은 준호가 보유한 병사 n명으로 연속되는 적의 공격을 순서대로 막는 게임입니다. 디펜스 게임은 다음과 같은 규칙으로 진행됩니다.
 * <p>
 * 준호는 처음에 병사 n명을 가지고 있습니다.
 * 매 라운드마다 enemy[i]마리의 적이 등장합니다.
 * 남은 병사 중 enemy[i]명 만큼 소모하여 enemy[i]마리의 적을 막을 수 있습니다.
 * 예를 들어 남은 병사가 7명이고, 적의 수가 2마리인 경우, 현재 라운드를 막으면 7 - 2 = 5명의 병사가 남습니다.
 * 남은 병사의 수보다 현재 라운드의 적의 수가 더 많으면 게임이 종료됩니다.
 * 게임에는 무적권이라는 스킬이 있으며, 무적권을 사용하면 병사의 소모없이 한 라운드의 공격을 막을 수 있습니다.
 * 무적권은 최대 k번 사용할 수 있습니다.
 * 준호는 무적권을 적절한 시기에 사용하여 최대한 많은 라운드를 진행하고 싶습니다.
 * <p>
 * 준호가 처음 가지고 있는 병사의 수 n, 사용 가능한 무적권의 횟수 k, 매 라운드마다 공격해오는 적의 수가 순서대로 담긴 정수 배열 enemy가 매개변수로 주어집니다. 준호가 몇 라운드까지 막을 수 있는지 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 내가 최소 막을 수 있는 라운드는 k이다. 무적권을 사용하는건 내가 처리할 수 없는 적인경우에 쓰는게 가장 좋다.
 * 따라서, enemy는 index = k 부터 시작하고 우선순위 큐를 사용해서 무적권 사용에 대한 정보를 저장한다.
 * 다음에 진행할 라운드의 적의 수 a, 우선순위큐 가장 낮은 우선순위의 값 b
 * a 와 b 를 비교해서  a가 큰 경우에는 우선순위 큐에 값을 넣고 b의 값을 내 병사로 방어한다.
 */
public class 디펜스게임 {
    public static int solution(int n, int k, int[] enemy) {
        if (k >= enemy.length)
            return enemy.length;


        // 무적권 사용 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            pq.offer(enemy[i]);


        int result = k;

        for (int i = k; i < enemy.length; i++) {
            int minPriorityValue = pq.peek();

            if (enemy[i] > minPriorityValue) {
                pq.poll();
                pq.offer(enemy[i]);

                if (minPriorityValue > n)
                    break;
                else
                    n -= minPriorityValue;

            } else {
                if (enemy[i] > n) {
                    break;
                } else {
                    n -= enemy[i];
                }
            }

            result++;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        int result = 디펜스게임.solution(7, 3, enemy);
        System.out.println("result = " + result);

    }
}

