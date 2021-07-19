package baekjoon._3for문.별찍기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main (String[] args) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);

    	int n = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < n; i++) {
    		for (int j = n - 1; j >= 0; j--) {
    			if (j > i) {
    				bw.write(' ');
    			} else {
    				bw.write("*");
    			}
    		}
    		bw.write("\n");
    	}
    	
    	bw.flush();
    }
    
}
