package baekjoon._12정렬._2750수정렬하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/2750
	 * 
	 * 수 정렬하기 성공
		시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
		1 초	128 MB	90045	51094	35440	58.328%
		문제
		N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
		
		입력
		첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
		
		출력
		첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
		
		예제 입력 1 
		5
		5
		2
		3
		4
		1
		예제 출력 1 
		1
		2
		3
		4
		5
	 */
    public static void main (String[] args) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	int cases = Integer.parseInt(br.readLine());
    	int[] numbers = new int[cases];
    	
    	for (int i = 0; i < cases; i++) {
    		numbers[i] = Integer.parseInt(br.readLine());
    	}
    	
    	Arrays.sort(numbers);
    	
    	for (int num : numbers) {
    		bw.write(num + "\n");
    	}
    	
    	bw.flush();
    }
    
}
