package programmers.level1.문자열다루기기본;

import java.util.*;

public class Solution_taewon {

	/*
	 * 문자열 다루기 기본
문제 설명
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
입출력 예
s	return
"a234"	false
"1234"	true
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	//[0 – 9] ranges from [48 – 57]
	public boolean solution(String s) {
        boolean answer = true;
        int charAscii = 0;
        if(s.length() != 4 && s.length() != 6) return false;
        for(int i = 0; i < s.length(); i++) {
        	charAscii = (int)s.charAt(i);
        	if(charAscii > 57 || charAscii < 48) return false;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		String s = "134";
		System.out.println(solution.solution(s));
	}
}
