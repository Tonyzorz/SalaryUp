package dongbinna.graph_theory.topological_sort;

import java.util.*;

public class Solution_taewon_template_programmers {

	/*
	 * 
	 */
	public Solution_taewon_template_programmers() {
		// TODO Auto-generated constructor stub
	}
	
	public static int v, e; // v = 노드의 개수, e = 간선의 개수 
	public static int[] indegree = new int[100001]; //모든 노드에 대한 진입차수는 0으로 초기화 
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	//위상 정렬 함수 
	public static void topologySort() {
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= v; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int now = q.poll();
			result.add(now);
			
			for (int i = 0; i < graph.get(now).size(); i++) {
				indegree[graph.get(now).get(i)]--;
				
				if (indegree[graph.get(now).get(i)] == 0) {
					q.offer(graph.get(now).get(i));
				}
				
			}
		}
		
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
	
	public static void main(String[] args) {
		Solution_taewon_template_programmers solution = new Solution_taewon_template_programmers();
		
		v = 8;
		e = 9;
		
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		graph.get(7).add(8);
		graph.get(1).add(2);
		graph.get(1).add(5);
		graph.get(2).add(3);
		graph.get(2).add(6);
		graph.get(3).add(4);
		graph.get(4).add(7);
		graph.get(5).add(6);
		graph.get(6).add(4);
		
		for (int i = 1; i <= v; i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				indegree[graph.get(i).get(j)]++;
			}
		}
		
		topologySort();
	}
}
