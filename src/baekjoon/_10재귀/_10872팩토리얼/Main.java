package baekjoon._10재귀._10872팩토리얼;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/10872
	 * 
	 * 문제
		0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
		
		입력
		첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.
		
		출력
		첫째 줄에 N!을 출력한다.
	 */
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);

    	int N = sc.nextInt();
    	System.out.println(recursive(N));
    }
    
    public static int recursive(int N) {
    	if (N == 1 || N == 0) {
    		return 1;
    	}
    	
    	return N * recursive(N - 1);
    }
    
}
