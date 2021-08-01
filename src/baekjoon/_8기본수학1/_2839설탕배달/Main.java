package baekjoon._8기본수학1._2839설탕배달;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	int sugars = sc.nextInt();
    	
    	if (sugars < 5) {
    		System.out.println(sugars % 3 == 0 ? 1 : -1);
    		return;
    	}
    	
    	int[] dp = new int[sugars + 1];
    	Arrays.fill(dp, 9999);
    	dp[3] = 1;
    	dp[5] = 1;
    	for (int i = 6; i <= sugars; i++) {
    		
    		dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
    	}
    	
    	//System.out.println(Arrays.toString(dp));
    	if (dp[sugars] < 9999) {
    		System.out.println(dp[sugars]);
    	} else {
    		System.out.println(-1);
    	}
    	
//    	for (int i = 6; i <= sugars; i++) {
//    		
//    		dp[i] = dp[i - 1] + 1;
//    		if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
//    		if (i % 5 == 0) dp[i] = Math.min(dp[i], dp[i/5] + 1);
//    		System.out.println(Arrays.toString(dp));
//    	}
//    	
//    	System.out.println(dp[sugars]);
    	
    	
    	//greedy logic based, didnt think enough 
//    	int bags = 0;
//    	while (sugars >= 2) {
//    		if (sugars % 5 == 0) {
//    			bags += sugars / 5;
//    			sugars = 0;
//    			break;
//    		} else {
//    			sugars -= 3;
//    			bags++;
//    		}
//    		
//    	}
//    	
//    	System.out.println(sugars == 0 ? bags : -1);
    }
    
}
