import java.util.*;

class Solution {
    /*
        1. n을 1자리씩 잘라서 string 배열에 널는다
        2. string 배열 1개씩 int로 변환해 더한다
    */
    public int solution(int n) {
        int answer = 0;
        String[] num = Integer.toString(n).split("");

        for (int i = 0; i < num.length; i++)
            answer += Integer.parseInt(num[i]);

        return answer;
    }
}
