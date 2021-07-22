package baekjoon._8기본수학1._1712손익분기점;

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
    	
    	long fixedCost = sc.nextInt();
    	long perCost = sc.nextInt();
    	long notebook = sc.nextInt();
    	
    	if (perCost >= notebook) {
    		System.out.println("-1");
    		return;
    	}
    	
    	System.out.println(fixedCost / (notebook - perCost) + 1);
    }
    
}
