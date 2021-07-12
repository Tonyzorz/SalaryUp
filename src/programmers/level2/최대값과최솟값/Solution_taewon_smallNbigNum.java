package programmers.level2.최대값과최솟값;

import java.util.*;

public class Solution_taewon_smallNbigNum {

	/*
	 * 최댓값과 최솟값
문제 설명
문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

제한 조건
s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
입출력 예
s	return
"1 2 3 4"	"1 4"
"-1 -2 -3 -4"	"-4 -1"
"-1 -1"	"-1 -1"
	 */
	public Solution_taewon_smallNbigNum() {
		// TODO Auto-generated constructor stub
	}
	
	public String solution(String s) {
        String[] numString = s.split(" ");
        int[] nums = new int[numString.length];
        
        for (int i = 0; i < numString.length; i++) {
        	nums[i] = Integer.parseInt(numString[i]);
        }
        
        Arrays.sort(nums);
        
        int small = nums[0];
        int large = nums[nums.length - 1];
        
        return small + " " + large;
    }
	
	public static void main(String[] args) {
		Solution_taewon_smallNbigNum solution = new Solution_taewon_smallNbigNum();
		String s = "-1 -2 -3 -4";
		System.out.println(solution.solution(s));
	}
}
