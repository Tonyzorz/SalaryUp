package interview.naver_finance_2021_08_2.question2;

import java.util.*;

public class Solution_taewon_template_programmers {

	/*
	 * 
	 */
	public Solution_taewon_template_programmers() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int[] A) {

		if (isAesthetic(A)) {
			return 0;
		}
		
		int cnt = 0;
		
		for (int i = 0; i < A.length; i++) {
			int[] B = arrayWithoutIndex(A, i);
			if (isAesthetic(B)) {
				cnt++;
			}
		}
		
		return cnt == 0 ? -1 : cnt;
	}
	
	public boolean isAesthetic(int[] A) {
		
		boolean isUp = false;
		if (A[0] < A[1]) {
			isUp = true;
		} 
		
		for (int i = 1; i < A.length; i++) {
			if (isUp) {
				
				if (i % 2 == 1 && A[i] > A[i - 1]) {
					
				} else if (i % 2 == 0 && A[i] < A[i - 1]) {
					
				} else {
					return false;
				}
			} else {
				if (i % 2 == 1 && A[i] < A[i - 1]) { 
					
				} else if (i % 2 == 0 && A[i] > A[i - 1]) {
					
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public int[] arrayWithoutIndex(int[] A, int index) {
		int[] B = new int[A.length - 1];
		int j = 0;
		
		for (int i = 0; i < A.length; i++) {
			if (i == index) {
				continue;
			}
			B[j] = A[i];
			j++;
		}
		
		return B;
	}
	
	public static void main(String[] args) {
		Solution_taewon_template_programmers solution = new Solution_taewon_template_programmers();
		//int[] A = {3,4,5,3,7};
		//int[] A = {1,1,1,1,1,1,1,2};
		//int[] A = {1,2,3,4};
		//int[] A = {1,3,1,2};
		System.out.println(solution.solution(A));
	}
}
