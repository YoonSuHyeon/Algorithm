package programmers.lv2;

import java.util.*;

public class 방문길이 {


    public int solution(String dirs) {

        int beforeX, beforeY;
        int currentX = 0;
        int currentY = 0;

        List<Pos> set = new ArrayList<>();
        for (int i = 0; i < dirs.length(); i++) {

            beforeX = currentX;
            beforeY = currentY;

            switch (dirs.charAt(i)) {
                case 'U' -> currentX--;
                case 'D' -> currentX++;
                case 'L' -> currentY--;
                case 'R' -> currentY++;
            }

            // 범위 -5 ~ 5
            if (currentX < -5 || currentX > 5) {
                currentX = beforeX;
                continue;
            }
            if (currentY < -5 || currentY > 5) {
                currentY = beforeY;
                continue;
            }

            Pos pos = new Pos(beforeX, beforeY, currentX, currentY);

            if (!set.contains(pos))
                set.add(pos);

        }

        return set.size();
    }

    private static class Pos {
        private int bx;
        private int by;

        private int x;
        private int y;

        public Pos(int bx, int by, int x, int y) {
            this.bx = bx;
            this.by = by;

            this.x = x;
            this.y = y;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return (bx == pos.bx && by == pos.by && x == pos.x && y == pos.y) || (bx == pos.x && by == pos.y && x == pos.bx && y == pos.by);
        }

    }

    public static void main(String[] args) {
        방문길이 방문길이 = new 방문길이();
        방문길이.solution("LULLLLLLU");
    }
}
