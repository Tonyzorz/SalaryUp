package programmers.templates;

import java.util.ArrayList;

public class MaxHeap {

	/*
	 * - 배열  필요, 유동적인 
	 * - print
	 * - insert O(log n)
	 * - delete  O(log n)
	 * - get O(1)
	 * 좌측은 +1, 
	 * 우측은 +2, 
	 * parent node는  현 - 1 /2 
	 * 
	 */
	
	private ArrayList<Integer> heap;
	
	public MaxHeap() {
		heap = new ArrayList<>();
		heap.add(Integer.MAX_VALUE);
	}
	
	public void print() {
		for(int i = 0; i < heap.size(); i++) {
			System.out.print(heap.get(i) + " ");
		}
		System.out.println();
	}
	
	public void insert(int val) {
		heap.add(val);
		int p = heap.size() - 1;
		
		//안에  3개부터 
		while(p > 1 && heap.get(p / 2) < heap.get(p)) {
			
			int temp = heap.get(p/2);
			heap.set(p/2, heap.get(p));
			heap.set(p, temp);
			
			p = p/2;
		}
	}
	
	public int delete() {
		
		if(heap.size() - 1 < 1) {
			return 0;
		}
		
		int deletedItem = heap.get(1);
		
		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		
		int pos = 1;
		while((pos * 2) < heap.size()) {
			
			int max = heap.get(pos * 2);
			int maxPos = pos * 2;
				//3  < max size    &&    2의 값 = 2 < 3  =  3의 값 
			if(((pos * 2 + 1) < heap.size()) && max < heap.get(pos * 2 + 1)) {
				
			}
		}
		
		return deletedItem;
	}
	
	

}
