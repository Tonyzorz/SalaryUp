package dongbinna.binarySearch.makeSpicyRicecake;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_taewon_template {

	/*
	 * 
	 */
	public Solution_taewon_template() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int need, Integer[] riceCakes) {
		int answer = 0;
		
        Arrays.sort(riceCakes, Collections.reverseOrder());
        
        int start = 0;
        int end = riceCakes[0];
		while(start <= end) {
			
			int mid = (start + end)/2;
			int total = 0;
			for(int i = 0; i < riceCakes.length; i++) {
				
				if(mid <= riceCakes[i]) {
					
					total += riceCakes[i] - mid;
				}
				
			}
			
			if(total > need) {
				start = mid + 1;
			} else {
				answer = mid;
				end = mid - 1;
			}
		}

		return answer;
	}

	public int binarySearch(int need, int[] riceCakes, int start, int end) {
		return -1;
	}
	
	public static void main(String[] args) {
		Solution_taewon_template solution = new Solution_taewon_template();
		
		int need = 6;
		Integer[] riceCakes = {19, 15, 10, 17};
		
		System.out.println(solution.solution(need, riceCakes));
	}
}
