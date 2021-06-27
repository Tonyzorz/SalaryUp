package dongbinna.dynamicProgramming.numTo1;

import java.util.*;

public class Solution_taewon_template {

	/*
	 * 
	 */
	public Solution_taewon_template() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int n) {
		int answer = 0;
		int[] dp = new int[n + 1];
		
		for(int i = 2; i <= n; i++) {
			
			dp[i] = dp[i - 1] + 1;
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
			if(i % 5 == 0) dp[i] = Math.min(dp[i], dp[i/5] + 1);
			
			System.out.println("i is == " + i + " ,array = " + Arrays.toString(dp));
		}
		
		return dp[n];
	}
	/*
	 * divide by 5
	 * divide by 3
	 * divide by 2
	 * minus -1
	 * fastest way to make given number to 1
	 */
	public static void main(String[] args) {
		Solution_taewon_template solution = new Solution_taewon_template();
		int n = 26;
		System.out.println(solution.solution(n));
	}
}
