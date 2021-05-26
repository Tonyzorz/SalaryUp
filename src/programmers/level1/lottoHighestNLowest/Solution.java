package programmers.level1.lottoHighestNLowest;

import java.util.Arrays;

public class Solution {

	/*
	 * 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다
	 * 
	 * 순위	당첨 내용
		1	6개 번호가 모두 일치
		2	5개 번호가 일치
		3	4개 번호가 일치
		4	3개 번호가 일치
		5	2개 번호가 일치
		6(낙첨)	그 외
		
		민우가 구매한 로또 번호 6개가 44, 1, 0, 0, 31 25라고 가정해보겠습니다.
		당첨 번호 6개가		    31_, 10, 45, 1_, 6, 19라면, 당첨 가능한 최고 순위와 최저 순위의 한 예는 아래와 같습니다.
		[4,2]
		
	 */
	public Solution() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int[] solution(int[] lottos, int[] win_nums) {
		/*
		 * 최대 당첨 순위  answer[0]
		 * 최소 당첨 순위  answer[1]
		 */
		int[] answer = new int[2];
		int numMatched = 0;
        int numOfZero = 0;
        
        for(int i = 0; i < 6; i++) {
        	
        	if(lottos[i] != 0) {
        		for(int j = 0; j < lottos.length; j++) {
        			if(lottos[i] == win_nums[j]) {
        				
        				numMatched++;
        				break;
        			}
        		}
        	} else {
        		numOfZero++;
        	}
        	
        }
        
        
        answer[0] = rank(numMatched + numOfZero); 
        answer[1] = rank(numMatched); 
        return answer;
    }
	
	public int rank(int numMatched) {
		
		int rank = 0;
		switch (numMatched) {
			case 6:
				rank = 1;
				break;
			case 5:
				rank = 2;
				break;
			case 4:
				rank = 3;
				break;
			case 3:
				rank = 4;
				break;
			case 2:
				rank = 5;
				break;
			default:
				rank = 6;
		}
		
		return rank;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		//int[] lottos = {44, 1, 0, 0, 31, 25};
		//int[] win_nums = {31, 10, 45, 1, 6, 19};
		// [3, 5]
		
		int[] lottos = {0, 0, 0, 0, 0, 0};
		int[] win_nums = {38, 19, 20, 40, 15, 25};
		// [1, 6]
		
//		int[] lottos = {45, 4, 35, 20, 3, 9};
//		int[] win_nums = {20, 9, 3, 45, 4, 35};
		// [1, 1]
		
		int[] answer = solution.solution(lottos, win_nums);
		
		System.out.println(Arrays.toString(answer));
	}
}
