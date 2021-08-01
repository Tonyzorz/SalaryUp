package baekjoon._9기본수학2._4948베르트랑공준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/4948
	 * 
	 * 문제
		베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
		
		이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
		
		예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
		
		자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오. 
		
		입력
		입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다.
		
		입력의 마지막에는 0이 주어진다.
		
		출력
		각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
		
		제한
		1 ≤ n ≤ 123,456
	 */
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	boolean[] isPrime = new boolean[250000];
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
    	//System.out.println(Arrays.toString(isPrime));
    	int num = 0;
    	while ((num = sc.nextInt()) != 0) {
    		if (num == 1) {
    			System.out.println(1);
    			continue;
    		}
    		
    		int primes = 0;
    		for (int i = num + 1; i <= 2 * num; i++) {
    			if (isPrime[i]) {
    				primes++;
    			}
    		}
    		
    		System.out.println(primes);
    	}
    }
    
}
