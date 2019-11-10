package Hash;

public class Hash2 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            for(int i =0;i<phone_book.length;i++){
                for(int j= i+1;j<phone_book.length;j++){
                    int ilen = phone_book[i].length();
                    int jlen = phone_book[j].length();
                    if(ilen<=jlen) {
                        String temp = phone_book[j].substring(0, ilen);
                        if (temp.equals(phone_book[i])) {
                            answer = false;
                            return answer;
                        }
                    }else{
                        String temp = phone_book[i].substring(0, jlen);
                        if (temp.equals(phone_book[j])) {
                            answer = false;
                            return answer;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
