package programmers.templates;

public class LinkedList {

	Node head;
	Node tail; 
	
	class Node{
		Object value;
		Node next;
	
		public Node(Object value) {
			this.value = value;
		}
	}

	/*
	 * add
	 * addFirst
	 * addLast
	 * 
	 * clear
	 * contains
	 * get
	 * getFirst
	 * getLast
	 * indexOf
	 * lastIndexOf
	 * 
	 * peek
	 * peekList
	 * peekLast
	 * 
	 * poll
	 * pollFirst
	 * pollLast
	 * 
	 * remove
	 * remove int index 
	 * removeFirst
	 * removeLast
	 * 
	 * set int index / element 
	 * Object[] toArray()
	 * 
	 * size
	 * 
	 */
	
	public void add(Object value) {
		if(head == null) {
			Node n = new Node(value);
			head = n;
			tail = n;
		} else {
			Node n = new Node(value);
			tail.next = n;
			tail = n;
		}
	}
	
	public void add(int index, Object value) {
		Node after = get(index);
		Node before = get(index - 1);
		Node n = new Node(value);
		
		before.next = n;
		n.next = after;
		
	}
	
	public Node get(int index) {
		
		Node n = head;
		
		for(int i = 0; i < index; i++) {
			
			if(n == null) {
				
				break;
			}
			
			n = n.next;
		}
		
		return n;
		
	}
	public LinkedList() {
		// TODO Auto-generated constructor stub
	}
}
