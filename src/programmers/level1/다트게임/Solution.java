import java.util.*;

class Solution {
    /*
        1. 거꾸로 찾아간다
        2. S,D,T는 map으로 판별
        3. *개수 count, #은 boolean으로 판별
    */
    public int solution(String dartResult) {
        int answer = 0, star = 0, num = 0, count = 0;
        boolean option = false;
        String sdt = "";
        HashMap<String, Integer> map = new HashMap<>();
        map.put("S", 1);
        map.put("D", 2);
        map.put("T", 3);

        for (int i = dartResult.length() - 1; i >= 0; i--) {
            char dart = dartResult.charAt(i);
            if (dart == '*')
                star++;
            else if (dart == '#')
                option = true;
            else if (dart == 'S' || dart == 'D' || dart == 'T')
                sdt = Character.toString(dart);
            else {
                // 숫자 판별
                if (i != 0 && dartResult.charAt(i - 1) >= 48 && dartResult.charAt(i - 1) <= 57) {
                        num = Integer.parseInt(Character.toString(dartResult.charAt(i - 1)) + Character.toString(dart));
                        i--;
                } else
                    num = dart - 48;

                num = (int) Math.pow(num, map.get(sdt)); // S,D,T 판별

                if (option) // # 판별
                    num *= -1;

                num *= (int) Math.pow(2, star);

                if (star != 0) // * 2번하는지 판별
                    count++;

                if (count==2) { //star 2번했을 경우 1감소
                    star--;
                    count = 0;
                }
                answer += num;

                option = false; // #초기화
            }
        }

        return answer;
    }
}
