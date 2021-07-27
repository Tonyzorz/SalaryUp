package baekjoon._9기본수학2._2581소수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/1978
	 * 
	 * 문제
		주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
	 */
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	int start = sc.nextInt();
    	int end = sc.nextInt();
    	
    	boolean[] isPrime = new boolean[10001];
    	Arrays.fill(isPrime, true);
    	isPrime[0] = false;
    	isPrime[1] = false;
    	
    	for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
    		if (isPrime[i]) {
    			for (int j = i * i; j < isPrime.length; j += i) {
    				isPrime[j] = false;
    			}
    		}
    	}
    	
    	ArrayList<Integer> primes = new ArrayList<Integer>();
    	int total = 0;
    	
    	for (int i = start; i <= end; i++) {
    		if (isPrime[i]) {
    			primes.add(i);
    			total += i;
    		}
    	}
    	
    	if (total != 0) {
    		System.out.println(total + "\n" + primes.get(0));
    	} else {
    		System.out.println(-1);
    	}
    }
    
}
