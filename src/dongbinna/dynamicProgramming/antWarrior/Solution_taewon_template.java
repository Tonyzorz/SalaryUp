package dongbinna.dynamicProgramming.antWarrior;

import java.util.*;

public class Solution_taewon_template {

	/*
	 * 
	 */
	public Solution_taewon_template() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int n, int[] foodStorage) {

		int[] dp = new int[n];
		dp[0] = foodStorage[0]; 
		dp[1] = Math.max(foodStorage[0], foodStorage[1]);
		
		for(int i = 2; i < n; i++) {
			dp[i] = Math.max(foodStorage[i - 1], foodStorage[i - 2] + foodStorage[i]);
		}
		
		System.out.println(Arrays.toString(dp));
		return dp[n - 1];
	}
	
	public static void main(String[] args) {
		Solution_taewon_template solution = new Solution_taewon_template();
		int n = 4;
		int[] foodStorage = {1,3,1,5};
		System.out.println(solution.solution(n, foodStorage));
	}
}
