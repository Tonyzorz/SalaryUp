package baekjoon._13백트래킹._9663NQueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/9663
	 * 
	 * N-Queen
		시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
		10 초	128 MB	46377	24135	15797	51.483%
		문제
		N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
		
		N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
		
		입력
		첫째 줄에 N이 주어진다. (1 ≤ N < 15)
		
		출력
		첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
		
		예제 입력 1 
		8
		예제 출력 1 
		92
	 */
	
	public static int N;
	public static int[] arr;
	public static int cnt = 0;
	
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	arr = new int[N];
    	nQueen(0);
    	System.out.println(cnt);
    }
    
    public static void nQueen(int depth) {
    	
    	if (depth == N) {
    		cnt++;
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
    		arr[depth] = i;
    		
    		if (possibility(depth)) {
    			nQueen(depth + 1);
    		}
    	}
    }
    
    public static boolean possibility(int col) {
    	
    	for (int i = 0; i < col; i++) {
    		
    		if (arr[col] == arr[i]) {
    			return false;
    		}
    		
    		if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
    			return false;
    		}
    	}
    	return true;
    }
    
    

    

}
