package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {

    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++)
            map.put(players[i], i);


        for (String s : callings) {

            int idx = map.get(s);

            map.put(players[idx - 1], idx);
            map.put(s, idx - 1);

            players[idx] = players[idx - 1];
            players[idx - 1] = s;
        }

        return players;
    }

}
