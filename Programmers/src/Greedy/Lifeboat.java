package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Lifeboat {

    public int solution(int[] people, int limit) {
        int answer = 0;
        int i = 0;
        int j;
        Arrays.sort(people);
        for(j=people.length-1; i<=j; j--) {

            if(people[j] + people[i] > limit)
                answer ++;
            else {
                answer ++;
                i ++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] people = {50,60};
        new Lifeboat().solution(people, 100);
    }
}
