package templates.stack;

import java.util.Arrays;

public class StackTaewon<E> implements StackInterface<E>{

	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ARRAY = {};
	
	private Object[] array;
	private int size;
	
	public StackTaewon() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}

	public StackTaewon(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}
	
	private void resize() {
		
		if (Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
		
		int arrayCapacity = array.length;
		
		if (size == arrayCapacity) {
			int newSize = arrayCapacity * 2;
			
			array = Arrays.copyOf(array, newSize);
			return;
		}
		
		if (size < (arrayCapacity / 2)) {
			
			int newCapacity = arrayCapacity / 2;
			
			array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
			return;
		}
	}
	
	@Override
	public E push(E item) {

		if (size == array.length) {
			resize();
		}
		
		array[size] = item;
		size++;
		
		return item;
	}

	@Override
	public E pop() {
		
		if (size == 0) {
			Object e = -1;
			return (E) e;
		}
		
		E obj = (E) array[size - 1];
		array[size - 1] = null;
		size--;
		resize();
		
		return obj;
	}

	@Override
	public E peek() {
		
		if (size == 0) {
			Object e = -1;
			return (E) e;
		}
		
		return (E) array[size - 1];
	}

	@Override
	public int search(Object value) {
		
		for (int idx = size - 1; idx >= 0; idx--) {
			
			if (array[idx].equals(value)) {
				return size - idx;
			}
		}
		
		return -1;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
		resize();
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

}
