package baekjoon._15_동적계획법1._1003피보나치함수;

import java.io.*;
import java.util.*;

public class Main {
	
	public static Integer[][] dp = new Integer[41][2];
	
    public static void main (String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for (int i = 0; i < Integer.parseInt(br.readLine()); i++) {
			int num = Integer.parseInt(br.readLine());
			recursive(num);
			System.out.println(dp[num][0] + " " + dp[num][1]);
		}
		
		//System.out.println(Arrays.toString(testNums));
	
		
		//bw.write(" ");
		//bw.flush();
    }
    
    public static Integer[] recursive(int num) {
    	
    	if (dp[num][0] == null || dp[num][0] == null) {
    		dp[num][0] = recursive(num - 1)[0] + recursive(num - 2)[0];
    		dp[num][1] = recursive(num - 1)[1] + recursive(num - 2)[1];
    	}
    	
    	return dp[num];
    }
    
}
