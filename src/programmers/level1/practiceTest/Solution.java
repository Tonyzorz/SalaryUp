package programmers.level1.practiceTest;

import java.util.*;

public class Solution {

	/*
	 * 문제 설명
	수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
	수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
	
	1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5,   2, 1, 2, 3, 2, 4, 2, 5, ...
	3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,   3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	
	1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
	가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	
	제한 조건
	시험은 최대 10,000 문제로 구성되어있습니다.
	문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
	가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
	입출력 예
	answers	return
	[1,2,3,4,5]	[1]
	[1,3,2,4,2]	[1,2,3]
	입출력 예 설명
	입출력 예 #1
	
	수포자 1은 모든 문제를 맞혔습니다.
	수포자 2는 모든 문제를 틀렸습니다.
	수포자 3은 모든 문제를 틀렸습니다.
	따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
	
	입출력 예 #2
	
	모든 사람이 2문제씩을 맞췄습니다.
	 */
	public Solution() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] student1 = {1, 2, 3, 4, 5}; //5
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5}; //8
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //10
        int right1 = 0, right2 = 0, right3 = 0; 
        int largest = 0;
        int[] rightAns = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
        	if(answers[i] == student1[i]) right1++;
        	if(answers[i] == student2[i]) right2++;
        	if(answers[i] == student3[i]) right3++;
        }
        
        if(right1 >= right2 && right1 >= right3) {
        	largest = right1;
        } else if(right2 >= right3) {
        	largest = right2;
        } else {
        	largest = right3;
        }
        
        if(largest == right1) 
        return answer;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {3,1,2,3};
		System.out.println(solution.solution(nums));
	}

}
