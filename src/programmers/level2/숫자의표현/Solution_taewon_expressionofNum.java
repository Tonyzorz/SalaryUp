package programmers.level2.숫자의표현;

import java.util.*;

public class Solution_taewon_expressionofNum {

	/*
	 * 숫자의 표현
문제 설명
Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 
예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.

1 + 2 + 3 + 4 + 5 = 15
4 + 5 + 6 = 15
7 + 8 = 15
15 = 15
자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.

제한사항
n은 10,000 이하의 자연수 입니다.
입출력 예
n	result
15	4
입출력 예 설명
입출력 예#1
문제의 예시와 같습니다.
	 */
	public Solution_taewon_expressionofNum() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
        	if (recursive(i, i + 1, n)) {
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public boolean recursive(int current, int next, int max) {
		
		if (current == max) {
			return true;
		} else if (current > max) {
			return false;
		}
		
		return recursive(current + next, next + 1, max);
	}
	
	public int solution_notRecursive(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
        	int checkNum = 0;
        	
        	for (int j = i; j <= n; j++) {
        		checkNum += j;
        		
        		if (checkNum == n) {
        			answer++;
        		} else if (checkNum > n) {
        			break;
        		}
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_taewon_expressionofNum solution = new Solution_taewon_expressionofNum();
		int n = 15;
		System.out.println(solution.solution_notRecursive(n));
	}
}
