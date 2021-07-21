package baekjoon._7문자열._1157단어공부;

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

    	String[] str = sc.nextLine().toLowerCase().split("");
    	
    	//alphabet[][0] = how many letters
    	//alphabet[][1] = which place in alphabet
    	int[][] alphabet = new int[26][2];
    	
    	for (String letter : str) {
    		int place = (letter.charAt(0) - 'a');
    		alphabet[place][1] = place;
    		alphabet[place][0]++;
    	}

    	Arrays.sort(alphabet, new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				return arg0[0] - arg1[0];
			}
    		
    	});
    	
//    	System.out.println();
//    	for (int i = 0; i < alphabet.length; i++) {
//    		System.out.println(Arrays.toString(alphabet[i]));
//    	}
    	
    	if (alphabet[alphabet.length - 1][0] == alphabet[alphabet.length - 2][0]) {
    		System.out.println("?");
    	} else {
    		char letter = (char) (alphabet[alphabet.length - 1][1] + 'a' - 32);
    		System.out.println(letter);
    	}
    }
    
}
