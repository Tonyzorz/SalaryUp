package programmers.level1.kNum;

import java.util.*;

public class Solution {

	/*
	 * 문제 설명
		배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
		
		예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
		
		array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
		1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
		2에서 나온 배열의 3번째 숫자는 5입니다.
		배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
		
		제한사항
		array의 길이는 1 이상 100 이하입니다.
		array의 각 원소는 1 이상 100 이하입니다.
		commands의 길이는 1 이상 50 이하입니다.
		commands의 각 원소는 길이가 3입니다.
		입출력 예
		array						commands							return
		[1, 5, 2, 6, 3, 7, 4]		[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
		입출력 예 설명
		[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
		[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
		[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
			 */
	public Solution() {
		// TODO Auto-generated constructor stub
	}

	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0; //짜르기 시작
        int j = 0; //짜르기 끝
        int k = 0; //짜른 후 몇번째 
        
        for(int z = 0; z < commands.length; z++) {
        	ArrayList<Integer> temp = new ArrayList<Integer>();
        	
        	//리스트가 0부터 시작하는거 고려안하는 문제... 
        	i = commands[z][0] - 1;
        	j = commands[z][1] - 1;
        	k = commands[z][2] - 1;
        	
        	//시작부터 끝까지 temp에 담고 
        	for(; i <= j; i++) {
        		temp.add(array[i]);
        	}
        	
        	//소팅
        	Collections.sort(temp);
        	answer[z] = temp.get(k);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		System.out.println(solution.solution(array, commands));
	}
}
