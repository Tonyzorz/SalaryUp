package templates;

import java.util.*;

public class Solution_taewon {

	/*
	 * 
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(String str) {
		int cnt = 0;
	
		for(char c : str.toCharArray()) {
			cnt += c == '0' ? 1 : 0;
		}
		
		if(cnt % 3 != 0) return 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int res = 0, k = cnt / 3, sum = 0;
		
		for(int i = 0; i < str.length(); i++) {
			// Increment count if 0 appears
            sum += str.charAt(i) == '0' ? 1 : 0;
 
            // Increment result if sum equal to
            // 2*k and k exists in map
            if (sum == 2 * k && map.containsKey(k)
                && i < str.length() - 1 && i > 0) {
                res += map.get(k);
            }
 
            // Insert sum in map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		String str = "11111";
		/*
		 * 10100 2
		 * 01010 4
		 * 010 0
		 * 11111 6 
		 */
		System.out.println(solution.solution(str));
	}
}
