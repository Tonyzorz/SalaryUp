package dongbinna.binarySearch.binarySearch;

import java.util.*;

public class Solution_taewon_template {

	/*
	 * 
	 */
	public Solution_taewon_template() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int find, int[] array) {
		int answer = binarySearch(find, array, 0, array.length - 1);
		return answer >= 0 ? ++answer : answer;
	}
	
	public int binarySearch(int find, int[] array, int start, int end) {
		
		while(start <= end) {
			int mid = (start + end)/2;
			
			if(array[mid] == find) return mid;
			else if(array[mid] > find) end = mid - 1;
			else start = mid + 1;

		}
		return -1;
	}

	public static void main(String[] args) {
		Solution_taewon_template solution = new Solution_taewon_template();
		//10 7 
		//1 3 5 7 9 11 13 15 17 19 
		
		int find = 7;
		int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
		System.out.println(solution.solution(find, array));
	}
}
