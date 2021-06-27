package dongbinna.dynamicProgramming.fibonnaci;

import java.util.*;

public class Solution_taewon_fibonnaciDP {

	/*
	 * 
	 */
	public Solution_taewon_fibonnaciDP() {
		// TODO Auto-generated constructor stub
	}
	static long[] dp = new long[101];
	
	//탑다운
//	public long solution(int n) {
//		
//		if(n <= 2) return 1;
//		
//		if(dp[n] != 0) return dp[n];
//		
//		dp[n] = solution(n - 1) + solution(n - 2);
//		
//		return dp[n];
//	}
	
	//보텀업
	public long solution(int n) {
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		Solution_taewon_fibonnaciDP solution = new Solution_taewon_fibonnaciDP();
		int n = 99;
		
		System.out.println(solution.solution(n));
	}
}
