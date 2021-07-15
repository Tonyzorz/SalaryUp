package baekjoon._15_동적계획법1._9461파도반수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	
	public static long[] dp = new long[101];
    public static void main (String[] args) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int numCases = Integer.parseInt(br.readLine());
    	dp[0] = 1;
    	dp[1] = 1;
    	dp[2] = 1;
    	
    	for (int i = 0; i < numCases; i++) {
    		int place = Integer.parseInt(br.readLine());

    		for (int j = 3; j < place; j++) {
    			if (dp[j] == 0) {
    				dp[j] = dp[j - 2] + dp[j - 3];
    			}
    		}
    		
    		bw.write(String.valueOf(dp[place - 1]) + "\n");
    	}
    	
    	bw.flush();
    }
    
    
}
