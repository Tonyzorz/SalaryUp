package baekjoon._6함수._4673셀프넘버;

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

    	boolean[] check = new boolean[10001];
    	
    	for (int i = 0; i < 10000; i++) {
    		check[number(i)] = true;
    	}
    	
    	for (int i = 0; i < 10000; i++) {
    		if (!check[i]) System.out.println(i);
    	}
    }
    
    public static int number(int n) {
    	
    	int total = n;
    	while (n > 0) {
    		total += n % 10;
    		n /= 10;
    	}
    	if (total > 10000) return 10000;
    	return total;
    }
    
}
