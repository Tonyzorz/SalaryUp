package baekjoon._15_동적계획법1._2156포도주시식;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int[] wines = new int[n + 1];
    	int[] dp = new int[n + 1];
    	
    	for (int i = 1; i <= n; i++) {
    		wines[i] = sc.nextInt();
    	}
    	
    	dp[1] = wines[1];
    	//System.out.println(Arrays.toString(wines));
    	if (n >= 2) {
    		dp[2] = wines[1] + wines[2];
    	}
    	
    	for (int i = 3; i <= n; i++) {
    		dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + wines[i - 1]) + wines[i]);
    		System.out.println("i = " + i + " " + Arrays.toString(dp));
    	}
    	//System.out.println(Arrays.toString(dp));
    	System.out.println(dp[n]);
    }
    
}
