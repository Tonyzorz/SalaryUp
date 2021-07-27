package baekjoon._9기본수학2._1978소수찾기;

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

    	int numbers = sc.nextInt();
    	int answer = 0;
    	boolean[] isPri = new boolean[1001];
    	
    	Arrays.fill(isPri, true);
    	isPri[0] = false;
    	isPri[1] = false;
    	
    	for (int i = 2; i < Math.sqrt(isPri.length); i++) {
    		if (isPri[i]) {
    			for (int j = i * i; j < isPri.length; j += i) {
    				isPri[j] = false;
    			}
    		}
    	}
    	
    	//System.out.println(Arrays.toString(isPri));
    	for (int i = 0; i < numbers; i++) {
    		
    		int num = sc.nextInt();
//    		if (isPrime(num)) {
//    			answer++;
//    		}
    		
    		if (isPri[num]) {
    			answer++;
    		}
    	}
    	
    	System.out.println(answer);
    }
    
    public static boolean isPrime(int num) {
    	
    	if (num <= 1) {
    		return false;
    	}
    	
    	for (int i = 2; i < num; i++) {
    		if (num % i == 0) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
