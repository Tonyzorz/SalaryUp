package interview.chocolateEnt_2021_06;

import java.util.*;

public class Solution_taewon_linkedlist {

	/*
	 * 
	 */
	public Solution_taewon_linkedlist() {
		// TODO Auto-generated constructor stub
	}
	
	public LinkedListNode condense(LinkedListNode head) {
		LinkedListNode answer = new LinkedListNode();
		
	
		return answer;
	}
	
	public static void main(String[] args) {
		Solution_taewon_linkedlist solution = new Solution_taewon_linkedlist();
		String str = "11111";
		/*
		 * 10100 2
		 * 01010 4
		 * 010 0
		 * 11111 6 
		 */
		
		int size = 8;
		LinkedListNode sample = new LinkedListNode();
		
		
		System.out.println(solution.condense(str));
	}
	
	class LinkedListNode {
		int data;
		LinkedListNode next = null;
		
		public LinkedListNode() {
			// TODO Auto-generated constructor stub
		}
		
		public LinkedListNode(int data, LinkedListNode next) {
			this.data = data;
			this.next = next;
		}
		
	}
}
