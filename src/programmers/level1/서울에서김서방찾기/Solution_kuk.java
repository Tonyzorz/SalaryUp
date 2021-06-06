import java.util.*;

class Solution {
    /*
        1.list의 indexOf로 찾기
    */
    public String solution(String[] seoul) {
        List<String> list = new ArrayList<>();

        for (String str : seoul)
            list.add(str);
        
        return "김서방은 " + list.indexOf("Kim") + "에 있다";
    }
}
