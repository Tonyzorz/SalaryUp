package interview.naver_finance_2021_08.question1;

import java.util.*;

public class Solution_taewon_template_programmers {

	/*
	 * You are given an implementation fo a funciton : 
	 * 
	 * which accepts as input a non-empty zeor-indexed array A consisting of N integers.
	 * 
	 * The funciton works only slowly on large input data and the goal is to optimize it so as to achieve better time and/or space complexity. 
	 * The optimized function should return the same result as the given implementation for every input that satisfies the assumptions.
	 * 
	 * For example, given array A such that : 
	 * 
	 * A[0] = 4
	 * A[1] = 6
	 * A[2] = 2
	 * A[3] = 2
	 * A[4] = 6
	 * A[5] = 6
	 * A[6] = 1
	 * 
	 * the function returns 4.
	 * 
	 * 
	 * Also for given aray A such that : 
	 * 
	 * A[0] = 2
	 * A[1] = 2
	 * ...
	 * A[49999] = 2
	 * A[50000] = 2
	 * 
	 * in other words, A[K] = 2 for each K (0 <= K <= 50000), the given implementation works too slow, but the function would return 50000.
	 * 
	 * Write an efficient algorithm for the following assumptions:
	 * - N is an integer within the range [1..100,000]
	 * - each element of array A is an integer within the range [1..N].
	 * 
	 * The original code is : 
	 * 
	 * import java.util.*;
	 * 
	 * class Solution {
	 * 
	 * 		int solution(int[] A) {
	 * 			int N = A.length;
	 * 			int result = 0;
	 * 			for (int i = 0; i < N; i++) {
	 * 				for (int j = 0; j < N; j++) {
	 * 					if (A[i] == A[j]) {
	 * 						result = Math.max(result, Math.abs(i - j));
	 * 					}
	 * 				}
	 * 			}
	 * 			return result;
	 * 		}
	 * }
	 */
	public Solution_taewon_template_programmers() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int[] A) {
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		Solution_taewon_template_programmers solution = new Solution_taewon_template_programmers();
		int[] A = {4, 6, 2, 2, 6, 6, 1};
		
		System.out.println(solution.solution(A));
	}
	
}
