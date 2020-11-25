package week3;

import java.util.*;

public class Example3 {
    public int solution(int n, int[] v) {
        ArrayList<Integer> temp = new ArrayList<>();
        int leftSize=300000;
        int minDif=300000001;


        //ArrayList 로변경
        for (int i = 0; i < v.length; i++) {
            temp.add(v[i]);
        }
        //리스트를 자름
        for(int i =0 ; i< temp.size()+1;i++){
            List <Integer> left =temp.subList(0,i);
            int leftSum = left.stream().mapToInt(Integer::intValue).sum();
            List<Integer> right = temp.subList(i, temp.size());
            int rightSum = right.stream().mapToInt(Integer::intValue).sum();

            int dif = Math.abs(rightSum - leftSum);
            if(minDif>dif){
                leftSize = left.size();
                minDif = dif;
            }else if(minDif==dif){
                if(leftSize>left.size()){
                    leftSize = left.size();
                }
            }
        }


        return leftSize;


    }

    public static void main(String[] args) {
        int[] temp = {0};
        new Example3().solution(1, temp);
    }
}
