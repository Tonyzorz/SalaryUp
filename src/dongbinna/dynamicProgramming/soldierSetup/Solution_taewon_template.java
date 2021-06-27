package dongbinna.dynamicProgramming.soldierSetup;

import java.util.*;

public class Solution_taewon_template {

	/*
	 * 
	 */
	public Solution_taewon_template() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(ArrayList<Integer> solider) {
		int answer = 0;
		
		//LIS 
		int[] dp = new int[solider.size()];
		Arrays.fill(dp, 1);
		
		for(int i = 1; i < dp.length; i++) {
			for(int j = 0; j < i; j++) {
				if(solider.get(j) < solider.get(i)) dp[i] = Math.max(dp[i], dp[j] + 1);
				System.out.println("working = " + Arrays.toString(dp));
			}
			System.out.println("final = "+Arrays.toString(dp));
		}
		
		int highest = 0;
		for(int i = 0; i < dp.length; i++) if(highest < dp[i]) highest = dp[i];
		
		return solider.size() - highest;
	}
	
	public static void main(String[] args) {
		Solution_taewon_template solution = new Solution_taewon_template();
		int[] array = {15,11,4,8,5,2,4};
		
		ArrayList<Integer> solider = new ArrayList<Integer>();
		
		for(int i = 0; i < array.length; i++) {
			solider.add(array[i]);
		}
		
		Collections.reverse(solider);
		System.out.println(solution.solution(solider));
	}
}
