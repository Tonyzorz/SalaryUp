package baekjoon._18스택._17298오큰수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/17298
	 * 
	 * 오큰수
		시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
		1 초	512 MB	19024	6497	4777	34.148%
		문제
		크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.
		
		예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
		
		입력
		첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.
		
		출력
		총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.
		
		예제 입력 1 
		4
		3 5 2 7
		예제 출력 1 
		5 7 7 -1
		예제 입력 2 
		4
		9 5 4 8
		예제 출력 2 
		-1 8 8 -1
	 */
    public static void main (String[] args) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);

    	int size = Integer.parseInt(br.readLine());
    	
    	int[] numbers = new int[size];
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> results = new Stack<Integer>();
    	
    	String[] numStrs = br.readLine().split(" ");
    	
    	for (int i = 0; i < size; i++) {
    		numbers[i] = Integer.parseInt(numStrs[i]);
    		stack.add(Integer.parseInt(numStrs[i]));
    	}
    	
    	int biggest = 0;
    	int previous = 0;
    	int temp = 0;
    	while(!stack.isEmpty()) {
    		
    		if (biggest == 0) {
    			biggest = stack.pop();
    			results.add(-1);
    			continue;
    		}

    		if (stack.peek() < biggest) {
    			previous = stack.pop();
    			
    			if (!stack.isEmpty() && previous < temp) {
    				results.add(temp);
    				
    			} else {
    				results.add(biggest);
    				
    			}
    			
    			temp = previous;
    			continue;
    		} else {
    			stack.pop();
    			results.add(-1);
    		}
    		
    	}
    	
    	while(!results.isEmpty()) {
    		System.out.print(results.pop() + " ");
    	}
    	
    	
    }
    
}
