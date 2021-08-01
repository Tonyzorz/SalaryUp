package baekjoon._8기본수학1._2775부녀회장이될테야;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 *  평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.
		이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.
		아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 
		단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
	 
	 *  2
		1
		3
		2
		3
		
		6
		10
		
	 */
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	int cases = sc.nextInt();
    	dp = new int[15][15];
    	
    	for (int i = 0; i < dp.length; i++) {
    		dp[0][i] = i;
    		dp[i][1] = 1;
    	}
    	
    	
    	for (int j = 1; j < dp.length; j++) {
			
			for (int z = 2; z < dp.length; z++) {
				
				dp[j][z] = dp[j - 1][z] + dp[j][z - 1];
			}
			
			
		}
    	
//    	for (int i = 0; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//    	}
    	
    	for (int i = 0; i < cases; i++) {
    		
    		int floor = sc.nextInt();
    		int room = sc.nextInt();
    		
    		//System.out.println(fibo(floor, room));
    		System.out.println(dp[floor][room]);
    		
    	}
    	
    	
    }
    
    public static int[][] dp;
    public static int fibo(int floor, int room) {
    	
    	if (floor == 0) return room;
    	else if (room <= 1) return 1;
    	return fibo(floor - 1, room) + fibo(floor, room - 1);
    }
    
}
