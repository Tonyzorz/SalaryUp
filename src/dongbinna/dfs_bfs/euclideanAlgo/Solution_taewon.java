package dongbinna.dfs_bfs.euclideanAlgo;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int euclidean(int a, int b) {
		
		if(a % b == 0) return b;
		return euclidean(b, a % b);
	}
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int a = 192;
		int b = 162;
		System.out.println(solution.euclidean(a, b));
	}
}
