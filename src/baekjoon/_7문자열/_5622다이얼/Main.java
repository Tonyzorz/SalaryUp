package baekjoon._7문자열._5622다이얼;

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

    	HashMap<Character, Integer> phoneBook = new HashMap<Character, Integer>();
    	phoneBook.put('A', 3);
    	phoneBook.put('B', 3);
    	phoneBook.put('C', 3);
    	phoneBook.put('D', 4);
    	phoneBook.put('E', 4);
    	phoneBook.put('F', 4);
    	phoneBook.put('G', 5);
    	phoneBook.put('H', 5);
    	phoneBook.put('I', 5);
    	phoneBook.put('J', 6);
    	phoneBook.put('K', 6);
    	phoneBook.put('L', 6);
    	phoneBook.put('M', 7);
    	phoneBook.put('N', 7);
    	phoneBook.put('O', 7);
    	phoneBook.put('P', 8);
    	phoneBook.put('Q', 8);
    	phoneBook.put('R', 8);
    	phoneBook.put('S', 8);
    	phoneBook.put('T', 9);
    	phoneBook.put('U', 9);
    	phoneBook.put('V', 9);
    	phoneBook.put('W', 10);
    	phoneBook.put('X', 10);
    	phoneBook.put('Y', 10);
    	phoneBook.put('Z', 10);
    	
    	String[] letters = sc.nextLine().split("");
    	int answer = 0;
    	
    	for (int i = 0; i < letters.length; i++) {
    		answer += phoneBook.get(letters[i].charAt(0));
    	}
    	
    	System.out.println(answer);
    }
    
}
