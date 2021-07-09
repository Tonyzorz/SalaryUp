package templates;

import java.util.*;

public class Solution_taewon_kinyibeo2 {

	/*
	 * 
	 */
	public Solution_taewon_kinyibeo2() {
		// TODO Auto-generated constructor stub
	}
	

	class Solution {
	    public String[] solution(String s) {
	        StringBuilder word1 = new StringBuilder(), word2 = new StringBuilder();
	        List<String> symmetry = new ArrayList<>();
	
	        for (int i = 0; i <= s.length(); i++) {
	            if (!word1.toString().equals("") && word1.toString().equals(word2.toString())) {
	                symmetry.add(word1.toString());
	                word1.delete(0, word1.length());
	                word2.delete(0, word2.length());
	
	                if (i == s.length())
	                    break;
	            }
	            word1.append(s.charAt(i));
	            word2.insert(0, s.charAt(s.length() - i - 1));
	        }
	
	        String[] answer = new String[symmetry.size()];
	
	        for (int i = 0; i < symmetry.size(); i++) {
	            answer[i] = symmetry.get(i);
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution_taewon_kinyibeo2 solution = new Solution_taewon_kinyibeo2();

	}
}
