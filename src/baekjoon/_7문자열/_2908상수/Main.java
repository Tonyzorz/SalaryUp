package baekjoon._7문자열._2908상수;

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
    	
    	StringTokenizer st = new StringTokenizer(sc.nextLine());
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    
    	a = reverseInt(a);
    	b = reverseInt(b);
    	
    	int answer = a > b ? a : b;
    	
    	System.out.println(answer);
    }
    
    public static int reverseInt(int num) {
    	
    	int hundreds = num / 100;
    	int tens = (num / 10) % 10;
    	int ones = num % 10;
    	
    	int answer = (ones * 100) + (tens * 10) + hundreds;
    	
    	return answer;
    }
    
}
