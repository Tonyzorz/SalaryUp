package baekjoon._7문자열._10809알파벳찾기;

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

    	int[] alphabet = new int[26];
    	Arrays.fill(alphabet, -1);
    	
    	String[] str = sc.nextLine().split("");
    	
    	for (int i = 0; i < str.length; i++) {
    		int place = (str[i].charAt(0) - 'a');
    		if (alphabet[place] == -1) {
    			alphabet[place] = i;
    		}
    	}
    	
    	System.out.println(Arrays.toString(alphabet).replace("[", "").replace("]", "").replaceAll(",", ""));
    	
    	
    }
    
}
