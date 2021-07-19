package baekjoon._15_동적계획법1._11054가장긴바이토닉부분수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static int[] dp_asc;
	public static int[] dp_desc;
	public static int[] arr;
	
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);

    	int A = sc.nextInt();
    	dp_asc = new int[A];
    	dp_desc = new int[A];
    	arr = new int[A];
    	
    	for (int i = 0; i < A; i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	for (int i = 0; i < A; i++) {
    		dp_asc[i] = 1;

    		for (int j = 0; j < i; j++) {
    			if (arr[i] > arr[j] && dp_asc[i] < dp_asc[j] + 1) {
    				dp_asc[i] = dp_asc[j] + 1;
    			}
    		}
    		//System.out.println(Arrays.toString(dp_asc));
    	}
    	//System.out.println();
    	for (int i = A - 1; i >= 0; i--) {
    		dp_desc[i] = 1;
    		
    		for (int j = A - 1; j > i; j--) {
    			if (arr[i] > arr[j] && dp_desc[i] < dp_desc[j] + 1) {
    				dp_desc[i] = dp_desc[j] + 1;
    			}
    		}
    		//System.out.println(Arrays.toString(dp_desc));
    	}
    	
    	int max = 0;
    	for (int i = 0; i < A; i++) {
    		max = dp_asc[i] + dp_desc[i] - 1 > max ? dp_asc[i] + dp_desc[i] - 1 : max;
    	}
    	
    	System.out.println(max);
    }
    
}
