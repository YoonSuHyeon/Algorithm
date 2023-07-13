package programmers.lv1;

public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            String paper = wallpaper[i];
            for (int j = 0; j < paper.length(); j++) {
                if (paper.charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);

                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }

            }
        }

        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }
}
