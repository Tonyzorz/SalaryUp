package baekjoon._4while문._1110더하기싸이클;

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
    	//26 2 + 6 = 8 -> 68 
    	//68 6 + 8 = 14 -> 84
    	if (num == 0) {
    		System.out.println(1);
    		return;
    	}
    	
    	int ten = num / 10;
    	int one = num % 10;
    	int temp = 0;
    	int answer = 0;
    	
    	while (temp != num) {
    		temp = (one * 10) + ((one + ten) % 10);
    		ten = temp / 10;
    		one = temp % 10;
    		answer++;
    	}
    	
    	System.out.println(answer);
    }
    
}
