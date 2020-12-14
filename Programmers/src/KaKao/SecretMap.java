package KaKao;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = arr1[i] | arr2[i];
            String s=Integer.toBinaryString(arr1[i]);
            if(s.length()<n){
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < n-s.length(); j++) {
                    temp.append(" ");
                }
                s = temp + s;
            }


            s = s.replace("1", "#");
            s = s.replace("0", " ");

            System.out.println("s = " + s);
            answer[i] = s;
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        new SecretMap().solution(5, arr1, arr2);
    }
}
