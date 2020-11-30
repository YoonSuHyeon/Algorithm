package KaKao;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximizeFormula {
    public long solution(String expression) {
        long answer = 0;
       //  모든 경우의 수가 6개 의 우선순위
        String [][]allPriority={{"+","-","*"},
                {"+","*","-"},
                {"-","+","*"},
                {"-","*","+"},
                {"*","+","-"},
                {"*","-","+"}};

        List<String> operator = Arrays.stream(expression.split("")).filter(i -> i.equals("*") || i.equals("+") || i.equals("-")).collect(Collectors.toList());
        operator.forEach(it-> System.out.println("it = " + it));
        System.out.println(" dd");

        List<String>oprand =new ArrayList<String>();
        String temp = "";
        for (int i = 0; i < expression.length(); i++) {
            if(operator.contains(String.valueOf(expression.charAt(i)))){
               oprand.add(temp);
               temp="";
            }else{
                temp+=String.valueOf(expression.charAt(i));
            }
        }
        oprand.add(temp);
        oprand.forEach(it-> System.out.println("it = " + it));

        //우선순위별로 계산
        for (int i = 0; i < allPriority.length; i++) {
             Long result= Math.abs(sumOperator(allPriority[i], oprand,operator));
             if(result>answer){
                 answer = result;
             }
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    private Long sumOperator(String[] priority, List<String> toperand, List<String> toperator) {
        long result =0;
        List<String> operand=new ArrayList<String>(toperand);
        List<String> operator=new ArrayList<String>(toperator);
        Collections.copy(operand,toperand);
        Collections.copy(operator,toperator);
            for (int i = 0; i < 3; i++) {
                if(operator.contains(priority[i])) {
                    for (int j = 0; j < operator.size(); j++) {
                        long temp=0;
                        if(operator.get(j).equals(priority[i])){
                            if(priority[i].equals("+")){
                                temp=Long.parseLong(operand.get(j)) + Long.parseLong(operand.get(j+1));
                                operand.remove(j);
                                operand.remove(j);
                                operand.add(j,String.valueOf(temp));
                                operator.remove(j);
                            }else if (priority[i].equals("-")){
                                temp=Long.parseLong(operand.get(j)) - Long.parseLong(operand.get(j+1));
                                operand.remove(j);
                                operand.remove(j);
                                operand.add(j,String.valueOf(temp));
                                operator.remove(j);
                            }else{
                                temp+=Long.parseLong(operand.get(j)) * Long.parseLong(operand.get(j+1));
                                operand.remove(j);
                                operand.remove(j);
                                operand.add(j,String.valueOf(temp));
                                operator.remove(j);
                            }
                            j--;
                        }
                    }
                }
            }
            return Long.parseLong(operand.get(0));


    }


    public static void main(String[] args) {
        new MaximizeFormula().solution("100-200*300-500+20");
    }
}
