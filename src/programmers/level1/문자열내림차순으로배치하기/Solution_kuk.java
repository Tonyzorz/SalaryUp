import java.util.*;

class Solution {
    /*
        1. 소문자가 대문자보다 먼저
        2. 내림차순으로
    */
    public String solution(String s) {
        String answer = "";
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++)
            list.add(s.charAt(i));

        Collections.sort(list, (a, b) -> {
            if ((Character.isUpperCase(a) && Character.isLowerCase(b)))
                return 1;
            if (Character.isLowerCase(a) && Character.isUpperCase(b))
                return -1;
            return b - a;
        });

        for (char c : list)
            answer += c;
        return answer;
    }
}
