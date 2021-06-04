package programmers.level1.가운데글자가져오기;

import java.util.*;

public class Solution_taewon {

	/*
	 * 가운데 글자 가져오기
문제 설명
단어 s의 가운데 글자를 반환하는 함수,
 solution을 만들어 보세요. 
 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.
입출력 예
s	return
"abcde"	"c"
"qwer"	"we"
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public String solution(String s) {
		System.out.println(s.length());
        if(s.length() % 2 == 0) {
        	return s.substring(s.length()/2 - 1, s.length()/2 + 1);
        } 
        return Character.toString(s.charAt(s.length()/2));
    }
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		String s = "qwerdsfadsfdsfasddsa";
		System.out.println(solution.solution(s));
	}
}
