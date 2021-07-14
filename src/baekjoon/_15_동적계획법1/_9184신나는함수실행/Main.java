package baekjoon._15_동적계획법1._9184신나는함수실행;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static int[][][] dp = new int[21][21][21];
    public static void main (String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
//    	String[] split = br.readLine().split(" ");
//    	System.out.println(Arrays.toString(split));
//    	int a = Integer.parseInt(split[0]);
//    	int b = Integer.parseInt(split[1]);
//    	int c = Integer.parseInt(split[2]);
    	
    	while (true) {
    		
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	
    		if (a == -1 && b == -1 && c == -1) {
    			break;
    		} 
    		
			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
    	}
    	
    }
    
    public static int w(int a, int b, int c) {
    	
    	if (a <= 0 || b <= 0 || c <= 0) {
    		return 1;
    	}

    	if (a > 20 || b > 20 || c > 20) {
    		return w(20, 20, 20);
    	}

    	if (dp[a][b][c] != 0) {
    		return dp[a][b][c];
    	}
    	
    	if (a < b && b < c) {
    		dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
    		return dp[a][b][c];
    	}
    	
    	dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    	return dp[a][b][c];
    }
}
