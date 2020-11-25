package week3;

public class Example4 {

    public int solution(int n, int maxhp, int[] times, int[] effects) {




        int answer = 0; // 1과 10의 count
        int curhp=0; //현재 HP
        int time=0;  //
        int hpEvent=0;//  누적합
        int timesIdx=0;// 다음약의 인덱스
        int maxOrZeroTime; // 최대나 최소 시간


        //times[0] 까지는 빠르게 계산
        time=times[0];
        answer=times[0]+1;
        hpEvent += effects[timesIdx];
        timesIdx++;

        for (int i = 1; i < n; i++) {
            if(hpEvent>0){
                maxOrZeroTime= Math.floorDiv(maxhp,hpEvent);
            }else{
                maxOrZeroTime=Math.floorDiv(curhp,Math.abs(hpEvent))-1;
            }
        }





        for (int i = 1; i < n; i++) {

        }



        while(time<times[n-1]+1){
            if(curhp+hpEvent<0){
                curhp =0;
            }else if(curhp+hpEvent>maxhp){
                curhp =maxhp;
            }else{
                curhp+=hpEvent;
            }
            //count 계산
            if(curhp==0) answer++;
            if(curhp==maxhp) answer++;

            //약을먹는 시간인지 검사
            if(times[timesIdx]==time){
                hpEvent += effects[timesIdx];
                timesIdx++;
            }
            System.out.println("time:" + time+"curhp" +curhp+ "hpevent" + hpEvent);
            time++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Example4 example4 = new Example4();

        int[] times = {1, 5, 7, 10, 11};
        int[] effects = {4, -6, -1, 4, 1};
        example4.solution(5,10, times, effects);
    }
}
