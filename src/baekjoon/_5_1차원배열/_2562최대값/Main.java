package baekjoon._5_1차원배열._2562최대값;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);

    	int[][] arr = new int[9][2];
    	
    	for (int i = 0; i < 9; i++) {
    		arr[i][0] = sc.nextInt();
    		arr[i][1] = i + 1;
    	}
    	
//    	for (int i = 0; i < 9; i++) {
//    		System.out.println(Arrays.toString(arr[i]));
//    	}
    	
    	Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
    		
    	});
    
//    	System.out.println();
//    	for (int i = 0; i < 9; i++) {
//    		System.out.println(Arrays.toString(arr[i]));
//    	}
    	
    	System.out.println(arr[8][0] + "\n" + arr[8][1]);
    }
    
}
