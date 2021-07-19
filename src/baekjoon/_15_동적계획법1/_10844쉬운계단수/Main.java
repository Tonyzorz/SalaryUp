package baekjoon._15_동적계획법1._10844쉬운계단수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	
	public static Long[][] dp;
	public static final int MOD = 1000000000;
	
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	dp = new Long[N + 1][10];
    	
    	for (int i = 0; i < 10; i++) {
    		dp[1][i] = 1L;
    	}
    	
    	long answer = 0;
    	
    	for (int i = 1; i <= 9; i++) {
    		answer += recursive(N, i);
    	}
    	
    	System.out.println(answer % MOD);
    	
    	
    	
    	//bottom-up
//    	for (int i = 2; i <= N; i++) {
//    		
//    		for (int j = 0; j <= 9; j++) {
//    			
//    			//same info as top-down 
//    		}
//    	}
    }
    
    //top-down 
    public static long recursive(int place, int value) {
    	
    	if (place == 1) return dp[place][value]; 

    	if (dp[place][value] == null) {
    		
    		if (value == 0) {
    			dp[place][value] = recursive(place - 1, 1);
    		} else if (value == 9) {
    			dp[place][value] = recursive(place - 1, 8);
    		} else {
    			dp[place][value] = recursive(place - 1, value - 1) + recursive(place - 1, value + 1);
    		}
    	
    	}
    	
    	return dp[place][value] % MOD;
    }
    
}
