package interview.naver_finance_2021_08.question2;

import java.util.*;

public class Solution_taewon_template_programmers {

	/*
	 * 
	 */
	public Solution_taewon_template_programmers() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int[] A) {
	
		HashMap<Integer, List<Integer>> numberSet = new HashMap<Integer, List<Integer>>();
		boolean hasPair = false;
		
		for (int i = 0; i < A.length; i++) {
			int total = digitSum(A[i]);
			
			if ((numberSet.get(total) == null)) {
				List<Integer> numbers = new LinkedList<Integer>();
				numbers.add(A[i]);
				numberSet.put(total, numbers);
			} else {
				hasPair = true;
				List<Integer> numbers = numberSet.get(total);
				numbers.add(A[i]);
				numberSet.put(total, numbers);
			}
		}
		
		if (!hasPair) {
			return -1;
		}
		
		int max = 0;
		for (Map.Entry<Integer, List<Integer>> set : numberSet.entrySet()) {
			List<Integer> numbers = numberSet.get(set.getKey());
			Collections.sort(numbers, Collections.reverseOrder());
			int total = numbers.get(0) + numbers.get(1);
			
			if (max < total) {
				max = total;
			}
		}
		
		return max;
	}
	
	public static int digitSum(int num) {
		int total = 0;
		
		while (num > 0) {
			total += num % 10;
			num /= 10;
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		Solution_taewon_template_programmers solution = new Solution_taewon_template_programmers();
		//int[] A = {51,71,17,42};
		int[] A = {51, 32, 43};
		//int[] A = {42,33,60};
		System.out.println(solution.solution(A));
	}
}
