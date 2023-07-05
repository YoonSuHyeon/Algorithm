package programmers.lv3;

import java.util.Arrays;

public class 코딩테스트공부 {

    /**
     * (alp,cop) -> problems의 최대 알고력, 최대 코딩력으로 갈수 있는 최소 시간을 구한다.
     * 2차원 배열을 사용해서 알고력,코딩력에 까지 가는 최소 시간을 구한다.
     *
     * @param alp
     * @param cop
     * @param problems
     * @return
     */
    public int solution(int alp, int cop, int[][] problems) {

        //problems의 최대 알고력, 최대 코딩력을 구한다.
        int maxAlp = alp;
        int maxCop = cop;
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }


        int[][] array = new int[maxAlp + 1][maxCop + 1];
        for (int[] a : array)
            Arrays.fill(a, Integer.MAX_VALUE);

        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {

                //알고력과 코딩력을 올린경우
                array[i][j] = Math.min(array[i][j], i - alp + j - cop);

                //문제를 풀수 있는경우 계산하기위함
                for (int[] problem : problems) {

                    //문제를 풀수 없는경우
                    if (problem[0] > i || problem[1] > j)
                        continue;


                    array[Math.min(maxAlp, i + problem[2])][Math.min(maxCop, j + problem[3])] =
                            Math.min(array[Math.min(maxAlp, i + problem[2])][Math.min(maxCop, j + problem[3])],
                                    array[i][j] + problem[4]);
                }
            }
        }

        return array[maxAlp][maxCop];
    }

    public static void main(String[] args) {
//        int[][] problems = {{10, 15, 2, 1, 2}, {20, 15, 3, 3, 4}};
        int[][] problems = {{0, 2, 1, 1, 100}};
        코딩테스트공부 코딩테스트공부 = new 코딩테스트공부();
        int solution = 코딩테스트공부.solution(1, 1, problems);
        System.out.println("solution = " + solution);
    }

}
