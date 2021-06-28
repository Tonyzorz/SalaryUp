package dongbinna.shortestRoute.dijskstra;

import java.util.*;

public class Solution_taewon_template {

	public static class Node {
		
		private int index;
		private int distance;
		
		public Node(int index, int distance) {
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
	
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static boolean[] visited = new boolean[100];
	public static int[] d = new int[100];
	
	public static void dijskstra(int start) {
		
		d[start] = 0;
		visited[start] = true;
		
		for(int i = 0; i < graph.get(start).size(); i++) {
			d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
		}
		
		for(int i = 0; i < graph.size() - 1; i++) {
			int now = getSmallestNode();
			System.out.println("now = " + now);
			visited[now] = true;
			
			for(int j = 0; j < graph.get(now).size(); j++) {
				
				int cost = d[now] + graph.get(now).get(j).getDistance();
				if(cost <  d[graph.get(now).get(j).getIndex()]) {
					 d[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}

	public static int getSmallestNode() {
		
		int index = 0;
		int smallest = Integer.MAX_VALUE;
		
		for(int i = 1; i <= graph.size(); i++) {
			
			if(d[i] < smallest && !visited[i]) {
				smallest = d[i];
				index = i;
			}
		}
		
		return index;
	}
	public static void main(String[] args) {
		
		//example has 6 nodes 
		int nodes = 6;
		for(int i = 0; i <= nodes; i++) {
			graph.add(new ArrayList<Node>());
		}
		System.out.println(graph.size());
		Arrays.fill(d, Integer.MAX_VALUE);
		graph.get(1).add(new Node(2, 2));
       	graph.get(1).add(new Node(3, 5));
       	graph.get(1).add(new Node(4, 1));
       	
       	graph.get(2).add(new Node(3, 3));
       	graph.get(2).add(new Node(4, 2));
       	
       	graph.get(3).add(new Node(2, 3));
       	graph.get(3).add(new Node(6, 5));
       	
       	graph.get(4).add(new Node(5, 1));
       	graph.get(4).add(new Node(3, 3));
       	
       	graph.get(5).add(new Node(6, 2));
       	graph.get(5).add(new Node(6, 2));
       	
       	dijskstra(1);
       	
       	for(int i = 1; i <= nodes; i++) {
       		if (d[i] == Integer.MAX_VALUE) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
       	}
	}
}
