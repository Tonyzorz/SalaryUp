package dongbinna.greedy.time;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int n) {
		int answer = 0;
		
		for(int h = 0; h <= n; h++) {
			for(int m = 0; m < 60; m++) {
				for(int s = 0; s < 60; s++) {
					if(s % 10 == 3 || s/10 == 3 ||
							m % 10 == 3 || m/10 == 3 ||
							h % 10 == 3 || h/10 == 3) {
						answer++;
					}
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int n = 5;
		System.out.println(solution.solution(n));
	}
}
