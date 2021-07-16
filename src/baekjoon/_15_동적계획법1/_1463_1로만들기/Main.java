package baekjoon._15_동적계획법1._1463_1로만들기;

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

    	int num = sc.nextInt();
    	
    	dp = new int[num + 1];
    	
    	//1로 만드니까 1은 무시
    	for (int i = 2; i <= num; i++) {
    		
    		dp[i] = dp[i - 1] + 1;
    		if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
    		if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
   			//System.out.println(Arrays.toString(dp));
    	}
    	
    	System.out.println(dp[num]);
    }
    
}
