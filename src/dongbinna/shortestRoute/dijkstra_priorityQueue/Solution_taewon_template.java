package dongbinna.shortestRoute.dijkstra_priorityQueue;

import java.util.*;

public class Solution_taewon_template {

	/*
	 * 
	 */
	public Solution_taewon_template() {
		// TODO Auto-generated constructor stub
	}
	
	static class Node implements Comparable<Node> {

		@Override
		public int compareTo(Node other) {
			// TODO Auto-generated method stub
			//비용이 더 짧은 것이 높은 우선순위를 받는다 
			if(this.distance < other.distance) {
				return -1;
			}
			return 1;
		}
		
		private int index;
		private int distance;

		public Node(int index, int distance) {
			super();
			this.index = index;
			this.distance = distance;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}
		
	}
	
	public static final int INF = (int) 1e9;
	public static int n, m, start;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d = new int[10001];
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			
			Node node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			
			if(d[now] < dist) continue;
			
			for(int i = 0; i < graph.get(now).size(); i++) {
				
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		Solution_taewon_template solution = new Solution_taewon_template();

	}
}
