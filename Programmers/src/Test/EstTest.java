package Test;

public class EstTest {

    public int[] solution(String[] card_numbers) {
        int[] answer = new int[card_numbers.length];

        for (int i = 0; i < card_numbers.length; i++) {
            if(checkedOne(card_numbers[i])){//첫번째 카드형식
                if(checkedNumOne(card_numbers[i])){
                    answer[i]=1;
                }
            }else if(checkedTwo(card_numbers[i])){//두번째 카드형식
                if(checkedNumTwo(card_numbers[i])){
                    answer[i]=1;
                }
            }
        }

        return answer;
    }

    private boolean checkedNumTwo(String card_number) {
        int tempA=0;// 짝수
        int tempB=0;// 홀수
        for (int i = 0; i < card_number.length(); i++) {
            int parseInt = Integer.parseInt(String.valueOf(card_number.charAt(i)));
            if(i%2==0){//짝수
                int temp = parseInt *2;
                if(temp>9){
                    temp=temp/10 +temp%10;
                }
                tempA+=temp;
            }else{
                tempB += parseInt;
            }
        }
        return (tempA + tempB) % 10 == 0;
    }

    private boolean checkedTwo(String card_number) {
        return card_number.length() == 16 && !card_number.contains("-");
    }

    private boolean checkedNumOne(String card_number) {
        int tempA=0;// 짝수
        int tempB=0;// 홀수
        int i = 0;
        int index =0;
        while(index<card_number.length()){
            if (card_number.charAt(index) != '-') {
                int parseInt = Integer.parseInt(String.valueOf(card_number.charAt(index)));
                if (i % 2 == 0) {//짝수
                    int temp = parseInt * 2;
                    if (temp > 9) {
                        temp = temp / 10 + temp % 10;
                    }
                    tempA += temp;
                } else {
                    tempB += parseInt;
                }
                i++;
            }
            index++;
        }
        return (tempA + tempB) % 10 == 0;

    }

    private boolean checkedOne(String card_number) {
        return card_number.length() == 19 && card_number.charAt(4) == '-'
                && card_number.charAt(9) == '-'
                && card_number.charAt(14) == '-';

    }


    public static void main(String[] args) {
        String[] temp ={"3285-3764-9934-2453", "3285376499342453", "3285-3764-99342453", "328537649934245", "3285376499342459", "3285-3764-9934-2452"};
        new EstTest().solution(temp);
    }
}
