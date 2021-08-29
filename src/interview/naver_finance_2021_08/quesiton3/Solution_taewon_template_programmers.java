package interview.naver_finance_2021_08.quesiton3;

import java.util.*;

public class Solution_taewon_template_programmers {

	/*
	 * 
	 */
	public Solution_taewon_template_programmers() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(String S, String T) {
		String[] start = S.split(":");
		String[] end = T.split(":");
		int cnt = 0;
		
		while (true) {
			
			if (isInteresting(start)) {
				cnt++;
			}
			
			if (start[0].equals(end[0]) && start[1].equals(end[1]) && start[2].equals(end[2])) {
				return cnt;
			}
			
			int seconds = Integer.parseInt(start[2]);
			int minutes = Integer.parseInt(start[1]);
			int hours = Integer.parseInt(start[0]);
			
			if (seconds < 59) {
				start[2] = String.format("%02d", seconds + 1);
			} else if (minutes < 59) {
				start[2] = "00";
				start[1] = String.format("%02d", minutes + 1);
			} else {
				start[2] = "00";
				start[1] = "00";
				start[0] = String.format("%02d", hours + 1);
			}
		}
	}
	
	public boolean isInteresting(String[] times) {
		Set<Character> numbers = new HashSet<Character>();
		
		for (String time : times) {
			numbers.add(time.charAt(0));
			numbers.add(time.charAt(1));
		}
		
		return numbers.size() <= 2;
	}
	
	public static void main(String[] args) {
		Solution_taewon_template_programmers solution = new Solution_taewon_template_programmers();
		String S = "22:22:21";
		String T = "22:22:23";
		System.out.println(solution.solution(S, T));
	}
}
