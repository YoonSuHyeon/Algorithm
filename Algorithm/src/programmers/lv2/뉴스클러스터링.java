package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 뉴스클러스터링 {


    public int solution(String str1, String str2) {
        //두글자씩 끊어서 중복 집합 생성
        //영문자가 아닌 경우는 해당 문자열을 저장 하지 않고, 문자열은 대문자로 변경해서 저장한다.
        List<String> set1 = makeSet(str1);
        List<String> set2 = makeSet(str2);

        int totalSetSize = set1.size() + set2.size();
        // 교집합 계산
        double intersectionSize = 0;
        for (String s : set1) {

            if (!set2.contains(s))
                continue;

            set2.remove(s);
            intersectionSize++;
        }
        // 합집합 계산 (전체 - 교집합 개수)
        double unionSize = totalSetSize - intersectionSize;
        return unionSize <= 0 ? 65536 : (int) ((intersectionSize / unionSize) * 65536);
    }

    /**
     * 두 글자씩 끊어서 다중 집합의 원소를 만든다.
     *
     * @param str
     * @return
     */
    private List<String> makeSet(String str) {
        //대문자 변환
        str = str.toUpperCase();

        List<String> temp = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {

            char a = str.charAt(i);
            char b = str.charAt(i + 1);
            //두가지 전부가 영문자로 된 글자인지 확인
            if (Character.isLetter(a) && Character.isLetter(b))
                temp.add(Character.toString(a) + b);

        }
        return temp;
    }


    public static void main(String[] args) {
        뉴스클러스터링 뉴스클러스터링 = new 뉴스클러스터링();

        System.out.println("뉴스클러스터링 = " + 뉴스클러스터링.solution("FRANCE", "french"));

    }
}
