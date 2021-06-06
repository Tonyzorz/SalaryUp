import java.util.*;

class Solution {
    /*
        1. 짝수면 가운데거랑 앞에거 return
        2. 홀수면 가운데거만 return
    */
    public String solution(String s) {
        int index = s.length()/2;
        
        return s.length()%2==0?Character.toString(s.charAt(index - 1))+ s.charAt(index)
                :Character.toString(s.charAt(index));
    }
}
