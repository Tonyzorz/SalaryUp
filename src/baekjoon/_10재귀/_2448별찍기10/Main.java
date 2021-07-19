package baekjoon._10재귀._2448별찍기10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static char[][] star;
    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);

//    	int n = sc.nextInt();
    	int n = 9;
    	star = new char[n][n];
    	
    	star(0, 0, n, false);

    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			System.out.print(star[i][j]);
    		}
    		System.out.println();
    	}
    }
    
    public static void star(int x, int y, int n, boolean blank) {
    	
    	if (blank) {
    		
    		for (int i = x; i < x + n; i++) {
    			for (int j = y; j < y + n; j++) {
    				star[i][j] = ' ';
    			}
    		}
    		return;
    	}
    	
    	if (n == 1) {
    		star[x][y] = '*';
    		return;
    	}
    	
    	int size = n/3;
    	int count = 0;
    	for (int i = x; i < x + n; i += size) {
    		for (int j = y; j < y + n; j += size) {
    			count++;
    			if (count == 5) {
    				star(i, j, size, true);
    			} else {
    				star(i, j, size, false);
    			}
    		}
    	}
    }
    
}
