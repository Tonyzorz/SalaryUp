package programmers.level1.시저암호;

import java.util.*;

public class Solution_taewon {

	/*
	 * 시저 암호
문제 설명
어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

제한 조건
공백은 아무리 밀어도 공백입니다.
s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
s의 길이는 8000이하입니다.
n은 1 이상, 25이하인 자연수입니다.
입출력 예
s	n	result
"AB"	1	"BC"
"z"	1	"a"
"a B z"	4	"e F d"
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	//A-Z 65 ~ 90, a-z 97 ~ 122
	public String solution(String s, int n) {
        //String answer = "";
        StringBuffer answer = new StringBuffer();
        
        for(int i = 0; i < s.length(); i++) {
        	
        	int ascii = s.charAt(i);
        	
        	if(ascii >= 65 && ascii <= 90) {
        		ascii += n;
        		if(ascii > 90) ascii -= 26;
        	} else if (ascii >= 97 && ascii <= 122) {
        		ascii += n;
        		if(ascii > 122) ascii -= 26;
        	}
        	
        	answer.append(Character.toChars(ascii));
        }
        return answer.toString();
    }
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		String s = " aBZ";
		int n = 20;
		System.out.println(solution.solution(s, n));
	}
}
