package programmers.level2.N개의최소공배수;

import java.util.*;

public class Solution_taewon_leastCommonDe {

	/*
	 * N개의 최소공배수
		문제 설명
		두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 
		예를 들어 2와 7의 최소공배수는 14가 됩니다. 
		정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. 
		n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
		
		제한 사항
		arr은 길이 1이상, 15이하인 배열입니다.
		arr의 원소는 100 이하인 자연수입니다.
		입출력 예
		arr	result
		[2,6,8,14]	168
		[1,2,3]	6
	 */
	public Solution_taewon_leastCommonDe() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Let we have to find the LCM of 
		arr[] = {1, 2, 3, 4, 28}
		
		We initialize result = 1.
		
		2 is a common factor that appears in
		two or more elements. We divide all
		multiples by two and multiply result
		with 2.
		arr[] = {1, 1, 3, 2, 14}
		result = 2
		
		2 is again a common factor that appears 
		in two or more elements. We divide all
		multiples by two and multiply result
		with 2.
		arr[] = {1, 1, 3, 1, 7}
		result = 4
		
		Now there is no common factor that appears
		in two or more array elements. We multiply
		all modified array elements with result, we
		get.
		result = 4 * 1 * 1 * 3 * 1 * 7
		       = 84

	 */
	public int solution(int[] arr) {
        int answer = 1;
        int maxNum = 0;
        
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] > maxNum) maxNum = arr[i];
        }
        
        int factor = 2;
        while (factor <= maxNum) {
        	
        	Vector<Integer> indexes = new Vector<>();
        	for (int j = 0; j < arr.length; j++) {
        		if (arr[j] % factor == 0) indexes.add(j);
        	}
        	
        	if (indexes.size() >= 2) {
        		for (int j = 0; j < indexes.size(); j++) {
        			arr[indexes.get(j)] = arr[indexes.get(j)] / factor;
        		}
        		
        		answer *= factor;
        	} else {
        		factor++;
        	}
        }
        
        for (int num : arr) answer *= num;
        
        return answer;
    }
	
	public int gcd(int a, int b) {
		
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		Solution_taewon_leastCommonDe solution = new Solution_taewon_leastCommonDe();
		int[] arr = {2,6,8,14};
		System.out.println(solution.solution(arr));
	}
}
