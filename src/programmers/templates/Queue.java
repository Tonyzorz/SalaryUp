package programmers.templates;

public class Queue<T> {
	
	//FIFO
	/*
	 * add()
	 * remove()
	 * peek()
	 * isEmpty()
	 */
	
	private Node<T> first;
	private Node<T> last;
	
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}

	public void add(T data) {
		
		Node<T> n = new Node(data);
		
		if(last != null) {
			last.next = n;
		}
		last = n;
		if(first == null) {
			first = last;
		} 
//		else {
//			
//			Node<T> search = first;
//			while(search.next != null) {
//				search = search.next;
//			}
//			search.next = n;
//			last = n;
//			
//		}
	}
	
	public T remove() {
		
		T data = first.data;
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		
		return data;
		
	}
	
	public T peek() {
		
		return first.data;
	}
	
	public boolean isEmpty() {
		
		if(first != null) {
			return false;
		}
		return true;
	}
	public Queue() {
		// TODO Auto-generated constructor stub
	}

}
