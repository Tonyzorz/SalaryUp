package algorithmsFullCourse_Tim_Roughgarden;

import java.util.Arrays;

public class MergeSort {

	public MergeSort() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5,4,1,8,7,2,6,3,1};
		
		System.out.println(Arrays.toString(merge(arr)));
	}
	
	public static int[] merge(int[] arr) {
		
		if (arr.length < 2) {
			return arr;
		}

		int mid = arr.length / 2;
		int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
		int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
		
		return mergeSort(merge(leftArr), merge(rightArr));
	}
	
	public static int[] mergeSort(int[] arr1, int[] arr2) {
		
		int[] arr = new int[arr1.length + arr2.length];
		int index = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		
		while (leftIndex < arr1.length && rightIndex < arr2.length) {
			
			if (arr1[leftIndex] < arr2[rightIndex]) {
				
				arr[index] = arr1[leftIndex];
				leftIndex++;
				index++;
				
			} else {
				
				arr[index] = arr2[rightIndex];
				rightIndex++;
				index++;
				
			}
		}
		if (leftIndex != arr1.length) {
			
			for (int i = leftIndex; i < arr1.length; i++) {
				arr[index] = arr1[i];
				index++;
			}
			
		} else {
			
			for (int i = rightIndex; i < arr2.length; i++) {
				arr[index] = arr2[i];
				index++;
			}
		}
		
		return arr;
	}
}
