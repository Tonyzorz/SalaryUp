import java.util.*;

class Solution {
    /*
        1. 소문자로 변환
        2. p,y개수 세서 확인
    */
    boolean solution(String s) {
        String str = s.toLowerCase();
        int p = 0, y = 0;
        p= (int) str.chars().filter(c->c=='p').count();
        y= (int) str.chars().filter(c->c=='y').count();


        return p == y ? true : false;
    }
}
