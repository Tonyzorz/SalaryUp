package baekjoon._7문자열._2941크로아티아알파벳;

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

    	ArrayList<String> croatiaAlphabet = new ArrayList<String>();
    	croatiaAlphabet.add("c=");
    	croatiaAlphabet.add("c-");
    	croatiaAlphabet.add("dz=");
    	croatiaAlphabet.add("d-");
    	croatiaAlphabet.add("lj");
    	croatiaAlphabet.add("nj");
    	croatiaAlphabet.add("s=");
    	croatiaAlphabet.add("z=");
    	
    	String alphabet = sc.nextLine();
    	
    	for (int i = 0; i < croatiaAlphabet.size(); i++) {
    		alphabet = alphabet.replaceAll(croatiaAlphabet.get(i), "0");
    	}
    	
    	System.out.println(alphabet.length());
    }
    
}
