package programmers.lv3;

public class 표현가능한이진트리 {
    /**
     * 중위 순회,
     *
     * @param numbers
     * @return
     */
    public int[] solution(long[] numbers) {

        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            //이진수로 변환한 후 String으로 형변환
            StringBuilder binaryString = new StringBuilder(Long.toBinaryString(numbers[i]));

            //길이가 2^n -1 이 아닌경우 부족한 만큼 앞에 0을 붙힌다.
            int addZeroCnt = calculateTargetLength(binaryString.length()) - binaryString.length();

            for (int j = 0; j < addZeroCnt; j++)
                binaryString.insert(0, "0");

            //가운데가 전부 1인지 확인
            if (checkTree(binaryString.toString()))
                answer[i] = 1;

        }
        return answer;
    }

    /**
     * 완전 이진 트리인 경우
     *
     * @param length
     * @return
     */
    public int calculateTargetLength(int length) {
        // length길이에 맞춰서 완전 이진트리인 경우 높이를 구한다.
        int height = (int) Math.ceil(Math.log(length + 1) / Math.log(2));

        //완전 이진트리인경우 원소의 개수 반환
        return (int) Math.pow(2, height) - 1;
    }

    private boolean checkTree(String binaryString) {
        int length = binaryString.length();

        if (length == 1)
            return true;

        // 남은 것들이 전부다 0 인경우
        if (binaryString.chars().allMatch(b -> b == '0'))
            return true;

        // 가운데가 1이 아닌경우
        if (binaryString.charAt(length / 2) != '1')
            return false;

        return checkTree(binaryString.substring(0, length / 2)) && checkTree(binaryString.substring(Math.min(length / 2 + 1, length), length));
    }

    public static void main(String[] args) {

        long[] numbers = {10, 11};
        표현가능한이진트리 표현가능한이진트리 = new 표현가능한이진트리();
        int[] solution = 표현가능한이진트리.solution(numbers);

    }
}
