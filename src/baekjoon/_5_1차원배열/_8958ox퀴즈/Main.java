package baekjoon._5_1차원배열._8958ox퀴즈;

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

    	int n = sc.nextInt();
    	
    	for (int i = 0; i < n; i++) {
    		
    		int consecutive = 0;
    		int answer = 0;
    		String[] str = sc.next().split("");
    		
    		for (int j = 0; j < str.length; j++) {
    			if (str[j].equals("O")) {
    				consecutive++;
    				answer += consecutive;
    			} else {
    				consecutive = 0;
    			}
    		}
    		System.out.println(answer);
    	}
    }
    
}
