import java.util.*;

class Solution {
    /*
        1. index 기준으로 정렬
        2. index에 같은 문자이면 전체 문자로 정렬
    */
    public String[] solution(String[] strings, int n) {
        List<String> list = new ArrayList<>();

        for (String s : strings)
            list.add(s);

        Collections.sort(list, (a, b) -> {
            if (a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            }
            return (a.charAt(n) - '0') - (b.charAt(n) - '0');
        });

        String[] answer = new String[strings.length];

        for (int i = 0; i < strings.length; i++)
            answer[i] = list.get(i);

        return answer;
    }
}
