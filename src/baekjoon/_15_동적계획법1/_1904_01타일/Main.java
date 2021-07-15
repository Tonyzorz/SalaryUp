package baekjoon._15_동적계획법1._1904_01타일;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static long[] dp = new long[1000001];
    public static void main (String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        		
        int tileNum = Integer.parseInt(br.readLine());
        
        for (int i = 3; i <= tileNum; i++) {
        	dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        
        System.out.println(dp[tileNum]);
    }
    
}
