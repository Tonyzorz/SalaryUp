package dongbinna.dfs_bfs.freezeBev;

import java.util.*;

public class Solution_taewon_review1 {

	/*
	 * 
	 */
	public Solution_taewon_review1() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int solution(int[][] map, int y, int x) {
		int answer = 0;
		
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				
				//if(dfs(map, i, j)) answer++;
				if(bfs_queue(map, i, j)) answer++;
			}
		}
		return answer;
	}
	
	public boolean dfs(int[][] map, int y, int x) {
		if(y < 0 || y >= map.length || 
				x < 0 || x >= map[0].length) {
			return false;
		}
		
		if(map[y][x] == 0) {
			map[y][x] = 1;
			dfs(map, y - 1, x);
			dfs(map, y + 1, x);
			dfs(map, y, x - 1);
			dfs(map, y, x + 1);
			return true;
		}
		return false;
	}
	
	public boolean bfs_queue(int[][] map, int y, int x) {
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		qx.offer(x);
		qy.offer(y);
		
		while(!qx.isEmpty() && !qy.isEmpty()) {
			
			x = qx.poll();
			y = qy.poll();
			
			for(int i = 0; i < dx.length; i++) {
				
				int moveX = x + dx[i];
				int moveY = y + dy[i];
				
				if(moveY < 0 || moveY >= map.length || 
						moveX < 0 || moveX >= map[0].length) {
					return false;
				}
				
				if(map[moveY][moveX] == 0) {
					map[moveY][moveX] = 1;
					qx.offer(moveX);
					qy.offer(moveY);
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Solution_taewon_review1 solution = new Solution_taewon_review1();
		int y = 4;
		int x = 5;
		int[][] map = {{0,0,1,1,0},
						{0,0,0,1,1},
						{1,1,1,1,1},
						{0,0,0,0,0}};
		
		System.out.println(solution.solution(map, y, x));
	}
}
