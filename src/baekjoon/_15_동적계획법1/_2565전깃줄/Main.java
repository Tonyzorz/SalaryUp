package baekjoon._15_동적계획법1._2565전깃줄;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static int[] dp;
	public static int[][] wires;
	
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);

    	int n = sc.nextInt();
    	dp = new int[n];
    	wires = new int[n][2];
    	
    	for (int i = 0; i < n; i++) {
    		wires[i][0] = sc.nextInt();
    		wires[i][1] = sc.nextInt();
    	}

//    	for (int i = 0; i < n; i++) {
//    		System.out.println(Arrays.toString(wires[i]));
//    	}
    	
    	Arrays.sort(wires, new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				return arg0[0] - arg1[0];
			}
    		
    	});
    	
//    	System.out.println();
//    	
//    	for (int i = 0; i < n; i++) {
//    		System.out.println(Arrays.toString(wires[i]));
//    	}
    	
    	///
    	
//    	for (int i = 0; i < n; i++) {
//    		recursive(i);
//    	}
    	
    	for (int i = 0; i < n; i++) {
    		
    		dp[i] = 1;
    		
    		for (int j = 0; j < i; j++) {
    			
    			if (wires[i][1] > wires[j][1] && dp[i] < dp[j] + 1) {
    				dp[i] = dp[j] + 1;
    			}
    		}
    	}
    	//System.out.println(Arrays.toString(dp));
    	
    	Arrays.sort(dp);
    	//System.out.println(Arrays.toString(dp));
    	System.out.println(n - dp[dp.length - 1]);
    }
    
    public static int recursive(int place) {
    	
    	if (dp[place] == 0) {
    		
    		dp[place] = 1;
    		
    		for (int i = place + 1; i < dp.length; i++) {
    			
    			if (wires[place][1] < wires[i][1]) {
    				dp[place] = Math.max(dp[place], recursive(i) + 1);
    			}
    		}
    	}
    	
    	return dp[place];
    }
    
}
