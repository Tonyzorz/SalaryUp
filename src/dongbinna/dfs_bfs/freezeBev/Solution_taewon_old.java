package dongbinna.dfs_bfs.freezeBev;

import java.util.*;

public class Solution_taewon_old {

	/*
	 * 
	 */
	public Solution_taewon_old() {
		// TODO Auto-generated constructor stub
	}
	
	static int count = 0;
	public int solution(int[][] map, int n, int m) {
		int answer = 0;
		
		boolean[][] visited = new boolean[n][m];
		for(int i = 0; i < map.length; i++) {
			
			for(int j = 0; j < map[i].length; j++) {
				
				if(dfs_recursive(visited, map, j, i)) {
					
					answer++;
				}
			}
		}
		
		for(int i = 0; i < visited.length; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		return answer;
	}
	//working but not right for this question 
//	public void dfs_recursive(boolean[][] visited, int[][] map, int x, int y) {
//		//clockwise north first
//		int[] dx = {0, 1, 0, -1};
//		int[] dy = {-1, 0, 1, 0};
//		visited[y][x] = true;
//		for(int i = 0; i < dx.length; i++) {
//			int tempx = x + dx[i];
//			int tempy = y + dy[i];
//			
//			if(tempx >= map[0].length || tempx < 0 ||
//					tempy < 0 || tempy >= map.length) {
//				continue;
//			}
//			
//			if(!visited[tempy][tempx] && map[tempy][tempx] == 0) {
//				dfs_recursive(visited, map, tempx, tempy);
//			}
//		}
//	}
	public boolean dfs_recursive(boolean[][] visited, int[][] map, int x, int y) {
		//clockwise north first
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};

		if(x >= map[0].length || x < 0 ||
				y < 0 || y >= map.length) {
			return false;
		}
		
		if(map[y][x] == 0) {
			map[y][x] = 1;
			dfs_recursive(visited, map, x, y - 1);
			dfs_recursive(visited, map, x + 1, y);
			dfs_recursive(visited, map, x, y + 1);
			dfs_recursive(visited, map, x - 1, y);
			System.out.println("y = " + y + " , x = " + x);
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Solution_taewon_old solution = new Solution_taewon_old();
		int[][] map = {{0,0,1,1,0},
						{0,0,0,1,1},
						{1,1,1,1,1},
						{0,0,0,0,0},};
		int n = 4;
		int m = 5;

		System.out.println(solution.solution(map, n, m));
		System.out.println(count);
	}
}
