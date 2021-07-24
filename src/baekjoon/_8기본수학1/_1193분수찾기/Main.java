package baekjoon._8기본수학1._1193분수찾기;

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
    	
    	int index = sc.nextInt();
    	boolean isDesc = true;
    	int total = 1;
    	int range = 1;
    	int nums = 1;
    	
    	while (total < index) {
    		range++;
    		total += range;
    		nums++;
    		isDesc = !isDesc;
    	}
    	
    	int a = total - (total - nums) + 1;
    	int b = 0;
    	
    	for (int i = total - nums; i < index; i++) {
    		a--;
    		b++;
    	}
    	
    	if (isDesc) {
    		System.out.println(a + "/" + b);
    	} else {
    		System.out.println(b + "/" + a);
    	}
    }
    
}
