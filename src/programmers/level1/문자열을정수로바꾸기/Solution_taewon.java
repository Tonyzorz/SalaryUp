package programmers.level1.문자열을정수로바꾸기;

import java.util.*;

public class Solution_taewon {

	/*
	 * 문자열을 정수로 바꾸기
문제 설명
문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.

제한 조건
s의 길이는 1 이상 5이하입니다.
s의 맨앞에는 부호(+, -)가 올 수 있습니다.
s는 부호와 숫자로만 이루어져있습니다.
s는 "0"으로 시작하지 않습니다.
입출력 예
예를들어 str이 "1234"이면 1234를 반환하고, "-1234"이면 -1234를 반환하면 됩니다.
str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없습니다.
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(String s) {
        int answer = 0;

        if(s.charAt(0) == '+' || s.charAt(0) == '-') {
        	answer = Integer.parseInt(s.substring(1, s.length()));
        	answer = s.charAt(0) == '+' ? answer : answer * -1;

        } else {
        	answer = Integer.parseInt(s.substring(0, s.length()));
        }
        
        
        return answer;
        //return Integer.parseInt(s);
	}
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		String s = "-1234";
		System.out.println(solution.solution(s));
	}
}
