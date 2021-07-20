package baekjoon._6함수._1065한수;

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
    	
    	System.out.println(arithmetic_sequence(num));
    }
    
    public static int arithmetic_sequence(int num) {
    	
    	int answer = 0;
    	
    	if (num < 100) {
    		answer = num;
    	} else {
    		answer = 99;
    		for (int i = 100; i <= num; i++) {
    			int hundreds = i / 100;
    			int tens = (i / 10) % 10;
    			int ones = i % 10;
    			
    			if ((hundreds - tens) == (tens - ones)) {
    				answer++;
    			}
    		}
    	}
    	
    	return answer;
    }
    
}
