package Level1;

public class PYCount {
    boolean solution(String s) {

        int pCount=0,yCount=0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='p'|| s.charAt(i)=='P'){
                pCount++;
            }else if(s.charAt(i)=='y' || s.charAt(i)=='Y'){
                yCount++;
            }
        }

        if(pCount==yCount){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PYCount pyCount = new PYCount();
        pyCount.solution("pPoooyY");
    }
}
