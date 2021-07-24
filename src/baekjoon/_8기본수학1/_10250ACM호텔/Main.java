package baekjoon._8기본수학1._10250ACM호텔;

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
    	
    	int buildings = sc.nextInt();
    	
    	for (int j = 0; j < buildings; j++) {
    		
    		int h = sc.nextInt();
    		int w = sc.nextInt();
    		int n = sc.nextInt();
    		
    		int front = n - (n / h) * h == 0 ? h : n - (n / h) * h;
    		int back = n % h == 0 ? n / h : n / h + 1;
    		
    		if (back < 10) {
    			System.out.println(front + "0" + back);
    		} else {
    			System.out.println(front + "" + back);
    		}
    	}
    	
    }
    
}
