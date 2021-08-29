package interview.naver_finance_2021_08_2.question1;

import java.util.*;

public class Solution_taewon_template_programmers {

	/*
	 * 
	 */
	public Solution_taewon_template_programmers() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int[] A) {
		
		HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
		int max = 0;
		
		for (int i = 0; i < A.length; i++) {
			
			if (numbers.containsKey(A[i])) {
				int repition = numbers.get(A[i]) + 1;
				numbers.put(A[i], repition);
				
			} else {
				numbers.put(A[i], 1);
			}
		}
		
		for (Map.Entry<Integer, Integer> set : numbers.entrySet()) {
			if (set.getKey() == set.getValue()) {
				if (max  < set.getKey()) {
					max = set.getKey();
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Solution_taewon_template_programmers solution = new Solution_taewon_template_programmers();
		int[] A = {5,5,5,5,5};
		System.out.println(solution.solution(A));
	}
}
