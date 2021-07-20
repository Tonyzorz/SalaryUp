package baekjoon._5_1차원배열._1546평균;

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

    	int num = sc.nextInt();
    	int[] arr = new int[num];
    	double total = 0;
    	
    	for (int i = 0; i < arr.length; i++) {
    		arr[i] = sc.nextInt();
    		total += arr[i];
    	}
    	
    	Arrays.sort(arr);
    	
    	System.out.println((total/num) / arr[num - 1] * 100);
    }
    
}
