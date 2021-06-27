package dongbinna.dynamicProgramming.goldmine;

import java.util.*;

public class Solution_taewon_template {

	/*
	 * 
	 */
	public Solution_taewon_template() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int[][] gm) {
		int answer = 0;
		int yMax = 0;
		int y_pos = 0;
		for(int i = 0; i < gm.length; i++) {
			if(yMax < gm[i][0]) {
				yMax = gm[i][0]; 
				y_pos = i;
			}
		}
		
		answer += gm[y_pos][0];
		
		for(int i = 1; i < gm[0].length; i++) {
			
			int temp_y = y_pos;
			yMax = 0;
			if(y_pos != 0) {
				if(yMax < gm[y_pos - 1][i]) {
					
					yMax = gm[y_pos - 1][i];
					temp_y = y_pos - 1;
				}
			}
			
			if(yMax < gm[y_pos][i]) {
				
				yMax = gm[y_pos][i];
				temp_y = y_pos;
			}
			
			if(y_pos != gm.length - 1) {
				if(yMax < gm[y_pos + 1][i]) {
					
					yMax = gm[y_pos + 1][i];
					temp_y = y_pos + 1;
				}
			}
			
			answer+= yMax;
			y_pos = temp_y;
		}
		
		return answer;
	}
	
	public int solution_dp(int[][] gm) {
		int answer = 0;
	
		int[][] dp = new int[gm.length][gm[0].length];
		
		for(int i = 0 ; i < gm.length; i++) {
			for(int j = 0; j < gm[0].length; j++) {
				dp[i][j] = gm[i][j];
			}
		}
		
		for(int i = 1; i < dp[0].length; i++) {
			for(int j = 0; j < dp.length; j++) {
				
				int left, leftUp, leftDown;
				
				if(j == 0) leftUp = 0;
				else leftUp = dp[j - 1][i - 1];
				
				left = dp[j][i - 1];
				
				if(j == dp.length - 1) leftDown = 0;
				else leftDown = dp[j + 1][i - 1];
				
				dp[j][i] = dp[j][i] + Math.max(left, Math.max(leftDown, leftUp));
			}
		}
		
		for(int i = 0; i < dp.length; i++) {
			if(answer < dp[i][dp[0].length - 1]) answer = dp[i][dp[0].length - 1];
		}
		return answer;
	}
	public static void main(String[] args) {
		Solution_taewon_template solution = new Solution_taewon_template();
		
		int y = 3;
		int x = 4;
		int[][] gm = {{1,3,3,2},{2,1,4,1},{0,6,4,7}};
		int[][] gm2 = {{1,3,1,5},{2,2,4,1},{5,0,2,3},{0,6,1,2}};
		System.out.println(solution.solution_dp(gm2));
		
	}
}
