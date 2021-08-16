package bigONotation;

public class BinarySearch_logn {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 7, 12, 43, 44, 54, 100, 124};
		int find = 100;
		
		System.out.println(binarySearch(arr, find));
		System.out.println(binarySearchRecursive(arr, find, 0, arr.length - 1));
	}
	
	public static int binarySearch(int[] arr, int find) {
		
		int start = 0;
		int end = arr.length - 1;
		
		while (start <= end) {
		
			int mid = (start + end) / 2;
			
			if (arr[mid] == find) return mid;
			if (arr[mid] > find) {
				end = mid - 1;
			} else if (arr[mid] < find) {
				start = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static int binarySearchRecursive(int[] arr, int find, int start, int end) {
		
		if (start > end) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		
		if (arr[mid] == find) {
			return mid;
		}
		
		if (arr[mid] > find) {
			return binarySearchRecursive(arr, find, start, mid - 1);
		} else {
			return binarySearchRecursive(arr, find, mid + 1, end);
		}
		
	}
	
}
