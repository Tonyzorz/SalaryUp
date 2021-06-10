package programmers.level2.기능개발;

import java.util.*;

public class Solution_taewon_queue {

	/*
	 * 
	 */
	public Solution_taewon_queue() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] solution(int[] progresses, int[] speeds) {
		
		
		//Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < progresses.length; i++) {
        	int diff =  (int) Math.ceil((float)(100 - progresses[i]) / speeds[i]);

			queue.add(diff);
		}
		//System.out.println(queue);
		ArrayList<Integer> s = new ArrayList<>();
		while(!queue.isEmpty()) {
			
			int cnt = 1;
			int top = queue.poll();
			while(!queue.isEmpty() && queue.peek() <= top) {
				cnt++;
				queue.poll();
			}
			s.add(cnt);
		}
		
		int[] answer = new int[s.size()];
		for(int i = 0; i < s.size(); i++) {
			answer[i] = s.get(i);
		}
		//System.out.println(s);
		return answer;
	}
	
	public static void main(String[] args) {
		Solution_taewon_queue solution = new Solution_taewon_queue();
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		System.out.println(solution.solution(progresses, speeds));
	}
}
