package baekjoon._9기본수학2._1929소수구하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/1929
	 * 
	 * 문제
		M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
		
		입력
		첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
		
		출력
		한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
	 */
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	int start = sc.nextInt();
    	int end = sc.nextInt();
    	
    	boolean[] isPrime = new boolean[end + 1];
    	Arrays.fill(isPrime, true);
    	isPrime[0] = false;
    	isPrime[1] = false;
    			
    	for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
    		if (isPrime[2]) {
    			for (int j = i * i; j < isPrime.length; j += i) {
    				isPrime[j] = false;
    			}
    		}
    	}
    	
    	for (int i = start; i <= end; i++) {
    		if (isPrime[i]) {
    			System.out.println(i);
    		}
    	}
    }
    
}
