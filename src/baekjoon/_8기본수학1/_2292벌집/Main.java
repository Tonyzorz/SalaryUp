package baekjoon._8기본수학1._2292벌집;

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
    	
    	int depth = 1;
    	int rooms = 1;
    	int size = 0;
    	
    	while (rooms < num) {
    		
    		size += 6;
    		rooms += size;
    		depth++;
    	}
    	
    	System.out.println(depth);
    }
    
}
