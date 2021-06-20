package dongbinna.greedy.untilOne;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int n, int k) {
		int answer = 0;
		while(n > 1) {
			if(n % k == 0) {
				n /= k;
			} else {
				n -= 1;
			}
			answer++;
		}
		return answer;
	}
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int n = 25;
		int k = 5;
		System.out.println(solution.solution(n, k));
	}
}
