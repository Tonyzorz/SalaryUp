import java.util.*;

class Solution {
    /*
        1. s길이 4,6확인
        2. 숫자가 아닌게 있는지 확인
        3. 다 아니면 false
    */
    public boolean solution(String s) {
        if ((s.length() == 4 || s.length() == 6) && s.matches("^[0-9]+$"))
            return true;

        return false;
    }
}
