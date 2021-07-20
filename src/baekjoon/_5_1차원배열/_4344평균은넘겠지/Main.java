package baekjoon._5_1차원배열._4344평균은넘겠지;

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
    	
    	for (int i = 0; i < num; i++) {
    		
    		int size = sc.nextInt();
    		int[] scores = new int[size];
    		double total = 0;
    		
    		for (int j = 0; j < size; j++) {
    			scores[j] = sc.nextInt();
    			total += scores[j];
    		}
    		
    		Arrays.sort(scores);
    		total /= size;
    		
    		int aboveAverage = 0;
    		for (int j = size - 1; j > 0; j--) {
    			if (scores[j] > total) {
    				aboveAverage++;
    			} else {
    				break;
    			}
    		}
    		
    		double average = (double)aboveAverage/size * 100;
    		
    		
    		System.out.println(String.format("%.3f", (double)Math.round(average * 1000) / 1000) + "%");
    		
    	}
    }
    
}
