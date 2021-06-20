package dongbinna.greedy.multiOrAdd;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(String n) {
		int answer = 1;
		
		for(int i = 0; i < n.length(); i++) {
			int num = Integer.parseInt(String.valueOf(n.charAt(i)));
			if(num != 0) answer *= num;
		}
		
		return answer;
	}
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		String n = "02984";
		System.out.println(solution.solution(n));
	}
}
