package baekjoon._5_1차원배열._2577숫자의개수;

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

    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	int c = sc.nextInt();
    	
    	int total = a * b * c;
    	int[] nums = new int[10];
    
    	while (total > 0) {
    		nums[total % 10]++;
    		total /= 10;
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		System.out.println(nums[i]);
    	}
    }
    
}
