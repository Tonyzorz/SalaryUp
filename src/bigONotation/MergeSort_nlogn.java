package bigONotation;

import java.util.Arrays;

public class MergeSort_nlogn {

	public static void main(String[] args) {
		
		int[] arr = {12, 3, 16, 6, 5, 1};
		System.out.println(Arrays.toString(mergeSort(arr)));
		
	}
	
	public static int[] mergeSort(int[] arr) {
		if (arr.length < 2) {
			return arr;
		}
		
		int mid = arr.length / 2;
		int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
		int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
		
		return merge(mergeSort(leftArr), mergeSort(rightArr));
	}

	public static int[] merge(int[] leftArr, int[] rightArr) {
		int[] resultArr = new int[leftArr.length + rightArr.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int index = 0;
		
		while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
			if (leftArr[leftIndex] < rightArr[rightIndex]) {
				resultArr[index] = leftArr[leftIndex];
				leftIndex++;
				index++;
			} else {
				resultArr[index] = rightArr[rightIndex];
				rightIndex++;
				index++;
			}
		}
		
		//there remains left array numbers that has not been inserted
		if (leftIndex != leftArr.length) {
		
			for (int i = leftIndex; i < leftArr.length; i++) {
				resultArr[index] = leftArr[i];
				index++;
			}
		//there remains right array numbers that has not been inserted 
		} else {
			
			for (int i = rightIndex; i < rightArr.length; i++) {
				resultArr[index] = rightArr[i];
				index++;
			}
		}
		
		return resultArr;
	}
	
	
}
