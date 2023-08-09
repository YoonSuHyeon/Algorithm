package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소희와버스 {
    private static class Bus{
        private int startTime;
        private int duration;

        public Bus(int startTime,int duration){
            this.startTime = startTime;
            this.duration = duration;
        }

        public int getStartTime(){
            return startTime;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] split = input.split(" ");

        int totalBus = Integer.parseInt(split[0]);
        int arrivalTime = Integer.parseInt(split[1]);

        List<Bus> buses = new ArrayList<>();

        for(int i = 0; i < totalBus; i++){
            input = br.readLine();
            split = input.split(" ");
            Bus bus = new Bus(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
            buses.add(bus);
        }

        int busNum =0;
        int temp =Integer.MAX_VALUE;

        for(int i = 0; i< buses.size(); i++){
            Bus bus = buses.get(i);
            //해당 버스를 탈 수 있는 시간을 구한다.
            int time =bus.startTime;

            while(time < arrivalTime)
                time+= bus.duration;

            if(temp > time){
                busNum = i+1;
                temp = time;
            }
        }

        System.out.println(busNum);
    }

}
