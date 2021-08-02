package baekjoon._12정렬._10989수정렬하기3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/10989
	 * 
	 * 수 정렬하기 3 실패
		시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
		3 초 (하단 참고)	8 MB (하단 참고)	115878	24236	18633	23.027%
		문제
		N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
		
		입력
		첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
		
		출력
		첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
		
		예제 입력 1 
		10
		5
		2
		3
		1
		4
		2
		3
		5
		1
		7
		예제 출력 1 
		1
		1
		2
		2
		3
		3
		4
		5
		5
		7
	 */
    public static void main (String[] args) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	int cases = Integer.parseInt(br.readLine());
    	/*int[] numbers = new int[cases];
    	
    	for (int i = 0; i < cases; i++) {
    		numbers[i] = Integer.parseInt(br.readLine());
    	}
    	
    	Arrays.sort(numbers);
    	
    	for (int num : numbers) {
    		bw.write(num + "\n");
    	}
    	
    	bw.flush();*/
    	
    	int[] numbers = new int[10001];
    	
    	for (int i = 0; i < cases; i++) {
    		numbers[Integer.parseInt(br.readLine())]++;
    	}
    	
    	for (int i = 0; i < numbers.length; i++) {
    		
    		while (numbers[i] > 0) {
    			numbers[i]--;
    			bw.write(i + "\n");
    		}
    	}
    	
    	bw.flush();

    }
    
}
