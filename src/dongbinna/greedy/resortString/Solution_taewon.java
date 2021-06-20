package dongbinna.greedy.resortString;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public String solution(String s) {
		StringBuffer answer = new StringBuffer();;
		ArrayList<Character> letters = new ArrayList<Character>();
		int num = 0;

		for(int i = 0; i < s.length(); i++) {
			char place = s.charAt(i);
			if(place - 'A' >= 0) letters.add(place);
			else num += place - '0';
		}
		
		Collections.sort(letters);
		for(int i = 0; i < letters.size(); i++) {
			answer.append(letters.get(i));
		}
		answer.append(num);
		//System.out.println(answer);
		return answer.toString();
	}
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		String s = "K1KA5CB7";
		System.out.println(solution.solution(s));
	}
}
