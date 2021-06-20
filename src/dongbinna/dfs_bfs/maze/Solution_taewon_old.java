package dongbinna.dfs_bfs.maze;

import java.util.*;

public class Solution_taewon_old {

	/*
	 * 
	 */
	public Solution_taewon_old() {
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
	
	public int solution(int n, int m, int[][] map) {
		bfs(0, 0, map);
		int answer = map[n - 1][m - 1];
		return answer;
	}
	
	public void bfs(int y, int x, int[][] map) {
		
		//never eat soggy waffle
		int[] dx = {0,1,0,-1};
		int[] dy = {-1,0,1,0};
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(y, x));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX();
			y = node.getY();
			
			
			for(int i = 0; i < dx.length; i++) {
				int tempx = x + dx[i];
				int tempy = y + dy[i];
				
				//continue if out of bound
				if(tempx >= map[0].length || tempx < 0 ||
						tempy >= map.length || tempy < 0) {
					continue;
				}
				//continue if it contains monster == 0
				if(map[tempy][tempx] == 0) {
					continue;
				}
				
				//replace the future digit with current digit + 1
				if(map[tempy][tempx] == 1) {
					map[tempy][tempx] = map[y][x]+1;
					q.offer(new Node(tempy, tempx));
				}
			}
		}
	}

//	public void dfs(int y, int x, int[][] map) {
//		
//		//never eat soggy waffle
//		int[] dx = {0,1,0,-1};
//		int[] dy = {-1,0,1,0};
//		
//		for(int i = 0; i < dx.length; i++) {
//			int tempx = x + dx[i];
//			int tempy = y + dy[i];
//			
//			//continue if out of bound
//			if(tempx >= map[0].length || tempx < 0 ||
//					tempy >= map.length || tempy < 0) {
//				continue;
//			}
//			//continue if it contains monster == 0
//			if(map[tempy][tempx] == 0) {
//				continue;
//			}
//			
//			//replace the future digit with current digit + 1
//			if(map[tempy][tempx] == 1) {
//				map[tempy][tempx] = map[y][x]+1;
//				dfs(tempy, tempx, map);
//			}
//		}
//	}
	public static void main(String[] args) {
		Solution_taewon_old solution = new Solution_taewon_old();
		int n = 5; //y axis
		int m = 6; //x axis
//		int[][] map = {{1,0,1,1,1,0},
//						{1,0,1,0,1,1},
//						{1,0,1,0,0,1},
//						{1,0,1,0,1,1},
//						{1,1,1,0,1,1},};
		
		int[][] map = {{1,0,1,0,1,0},
				{1,1,1,1,1,1},
				{0,0,0,0,0,1},
				{1,1,1,1,1,1},
				{1,1,1,1,1,1},};
		System.out.println(solution.solution(n, m, map));
		
		for(int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
