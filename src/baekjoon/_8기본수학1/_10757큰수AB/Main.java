package baekjoon._8기본수학1._10757큰수AB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main (String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	BigInteger A = new BigInteger(sc.next());
    	BigInteger B = new BigInteger(sc.next());
    	
    	BigInteger sum = A.add(B);
    	
    	System.out.println(sum);

    }
    
}
