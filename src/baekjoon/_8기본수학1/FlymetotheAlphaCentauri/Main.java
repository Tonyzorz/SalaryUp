package baekjoon._8기본수학1.FlymetotheAlphaCentauri;

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
    	
    	int travels = sc.nextInt();
    	
    	for (int i = 0; i < travels; i++) {
    		
    		int start = sc.nextInt();
    		int end = sc.nextInt();
    		int times = 0;
    		
    		int distance = 1;
    		while (start <= end) {
    			
    			start += distance;
    			times++;
    			
    			if (start >= end) {
    				break;
    			}

    			end -= distance;
    			times++;
    			
    			if (start >= end) {
    				break;
    			}
    			
    			distance++;

    		}
    		
    		System.out.println(times);
    	}
    	
    }
    
}
