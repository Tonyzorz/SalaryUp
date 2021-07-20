package baekjoon._5_1차원배열._3052나머지;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main (String[] args) throws InterruptedException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);

    	int answer = 0;
    	int[] nums = new int[10];
    	boolean[] check = new boolean[43];
    	
    	for (int i = 0; i < 10; i++) {
    		nums[i] = sc.nextInt();
    	}
    	
    	int remainder = 0;
    	for (int i = 0; i < 10; i++) {
    		remainder = nums[i] % 42;
    		if (!check[remainder]) {
    			answer++;
    			check[remainder] = true;
    		}
    	}
    	
    	System.out.println(answer);
    }
    
}
