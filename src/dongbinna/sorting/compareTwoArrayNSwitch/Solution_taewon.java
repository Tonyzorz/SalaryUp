package dongbinna.sorting.compareTwoArrayNSwitch;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int n, int k, int[] arrayA, int[] arrayB) {
		int answer = 0;
		
		quickSort(arrayA, 0, arrayA.length - 1);
		quickSort(arrayB, 0, arrayB.length - 1);
		System.out.println(Arrays.toString(arrayA));
		System.out.println(Arrays.toString(arrayB));
		//how many types i have to swap numbers from two arrays
		for(int i = 0; i < k; i++) {
			
			int temp = arrayA[i];
			arrayA[i] = arrayB[arrayB.length - 1 - i];
			arrayB[arrayB.length - 1 - i] = temp;
		}
		
		for(int num : arrayA) answer += num;
		
		return answer;
	}
	
	public void quickSort(int[] beforeSort, int start, int end) {
		
		if(start >= end) return;
		
		int pivot = start;
		int left = start + 1;
		int right = end;
		
		while(left <= right) {
			
			while(left <= end && beforeSort[left] <= beforeSort[pivot]) left++;
			while(right > start && beforeSort[right] >= beforeSort[pivot]) right--;
			
			if(left > right) {
				int temp = beforeSort[pivot];
				beforeSort[pivot] = beforeSort[right];
				beforeSort[right] = temp;
			} else {
				int temp = beforeSort[left];
				beforeSort[left] = beforeSort[right];
				beforeSort[right] = temp;
			}
		}
		
		quickSort(beforeSort, start, right - 1);
		quickSort(beforeSort, right + 1, end);
		
	}
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int n = 5;
		int k = 3;
		int[] arrayA = {1,2,5,4,3};
		int[] arrayB = {5,5,6,6,5};
		
		System.out.println(solution.solution(n, k, arrayA, arrayB));
	}
}
