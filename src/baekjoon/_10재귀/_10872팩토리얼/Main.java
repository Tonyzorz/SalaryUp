package baekjoon._10재귀._10872팩토리얼;

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

    	int N = sc.nextInt();
    	System.out.println(recursive(N));
    }
    
    public static int recursive(int N) {
    	if (N == 1 || N == 0) {
    		return 1;
    	}
    	
    	return N * recursive(N - 1);
    }
    
}
