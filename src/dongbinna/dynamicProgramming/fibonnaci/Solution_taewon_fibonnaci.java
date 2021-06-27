package dongbinna.dynamicProgramming.fibonnaci;

import java.util.*;

public class Solution_taewon_fibonnaci {

	/*
	 * 
	 */
	public Solution_taewon_fibonnaci() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int n) {
		
		if(n <= 2) return 1;
		
		return solution(n - 1) + solution(n - 2);
	}
	public static void main(String[] args) {
		Solution_taewon_fibonnaci solution = new Solution_taewon_fibonnaci();
		int n = 100;
		
		System.out.println(solution.solution(n));
	}
}
