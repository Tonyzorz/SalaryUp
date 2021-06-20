package dongbinna.sorting.selection_sort;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public void selection_sort(int[] array) {
		
		for(int i = 0; i < array.length - 1; i++) {
			int index = i;
			for(int j = i + 1; j < array.length; j++) {
				
				if(array[index] > array[j]) {
					index = j;
				}
			}
			
			//swap
			int temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int[] array= {7,5,9,0,3,1,6,2,4,8,};
		solution.selection_sort(array);
	}
}
