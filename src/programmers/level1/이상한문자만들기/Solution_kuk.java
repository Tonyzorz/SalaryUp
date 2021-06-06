import java.util.*;

class Solution {
    /*
        1. 문자인지 판단
        2. 문자이면 짝수 일때 대문자, 홀수 일때 소문자
        3. 문자가 아니라 공백이면 패스
    */
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                if (index % 2 == 0)
                    answer.append(Character.toString(s.charAt(i)).toUpperCase());
                else
                    answer.append(Character.toString(s.charAt(i)).toLowerCase());
                index++;
            } else {
                index = 0;
                answer.append(" ");
            }
        }
        return answer.toString();
    }
}
