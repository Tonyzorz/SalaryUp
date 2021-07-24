package dongbinna.graph_theory.kruskal;

import java.util.*;

public class Solution_taewon_template_programmers {

	/*
	 * 
	 */
	public Solution_taewon_template_programmers() {
		// TODO Auto-generated constructor stub
	}
	
	public static int v, e; //노드의 개수 v 와 간선(union 연산)의 개수(e)
	public static int[] parent = new int[100001];
	public static ArrayList<Edge> edges = new ArrayList<>(); //모든 간선을 담을 리스트
	public static int result = 0; //최종 비용을 담을 변수 
	
	//특정 원소가 속한 집합을 찾기
	public static int findParent(int x) {
		if (x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	//두 원소가 속한 집합을 합치기
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) {
		Solution_taewon_template_programmers solution = new Solution_taewon_template_programmers();
		
		v = 7;
		e = 9;
		
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}
		
		edges.add(new Edge(29, 1, 2));
		edges.add(new Edge(75, 1, 5));
		edges.add(new Edge(35, 2, 3));
		edges.add(new Edge(34, 2, 6));
		edges.add(new Edge(7, 3, 4));
		edges.add(new Edge(23, 4, 6));
		edges.add(new Edge(13, 4, 7));
		edges.add(new Edge(53, 5, 6));
		edges.add(new Edge(25, 6, 7));
		
		for (int i = 0; i < edges.size(); i++) {
			System.out.println(edges.get(i));
		}
		
		Collections.sort(edges);
		
		System.out.println();
		for (int i = 0; i < edges.size(); i++) {
			System.out.println(edges.get(i));
		}
		System.out.println();
		
		for (int i = 0; i < edges.size(); i++ ) {
			int cost = edges.get(i).getDistance();
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			
			if (findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += cost;
			}
		}
		
		System.out.println(result);
	}
}

/**
 * @author Yoon Taewon
 *
 */
class Edge implements Comparable<Edge> {

	private int distance;
	private int nodeA;
	private int nodeB;
	
	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}
	
	public int getDistance() {
		return distance;
	}


	public int getNodeA() {
		return nodeA;
	}


	public int getNodeB() {
		return nodeB;
	}

	@Override
	public int compareTo(Edge other) {
		// TODO Auto-generated method stub
		
		if (this.distance < other.distance) {
			return -1;
		}
		
		return 1;
	}

	@Override
	public String toString() {
		return "Edge [distance=" + distance + ", nodeA=" + nodeA + ", nodeB=" + nodeB + "]";
	}
	
	
}
