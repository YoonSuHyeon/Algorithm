package week3;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Downhill {

    static  int x,y;
    static int[][]temp;
    public int find(int[][] temp){
        return 0;
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            String[] input= br.readLine().split(" ");
            x=Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
           temp = new int[x][y];
            for(int i = 0 ;i <x;i++){
                String[]tempI=br.readLine().split(" ");
                for(int j =0;j<y;j++){
                    temp[i][j] = Integer.parseInt(tempI[j]);
                }
            }
            new Downhill().find(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
