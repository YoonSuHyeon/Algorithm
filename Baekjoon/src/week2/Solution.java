package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(String[] card_numbers) {
        int[] answer = new int[card_numbers.length];
        int i = 0;
        for (String card_number :
                card_numbers) {
            int oddNum = 0;
            int evenNum = 0;
            if (String.join("", card_number.split("-")).length() == 16) { //size가 16인것
                if (card_number.length() == 16) {
                    for (int j = 0; j < card_number.length(); j++) {
                        if (j % 2 == 0) {
                            int temp = Integer.parseInt(String.valueOf(card_number.charAt(j))) * 2;
                            temp = temp / 10 + temp % 10;
                            oddNum += temp;
                        } else {
                            int temp = Integer.parseInt(String.valueOf(card_number.charAt(j)));
                            evenNum += temp;
                        }
                    }
                    if ((oddNum + evenNum) % 10 == 0) {
                        answer[i] = 1;
                    }
                } else {
                    if (card_number.charAt(4) == '-' && card_number.charAt(9) == '-' && card_number.charAt(14) == '-') {
                        card_number = String.join("", card_number.split("-"));

                        for (int j = 0; j < card_number.length(); j++) {
                            if (j % 2 == 0) {
                                int temp = Integer.parseInt(String.valueOf(card_number.charAt(j))) * 2;
                                temp = temp / 10 + temp % 10;
                                oddNum += temp;
                            } else {
                                int temp = Integer.parseInt(String.valueOf(card_number.charAt(j)));
                                evenNum += temp;
                            }
                        }
                        if ((oddNum + evenNum) % 10 == 0) {
                            answer[i] = 1;
                        }
                    }
                }
            }
            i++;
        }
        Arrays.stream(answer).forEach(it-> System.out.println("it = " + it));
        return answer;
    }

    public static void main(String[] args) {
        String[] card_numbers = {"0000-0000-0000-0000"};
        new Solution().solution(card_numbers);
    }
}
