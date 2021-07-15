package baekjoon._15_동적계획법1._2579계단오르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main (String[] args) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int size = Integer.parseInt(br.readLine());
    	int[] steps = new int[size + 1];
    	int[] dp = new int[size + 1];
    	
    	for (int i = 1; i <= size; i++) {
    		steps[i] = Integer.parseInt(br.readLine());
    	}
    	//System.out.println(Arrays.toString(steps));
    	dp[1] = steps[1];
    	
    	if (size >= 2) {
    		dp[2] = steps[1] + steps[2]; 
    	}
    	
    	for (int i = 3; i <= size; i++) {
    		dp[i] = Math.max(dp[i - 2], dp[i - 3] + steps[i - 1]) + steps[i];
    	}
    	//System.out.println(Arrays.toString(dp));

    	System.out.println(dp[size]);
    }
    
}
