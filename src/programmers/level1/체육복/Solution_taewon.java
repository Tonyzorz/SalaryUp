package programmers.level1.체육복;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 * 
	 * 전체 학생의 수는 2명 이상 30명 이하입니다.
		체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
		여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
		여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
		여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.

		n	lost	reserve		return
		5	[2, 4]	[1, 3, 5]	5
		5	[2, 4]	[3]			4
		3	[3]		[1]			2
		
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n];
        //-1 0 1 
        //-1 no clothes
        //0 has clothes 
        //1 has spare clothes 
        
        for(int i : reserve) {
        	students[i - 1]++;
        }
        
        for(int i : lost) {
        	students[i - 1]--;
        }
        
        for(int i = 0; i < n; i++) {
        	if(students[i] < 0) {

        		int previous = i - 1; 
        		int after = i + 1;
        		
        		if(previous >= 0 && students[previous] > 0) {
    				students[i]++;
    				students[previous]--;
    				answer++;
    				
        		} else if (after < n && students[after] > 0) {
        			students[i]++;
    				students[after]--;
    				answer++;
        		}
        		
        	} else {
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};
		int n = 3;
		
		int answer = solution.solution(n, lost, reserve);
		System.out.println(answer);
	}
}
