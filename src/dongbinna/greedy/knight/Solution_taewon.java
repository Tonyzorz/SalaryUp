package dongbinna.greedy.knight;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(String place) {
		int answer = 0;
		int x = place.charAt(0) - 'a' + 1;
		int y = place.charAt(1) - '0';
		//int[] currentPlace = {y, x};
		
		/*
		 * chess x, y axis
		 * clockwise 
		 */
		int[] cx = {1, 2, 2, 1, -1, -2, -2, -1};
		int[] cy = {-2, -1, 1, 2, 2, 1, -1, -2};
		
		for(int i = 0; i < cx.length; i++) {
			int tempy = y + cy[i];
			int tempx = x + cx[i];
			
			if(tempy > 8 || tempy < 1 || tempx > 8 || tempx < 1) {
				continue; 
			}
			
			answer++;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		String place = "g6";
		System.out.println(solution.solution(place));
		
	}
}
