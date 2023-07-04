package programmers.lv4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.LongStream;

public class 호텔방배정 {

    /**
     * 효율성 X
     *
     * @param k
     * @param room_number
     * @return
     */
    public long[] solutionX(long k, long[] room_number) {

        Set<Long> set = new HashSet<>();

        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {

            long temp = room_number[i];
            while (!set.add(temp))
                temp++;

            answer[i] = temp;
        }

        return answer;
    }

    /**
     * 효율성 7개중 4개 통과
     *
     * @param k
     * @param room_number
     * @return
     */
    public long[] solutionX2(long k, long[] room_number) {

        // 1 ~ k까지 treeSet으로 만든다.
        TreeSet<Long> set = new TreeSet<>();
        LongStream.rangeClosed(1, k).forEach(set::add);

        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            long temp = set.subSet(room_number[i], k + 1).first();
            answer[i] = temp;

            set.remove(temp);
        }

        return answer;
    }

    /**
     * 효율성 X
     *
     * @param k
     * @param room_number
     * @return
     */
    public long[] solutionX3(long k, long[] room_number) {

        TreeSet<Long> treeSet = new TreeSet<>();
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            long room = room_number[i];

            while (treeSet.contains(room))
                room++;


            answer[i] = room;
            treeSet.add(room);
        }

        return answer;
    }

    public long[] solution(long k, long[] room_number) {
        HashMap<Long, Long> roomMap = new HashMap<>();

        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            long room = room_number[i];

            long nextRoom = findNextAvailableRoom(roomMap, room);
            answer[i] = nextRoom;

        }

        return answer;
    }

    private long findNextAvailableRoom(HashMap<Long, Long> roomMap, long room) {
        if (!roomMap.containsKey(room)) {
            roomMap.put(room, room + 1);
            return room;
        }


        long nextRoom = findNextAvailableRoom(roomMap, roomMap.get(room));
        roomMap.put(room, nextRoom + 1);

        return nextRoom;
    }

    public static void main(String[] args) {
        호텔방배정 호텔방배정 = new 호텔방배정();
        long[] room = {1, 1, 5, 1, 1};
        호텔방배정.solution(6, room);
    }

}
