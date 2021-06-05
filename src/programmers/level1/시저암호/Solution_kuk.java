import java.util.*;

class Solution {
    /*
        1. 공백일 경우 무시하고 다음거
        2. n을 더해서 소문자나 대문자 z가 넘을경우 26를 빼준다
        3. 안넘을 경우 그냥 더한다
    */
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == ' ') {
                answer.append(" ");
                continue;
            }

            if ((temp >= 65 && temp <= 90 && temp + n > 90) ||
                    (temp >= 97 && temp <= 122 && temp + n > 122))
                answer.append((char) ((temp + n) - 26));
            else
                answer.append((char) (temp + n));
        }
        return answer.toString();
    }
}
