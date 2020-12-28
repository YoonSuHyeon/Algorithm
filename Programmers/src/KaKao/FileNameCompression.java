package KaKao;

import java.util.Arrays;
import java.util.Comparator;

public class FileNameCompression {


    public String[] solution(String[] files) {
        Comparator<String> FileComparator = new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {

                String sTemp = s.split("[0-9]")[0];
                String t1Temp = t1.split("[0-9]")[0];
                //Head 비교
                int compare = sTemp.toLowerCase().compareTo(t1Temp.toLowerCase());

                //같을경우
                if(compare==0){
                    int compareS=lastFindNum(s.substring(sTemp.length()));
                    int compareT1 = lastFindNum(t1.substring(t1Temp.length()));
                    compare = compareS - compareT1;
                }
                //다를경우
                return compare;

            }

            private int lastFindNum(String substring) {
                int idx;
                String result = "";
                for ( idx = 0; idx < substring.length(); idx++) {
                   if(Character.isDigit(substring.charAt(idx))){
                       result += substring.charAt(idx);
                   }else{
                       break;
                   }
                }

                return Integer.parseInt(result);
            }
        };
        Arrays.sort(files, FileComparator);
        return files;
    }


    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        new FileNameCompression().solution(files);
    }
}
