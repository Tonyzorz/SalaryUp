package baekjoon._2if문._2884알람시계;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main (String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int hour = Integer.parseInt(st.nextToken());
    	int min = Integer.parseInt(st.nextToken());
    	
    	if (min < 45) {
    		min += 60;
    		if (hour == 0) {
    			hour = 23;
    		} else {
    			hour -= 1;
    		}
    	}
    	
    	min -= 45;
    	
    	bw.write(hour + " " + min);
    	bw.flush();
    }
    
}
