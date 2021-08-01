package baekjoon._10재귀._10870피보나치수5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/10870
	 * 문제
		피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
		
		이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
		
		n=17일때 까지 피보나치 수를 써보면 다음과 같다.
		
		0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
		
		n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
		
		입력
		첫째 줄에 n이 주어진다. n은 20보다 작거나 같은 자연수 또는 0이다.
		
		출력
		첫째 줄에 n번째 피보나치 수를 출력한다.
	 */
	public static int[] dp;
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	//System.out.println(recursive(n));
    
    	dp = new int[21];
    	dp[1] = 1;
    	dp[2] = 1;
    	for (int i = 3; i <= n; i++) {
    		dp[i] = dp[i - 1] + dp[i - 2];
    	}
    	
    	System.out.println(dp[n]);
    }
 
    public static int recursive(int n) {
    	if (n == 2 || n == 1) {
    		return 1;
    	}
    	
    	return recursive(n - 1) + recursive(n - 2);
    }
}
