package dongbinna.dfs_bfs.factorial;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	//iterate
	public int factorial_iterate(int n) {
		int answer = 1;
		
		for(int i = 1; i <= n; i++) {
			answer *= i;
		}
		
		return answer;
	}
	
	//recursive 
	public int factorial_recursive(int n) {
		
		if(n <= 1) {
			return 1;
		}
		System.out.println(n);
		return n * factorial_recursive(n - 1);
	}
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int n = 5;
		//System.out.println(solution.factorial_iterate(n));
		System.out.println(solution.factorial_recursive(n));
	}
}
