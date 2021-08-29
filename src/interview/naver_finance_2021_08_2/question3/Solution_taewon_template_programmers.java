package interview.naver_finance_2021_08_2.question3;

import java.util.*;

public class Solution_taewon_template_programmers {

	/*
	 * 
	 */
	public Solution_taewon_template_programmers() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int solution(int[] A, int X, int Y) {
		
		int until = A.length - (X - 1) * Y;
		int least = Integer.MAX_VALUE;
		
		for (int i = 0; i < until; i++) {
			int total = 0;
			int days = 0;
			
			for (int j = i; days < X; j += Y) {
				
				total += A[j];
				days++;
			}
			
			if (least > total) {
				least = total;
			}
		}
		
		return least;
	}
	
	public static void main(String[] args) {
		Solution_taewon_template_programmers solution = new Solution_taewon_template_programmers();
//		int[] A = {4,2,3,7};
//		int X = 2;
//		int Y = 2;
		
//		int[] A = {10,3,4,7};
//		int X = 2;
//		int Y = 3;
		
		int[] A = {4,2,5,4,3,5,1,4,2,7};
		int X = 3;
		int Y = 2;
		System.out.println(solution.solution(A, X, Y));
	}
}
