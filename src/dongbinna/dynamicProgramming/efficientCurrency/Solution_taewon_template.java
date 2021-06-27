package dongbinna.dynamicProgramming.efficientCurrency;

import java.util.*;

public class Solution_taewon_template {

	/*
	 * 
	 */
	public Solution_taewon_template() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int total, int[] change) {
		
		int[] dp = new int[total + 1];
		Arrays.fill(dp, 10001);
		
		dp[0] = 0;
		System.out.println(Arrays.toString(dp));

		for(int i = 0; i < change.length; i++) {
			
			for(int j = change[i]; j <= total; j++) {
				if(dp[j - change[i]] != 10001) {
					dp[j] = Math.min(dp[j], dp[j - change[i]] + 1);
				}
			}
			
		}
		
		System.out.println(Arrays.toString(dp));
		return dp[total] != 10001 ? dp[total] : -1;
	}
	public static void main(String[] args) {
		Solution_taewon_template solution = new Solution_taewon_template();
		int total = 4;
		int[] change = {3,5,7};
		
		System.out.println(solution.solution(total, change));
	}
}
