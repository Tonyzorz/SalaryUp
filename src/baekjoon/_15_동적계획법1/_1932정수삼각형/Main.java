package baekjoon._15_동적계획법1._1932정수삼각형;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	
	public static int[][] arr;
	public static int[][] dp;
    public static void main (String[] args) throws NumberFormatException, IOException{
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	arr = new int[N][N];
    	dp = new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < i + 1; j++) {
    			arr[i][j] = sc.nextInt();
    		}
    	}
    	
    	for (int i = 0; i < N; i++) {
    		System.out.println(Arrays.toString(arr[i]));
    	}
    	
    	for (int i = 0; i < N; i++) {
    		dp[N - 1][i] = arr[N - 1][i];
    	}
    	
    	System.out.println(recursive(0, 0));
    }
    
    public static int recursive(int depth, int index) {
    	
    	if (depth == dp[0].length  - 1) return dp[depth][index];
    	
    	if (dp[depth][index] == 0) {
    		dp[depth][index] = Math.max(recursive(depth + 1 ,index) , recursive(depth + 1, index + 1)) + arr[depth][index];
    	}
    	
    	return dp[depth][index];
    }
    
}
