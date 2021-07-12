package interview.kingkiyo_2021_06;

import java.util.*;

public class Solution_taewon_splitPossibilities {

	/*
	 * 
	 */
	public Solution_taewon_splitPossibilities() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(String S) {
        int cnt = 0;

        for (char c : S.toCharArray()) {
            cnt += c == 'a' ? 1 : 0;
        }
 
        if (cnt % 3 != 0) {
        	return 0;
        }
 
        int res = 0;
        int numofA = cnt / 3;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
 
            sum += S.charAt(i) == 'a' ? 1 : 0;
 
            if (sum == 2 * numofA && hm.containsKey(numofA)
                && i < S.length() - 1 && i > 0) {
                res += hm.get(numofA);
            }
 
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
 
        // Return result
        return res;
    }
	
	public static void main(String[] args) {
		Solution_taewon_splitPossibilities solution = new Solution_taewon_splitPossibilities();
		String S = "bbbbb";
		System.out.println(solution.solution(S));
	}
}
