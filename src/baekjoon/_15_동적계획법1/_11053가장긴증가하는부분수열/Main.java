package baekjoon._15_동적계획법1._11053가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static int[] dp;
	public static int[] nums;
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	int A = sc.nextInt();
    	
    	dp = new int[A];
    	nums = new int[A];
    	
    	for (int i = 0; i < A; i++) {
    		nums[i] = sc.nextInt();
    	}
    	
    	//bottom-up 
    	//6
    	//10 20 10 30 20 50
    	for (int i = 0; i < A; i++) {
    		dp[i] = 1;
    		
    		for (int j = 0; j < i; j++) {
    			
    			if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
    				dp[i] = dp[j] + 1;
    			}
    		}
    		//System.out.println(Arrays.toString(dp));
    	}
    	
    	int max = 0;
    	for (int num : dp) {
    		max = num > max ? num : max;
    	}
    	System.out.println(max);
    }
    
}
