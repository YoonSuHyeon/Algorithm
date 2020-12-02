package week3;

import java.util.*;

public class Test2 {
    public String[] solution(String[] orders) {

        HashMap<String, HashSet<String>> foodMap = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            String[] s = orders[i].split(" ");
            if (foodMap.containsKey(s[0])) {
                HashSet<String> set = foodMap.get(s[0]);
                for (int j = 1; j < s.length; j++) {
                    set.add(s[j]);
                }
                foodMap.put(s[0], set);
            } else {
                HashSet<String> set = new HashSet<>();
                for (int j = 1; j < s.length; j++) {
                    set.add(s[j]);
                }
                foodMap.put(s[0], set);
            }
        }

        System.out.println("foodMap = " + foodMap);
        ArrayList<String> maxName = new ArrayList();
        Optional<Integer> max = foodMap.values().stream().map(HashSet::size).max(Integer::compareTo);

        for (String n : foodMap.keySet()
        ) {
            if( foodMap.get(n).size()==max.get()){
                maxName.add(n);
            }

        }

        Collections.sort(maxName);

        return maxName.toArray(new String[maxName.size()]);
    }



    public static void main(String[] args) {
        String[] temp={"alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta", "bob noodle sandwich pasta", "bob steak noodle"};

        new Test2().solution(temp);
    }


}
