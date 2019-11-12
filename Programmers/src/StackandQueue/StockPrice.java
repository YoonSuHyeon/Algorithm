package StackandQueue;

import java.util.ArrayList;

public class StockPrice {
    public static int[] solution(int[] prices) {
        int[] answer = {};
        ArrayList<Integer> tempstack =new ArrayList<>();
        ArrayList<Integer> temp =new ArrayList<>();
        int count;
        for(int i = 0 ;i <prices.length;i++){
            count=0;
            for(int j=i+1 ; j<prices.length;j++){

                if(prices[j]>=prices[j-1]){
                    if(prices[i]<=prices[j]){
                        count ++;
                    }
                }else{
                    if(prices[i]<=prices[j]){
                        count ++;
                    }
                }
            }
             temp.add(count);
        }

        for(int i =0 ;i<prices.length;i++){
            prices[i]=temp.get(i);
        }
        return prices;
        /*for(int i =0 ; i<temp.size();i++){
            System.out.println(temp.get(i));
        }
      /*  for(int i = prices.length ;i>0;i--){
            if(temp.size() ==0){
                temp.add(prices[i-1]);
                tempstack.add(0);
            }else{
                int count =0;

                for(int j = temp.size();j>0;j--){
                    if(temp.get(j-1)>=prices[i-1]) count++;

                }
                temp.add(prices[i-1]);
                tempstack.add(count);
            }
        }
        for(int i =0;i<temp.size();i++){
            System.out.println(tempstack.get(i));
         }
        for(int i=0;i<prices.length;i++){

            prices[i]=tempstack.remove(tempstack.size()-1);
        }
    */





    }
    public static void main(String args[]){
        int i[] = {1,2,3,2,3};
        int b[]=StockPrice.solution(i);
        /*for(int ij =0 ;ij<b.length;ij++){
            System.out.println(b[ij]);
        }*/
    }
}
