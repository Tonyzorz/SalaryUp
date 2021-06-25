package dongbinna.sorting.counting_sort;

import java.util.*;

public class Solution_taewon {

	/*
	 * 계수 정렬
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	//시간 복잡도 O(n + K)
	//k = n의 제일 큰 수 
	//공간 복잡도는 높음 
	//만약 데이터가 0과 999999 2개가 있다면 엄청난 비효율성이 나타날 수 있다. 
	//계수 정렬은 동일한 값을 가지는 데이터가 여러 개 등장할때 효율적이다. 
	public int[] solution(int[] array) {
		
		//find k 
		int highest = 0;
		for(int i = 0; i < array.length; i++) {
			if(highest < array[i]) highest = array[i];
		}
		
		//answer[index] 마다 count방 올려주기 
		int[] answer = new int[array.length];
		int[] count = new int[highest + 1];
		for(int i : array) count[i]++;
		
		//count각 방 숫자만큼 answer에 순서대로 담기 
		int place = 0;
		for(int i = 0; i < count.length; i++) {
			for(int j = 0; j < count[i]; j++) {
				answer[place] = i;
				place++;
			}
		}
		
		return answer;
	}

	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int[] array = {7,5,9,0,3,1,6,2,9,1,4,8,0,5,2,};
		System.out.println(Arrays.toString(solution.solution(array)));
	}
}
