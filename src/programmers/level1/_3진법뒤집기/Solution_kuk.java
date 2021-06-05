import java.util.*;

class Solution {
    /*
        1. 3진수 변환하고 뒤집기
        2. 10진수 변환
    */
    public int solution(int n) {
        StringBuilder three = new StringBuilder(Integer.toString(n, 3)).reverse();
        
        return Integer.parseInt(three.toString(), 10);
    }
}
