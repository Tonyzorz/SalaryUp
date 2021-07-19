package baekjoon._10재귀._10870피보나치수5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static int[] dp;
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	System.out.println(recursive(n));
    
//    	dp = new int[n + 1];
//    	dp[1] = 1;
//    	dp[2] = 1;
//    	for (int i = 3; i <= n; i++) {
//    		dp[i] = dp[i - 1] + dp[i - 2];
//    	}
//    	
//    	System.out.println(dp[n]);
    }
 
    public static int recursive(int n) {
    	if (n == 2 || n == 1) {
    		return 1;
    	}
    	
    	return recursive(n - 1) + recursive(n - 2);
    }
}
