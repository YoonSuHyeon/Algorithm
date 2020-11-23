package DFS_BFS;

import java.util.ArrayList;
import java.util.HashSet;

public class Network {
   /* public int solution(int n, int[][] computers) {
        int answer = 0;
        ArrayList<HashSet<Integer>> group = new ArrayList();

        //첫번째 그룹 생성
        HashSet<Integer> fistSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (computers[0][i] == 1) {
                fistSet.add(i);
            }
        }
        group.add(fistSet);

        for (int i = 1; i < n; i++) {
            int status = -1;
            status=inGroup(i,group,computers);
            //이미 그룹안에 있는지 확인
            //있을시 전부다 그룹에 넣어주고 아닐시 새로운 그룹을 만들어서 넣는다.
            if (status == -1) {//없을경우
                HashSet<Integer> tempSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (computers[i][k] == 1) {
                        tempSet.add(k);
                    }
                }
                group.add(tempSet);
            } else {//있을경우
                HashSet<Integer> tempSet = group.get(status);
                for (int k = 0; k < n; k++) {
                    if (computers[i][k] == 1) {
                        tempSet.add(k);
                    }
                }
                group.set(status,tempSet);
            }
        }
        System.out.println("group = " + group);
        System.out.println("group = " + group.size());

        return group.size();
    }

    private int inGroup(int i, ArrayList<HashSet<Integer>> group, int[][] computers) {
        ArrayList<Integer> temp = new ArrayList();
        for(int j =0;j<computers.length;j++){
            if(computers[i][j]==1){
                temp.add(j);
            }
        }
        for (int j = 0; j < group.size(); j++) {
            for(int l = 0;l <temp.size();l++){
                if (group.get(j).contains(temp.get(l))) {
                    return j;
                }
            }

        }
        return -1;



    }
*/
   public int solution(int n, int[][] computers) {
       int answer = 0;
       boolean[] visited = new boolean[computers[0].length];
       for(int i = 0; i < n; i++) {
           if(!visited[i]) {
               dfs(computers, visited,i);
               answer++;
           }
       }
       return answer;
   }

    public void dfs(int[][] computer, boolean[] visited, int n) {
        visited[n] = true;
        for(int i = 0; i < computer[0].length; i++) {
            if(!visited[i] && computer[n][i] == 1) {
                dfs(computer, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        Network network = new Network();
        int[][] computers = {{1,1,1,1}, {1,1,1,0}, {1,1,1,0}, {1,0,0,1}};
        network.solution(4, computers);
    }
}
