package interview.kingyibeo_2021_07;

import java.util.*;

public class Solution_taewon_kinyibeo1_cook {

	/*
	 * 
	 */
	public Solution_taewon_kinyibeo1_cook() {
		// TODO Auto-generated constructor stub
	}
	

	class Solution {
	    public int solution(int[] prices, int[] discounts) {
	        int answer = 0;
	        Stack<Integer> priceStack = new Stack<>();
	        Stack<Integer> discountStack = new Stack<>();

	        Arrays.sort(prices);
	        Arrays.sort(discounts);

	        for (int i : prices)
	            priceStack.push(i);

	        for (int i : discounts)
	            discountStack.push(i);

	        while (!discountStack.isEmpty()) {
	            if (priceStack.isEmpty())
	                break;
	            
	            int price = priceStack.pop(), discount = discountStack.pop();

	            answer += Math.round(price * ((double) (100 - discount) / (double) 100));
	        }

	        while (!priceStack.isEmpty()) {
	            answer += priceStack.pop();
	        }

	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution_taewon_kinyibeo1_cook solution = new Solution_taewon_kinyibeo1_cook();

	}
}
