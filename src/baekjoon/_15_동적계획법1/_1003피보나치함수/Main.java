package baekjoon._15_동적계획법1._1003피보나치함수;

import java.io.*;
import java.util.*;

public class Main {
	
    public static void main (String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int testCase = Integer.parseInt(br.readLine());
		int[] testNums = new int[testCase];
		
		for (int i = 0; i < testCase; i++) {
			testNums[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(Arrays.toString(testNums));
		bw.write(" ");
		bw.flush();
    }
    
}
