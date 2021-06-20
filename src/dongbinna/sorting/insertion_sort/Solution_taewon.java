package dongbinna.sorting.insertion_sort;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public void insertion_sort(int[] array) {
		
		for(int i = 1; i < array.length; i++) {
			for(int j = i; j > 0; j--) {
				if(array[j] < array[j - 1]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				} else break;
			}
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int[] array = {7,5,9,0,3,1,6,2,4,8,};
		solution.insertion_sort(array);
	}
}
