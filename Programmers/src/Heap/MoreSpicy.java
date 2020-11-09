package Heap;

import java.util.*;


public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer=0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        //Collections.reverseOrder()

        for( int a : scoville){ //값을 넣어준다.
            priorityQueue.offer(a);
        }
        for(int b : priorityQueue){
            System.out.println("b = " + b);
        }
        while(priorityQueue.peek()<= K){
            if(priorityQueue.size()== 1){ //만들 수 없는경우
                return -1;
            }
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();

            int changeA = a + (b * 2);
            priorityQueue.offer(changeA);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] scovillde = {1,2,3,9,10,12};
        new MoreSpicy().solution(scovillde,7);
    }
}
