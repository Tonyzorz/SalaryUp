package programmers.playground;

import java.util.*;

public class Solution_taewon_template_bigNum {

	/*
	 * 가장 큰 수
	문제 설명
	0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
	
	예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
	
	0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
	
	제한 사항
	numbers의 길이는 1 이상 100,000 이하입니다.
	numbers의 원소는 0 이상 1,000 이하입니다.
	정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
	입출력 예
	numbers	return
	[6, 10, 2]	"6210"
	[3, 30, 34, 5, 9]	"9534330"
	 */
	public Solution_taewon_template_bigNum() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String solution2(int[] numbers) {
		String answer = "";
		Set<String> list = new HashSet<String>();
		boolean[] visited = new boolean[numbers.length];
		for(int i = 0; i < numbers.length; i++) {
			
			recursive(numbers, "", list, i, numbers.length, new boolean[numbers.length]);
		}
		System.out.println(list);
		return answer;
	}
	
	public void recursive(int[] numbers, String add, Set<String> list, int current, int length, boolean[] visited) {
		System.out.println(".");
		if(current >= length) {
			list.add(add);
			return;
		}
		
		for(int i = 0; i < numbers.length; i++) {
			
			if(visited[i] == false) {
				visited[i] = true;
				recursive(numbers, add + numbers[i], list, current + 1, length, visited);
			}
		}
	}
	
	public String solution(int[] numbers) {
        String answer = "";
        Integer[] nums = new Integer[numbers.length];

        int z = 0;
        for(int i : numbers) nums[z++] = Integer.valueOf(i);
        
        System.out.println("before sort = " + Arrays.toString(nums));
        Arrays.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer int1, Integer int2) {
				
				String int1_s = String.valueOf(int1);
				String int2_s = String.valueOf(int2);
				
				int int1_i = 0;
				int int2_i = 0;
				
//				if(int1_s.charAt(int1_i) < int2_s.charAt(int1_i)) {
//					System.out.println("?");
//					return 1;
//				}
				while(int1_i < int1_s.length() && int2_i < int2_s.length()) {
				
					if(int1_s.charAt(int1_i) < int2_s.charAt(int1_i)) {
						return 1;
					} else if (int1_s.charAt(int1_i) < int2_s.charAt(int1_i)) {
						return -1;
					} else {
						int1_i++;
						int2_i++;
					}
				}
				
				return -1;
			}
        	
        });
        System.out.println("after sort = " + Arrays.toString(nums));
        
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_taewon_template_bigNum solution = new Solution_taewon_template_bigNum();
		int[] numbers = {6, 10, 2};
		System.out.println(solution.solution2(numbers));
	}
}
