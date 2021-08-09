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
		10 초	128 MB	43894	23063	15098	51.942%
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
	public static int[] arr;
	public static int N;
	public static int count = 0;
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N];
 
		nQueen(0);
		System.out.println(count);
 
	}
 
	public static void nQueen(int depth) {
		// 모든 원소를 다 채운 상태면 count 증가 및 return 
		if (depth == N) {
			count++;
			System.out.println("it counted + ===  " + count);
			return;
		}
 
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			System.out.println(Arrays.toString(arr) + "  depth = " + depth);
			// 놓을 수 있는 위치일 경우 재귀호출
			if (Possibility(depth)) {
				System.out.println("recursive");
				nQueen(depth + 1);
			}
		}
 
	}
 
	public static boolean Possibility(int col) {
		
		for (int i = 0; i < col; i++) {
			// 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우) 
			if (arr[col] == arr[i]) {
				System.out.println("1111111111111111111col = " + col + " , i  =" + i + " , Arrr" + Arrays.toString(arr));
				return false;
			} 
			
			/*
			 * 대각선상에 놓여있는 경우
			 * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
			 */
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				System.out.println("22222222222222222col = " + col + " , i  =" + i + " , Arrr" + Arrays.toString(arr));
				return false;
			}
		}
		
		return true;
	}
    
}
