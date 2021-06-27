package dongbinna.binarySearch.findNum;

import java.util.*;

public class Solution_taewon_template {

	/*
	 * 
	 */
	public Solution_taewon_template() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int find, int[] array) {
		
		int answer = 0;
		
		int start = 0;
		int end = array.length - 1;
		int startPoint = 0;
		int endPoint = 0;
		//find starting point
		while(start <= end) {
			int mid = (start + end)/2;
			if(array[mid] >= find) {
				startPoint = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		start = 0;
		end = array.length - 1;
		while(start <= end) {
			int mid = (start + end)/2;
			if(array[mid] <= find) {
				endPoint = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(startPoint);
		System.out.println(endPoint);
		answer = endPoint - startPoint + 1;
		return answer > 0 ? answer : -1;
	}
	public static void main(String[] args) {
		Solution_taewon_template solution = new Solution_taewon_template();
		int find = 2;
		int[] array = {1,1,2,2,2,2,3};
		System.out.println(solution.solution(find, array));
	}
}
