package programmers.level2.JadenCase문자열만들기;

import java.util.*;

public class Solution_taewon_jadenCase {

	/*
	 * 
	 */
	public Solution_taewon_jadenCase() {
		// TODO Auto-generated constructor stub
	}
	
	public String solution(String s) {
        s = s.toLowerCase();
        StringBuffer answer = new StringBuffer(s);
        
        if (s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
        	char upper = (char) (s.charAt(0) - 32);
			answer.replace(0, 1, String.valueOf(upper));
        }
        
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == ' ') {
        		
        		while (s.charAt(i) == ' ' && i < s.length() - 1) {
        			i++;
        		}
        		char temp = s.charAt(i);
        		if (temp >= 'a' && temp <= 'z') {
        			char upper = (char) (temp - 32);
        			answer.replace(i, i + 1, String.valueOf(upper));
        		}
        	}
        	
        }
        
        return answer.toString();
    }
	
	public static void main(String[] args) {
		Solution_taewon_jadenCase solution = new Solution_taewon_jadenCase();
		String s = "sadf  ";
		System.out.println(solution.solution(s));
	}
}
