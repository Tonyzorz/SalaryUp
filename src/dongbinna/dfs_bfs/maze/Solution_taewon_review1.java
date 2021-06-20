package dongbinna.dfs_bfs.maze;

import java.util.*;

public class Solution_taewon_review1 {

	/*
	 * 
	 */
	public Solution_taewon_review1() {
		// TODO Auto-generated constructor stub
	}
	
	public class Node {
		
		private int y;
		private int x;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public int getX() {
			return x;
		}
	}
	
	public int solution(int[][] map, int x, int y) {
		
		//dfs_recursive(map, 0, 0);
		bfs_queue(map, 0, 0);
		for(int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		return map[y - 1][x - 1];
	}
	
	public void bfs_queue(int[][] map, int x, int y) {
		
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0,0,-1,1};
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(y, x));
		
		while(!q.isEmpty()) {
			
			Node node = q.poll();
			x = node.getX();
			y = node.getY();
			
			for(int i = 0; i < dy.length; i++) {
				
				int moveX = x + dx[i];
				int moveY = y + dy[i];
				
				if(moveX <= -1 || moveX >= map[0].length || moveY <= -1 || moveY >= map.length) {
					continue;
				}
				
				if(map[moveY][moveX] == 0) {
					continue;
				}
				if(map[moveY][moveX] == 1) {
					
					map[moveY][moveX] = map[y][x] + 1;
					q.offer(new Node(moveY, moveX));
				}
				
			} 
			
		}
		
	}
	
	public void dfs_recursive(int[][] map, int x, int y) {
		
		//상화좌우
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0,0,-1,1};
		for(int i = 0; i < dy.length; i++) {
			
			int moveX = x + dx[i];
			int moveY = y + dy[i];
			
			if(moveX <= -1 || moveX >= map[0].length || moveY <= -1 || moveY >= map.length) {
				continue;
			}
			
			if(map[moveY][moveX] == 0) {
				continue;
			}
			if(map[moveY][moveX] == 1) {
				
				map[moveY][moveX] = map[y][x] + 1;
				dfs_recursive(map, moveX, moveY);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Solution_taewon_review1 solution = new Solution_taewon_review1();
		int y = 5;
		int x = 6;
		int[][] map = {{1,0,1,0,1,0},
						{1,1,1,1,1,1},
						{0,0,0,0,0,1},
						{1,1,1,1,1,1},
						{1,1,1,1,1,1},};
		
		System.out.println(solution.solution(map, x, y));
	}
}
