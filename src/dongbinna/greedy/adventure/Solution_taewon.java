package dongbinna.greedy.adventure;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int num, int[] p) {
		int answer = 0;
		
		Arrays.sort(p);
		
		int count = 0;
		for(int i = 0; i < p.length; i++) {
			count++;
			if(count >= p[i]) {
				answer++;
				count = 0;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int num = 5;
		int[] p = {2,3,1,2,2};
		System.out.println(solution.solution(num, p));
	}
} 	
