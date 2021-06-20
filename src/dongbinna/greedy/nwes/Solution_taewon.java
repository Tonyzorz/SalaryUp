package dongbinna.greedy.nwes;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] solution(int n, String direction) {
		int[] answer = {1, 1};
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		HashMap<String, Integer> compass = new HashMap<String, Integer>();
		compass.put("L", 0);
		compass.put("R", 1);
		compass.put("U", 2);
		compass.put("D", 3);

		String[] directions = direction.split(" ");
		
		/*
		 * 내 풀이
		 */
//		for(int i = 0; i< directions.length; i++) {
//			if(directions[i].equals("R")) {
//				if(answer[1] != n) answer[1] += 1;
//			} else if (directions[i].equals("L")) {
//				if(answer[1] != 1) answer[1] -= 1;
//			} else if (directions[i].equals("D")) {
//				if(answer[0] != n) answer[0] += 1;
//			} else if (directions[i].equals("U")) {
//				if(answer[0] != 1) answer[0] -= 1;
//			}
//		}
		
		/*
		 * 동빈나
		 */
		for(int i = 0; i < directions.length; i++) {
			int index = compass.get(directions[i]);
			System.out.println(index);
			System.out.println(dx[index]);
			System.out.println(answer[1]);
			int tempx = answer[1] + dx[index];
			int tempy = answer[0] + dy[index];
			System.out.println(tempy + "," + tempx);
			if(tempy < 1 || tempy > n ||tempx > n || tempx < 1) {
				continue;
			}
			answer[1] = tempx;
			answer[0] = tempy;
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int n = 5;
		String direction = "R R R U D D";
		System.out.println(solution.solution(n, direction));
	}
}
