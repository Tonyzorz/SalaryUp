package baekjoon._18스택._10828스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/10828
	 * 
	 * 스택
		시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
		0.5 초 (추가 시간 없음)	256 MB	111566	42485	30621	38.471%
		문제
		정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
		
		명령은 총 다섯 가지이다.
		
		push X: 정수 X를 스택에 넣는 연산이다.
		pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		size: 스택에 들어있는 정수의 개수를 출력한다.
		empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
		top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		입력
		첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
		
		출력
		출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
		
		예제 입력 1 
		14
		push 1
		push 2
		top
		size
		empty
		pop
		pop
		pop
		size
		empty
		pop
		push 3
		empty
		top
		예제 출력 1 
		2
		2
		0
		2
		1
		-1
		0
		1
		-1
		0
		3
		예제 입력 2 
		7
		pop
		top
		push 123
		top
		pop
		top
		pop
		예제 출력 2 
		-1
		-1
		123
		123
		-1
		-1
	 */
    public static void main (String[] args) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);

    	//Stack<Integer> stack = new Stack<Integer>();
    	int cases = Integer.parseInt(br.readLine());
    	StackTaewon<Integer> stack = new StackTaewon<Integer>();
    	
    	for (int i = 0; i < cases; i++) {
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String method = st.nextToken();
    		int num = 0;
    		
    		if (method.equals("push")) {
    			num = Integer.parseInt(st.nextToken());
    		}
    		
    		switch (method) {
    			case "push" : 
    				stack.push(num);
    				break;
    				
    			case "pop" :
    				if (stack.empty()) {
    					bw.append("-1\n");
    				} else {
    					bw.append(String.valueOf(stack.pop()) + "\n");
    				}
    				break;
    				
    			case "size" :
    				bw.append(String.valueOf(stack.size()) + "\n");
    				break;
    				
    			case "empty" :
    				bw.append(stack.empty() ? "1\n" : "0\n");
    				break;
    				
    			case "top" : 
    				bw.append(String.valueOf(stack.peek()) + "\n");
    				break;
    		}
    		
    	}
    	
    	bw.flush();
    }
    
    public interface StackInterface<E> {

    	E push(E item);
    	
    	E pop();
    	
    	E peek();
    	
    	int search(Object value);
    	
    	int size();
    	
    	void clear();
    	
    	boolean empty();
    	
    }
    
    public static class StackTaewon<E> implements StackInterface<E>{

    	private static final int DEFAULT_CAPACITY = 10;
    	private final Object[] EMPTY_ARRAY = {};
    	
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


}

