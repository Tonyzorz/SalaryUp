package baekjoon._8기본수학1._2869달팽이는올라가고싶다;

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
    	
    	long climb = sc.nextLong();
    	long fall = sc.nextLong();
    	long destination = sc.nextLong();
    	
    	long day = ((destination - fall) % (climb - fall) == 0)? 
        (destination - fall) / (climb - fall) : (destination - fall) / (climb - fall) + 1 ;

        System.out.println(day);
    }
    
}
