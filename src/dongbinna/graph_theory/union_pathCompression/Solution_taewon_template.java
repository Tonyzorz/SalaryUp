package dongbinna.graph_theory.union_pathCompression;

import java.util.*;

public class Solution_taewon_template {

	/*
	 * 
	 */
	public Solution_taewon_template() {
		// TODO Auto-generated constructor stub
	}
	
	public static int v, e;
	public static int[] parent = new int[10];
	
	public static int findParent(int x) {
		
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) {
		Solution_taewon_template solution = new Solution_taewon_template();
		
		//union 1,4
		//union 2,3
		//union 5,6
		//union 2,4
		
		for(int i = 1; i <= 6; i++) {
			parent[i] = i;
		}
		
		unionParent(1,4);
		unionParent(2,3);
		unionParent(5,6);
		unionParent(2,4);
		
		System.out.println(Arrays.toString(parent));
	}
}
