package interview.kingyibeo_2021_07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution_taewon_coupon {

	/*
	 * 문제 설명
쿠폰을 사용하면 물건을 살 때 할인을 받을 수 있습니다. 쿠폰이 여러 장 주어졌을 때, 쿠폰을 적절히 사용해 할인을 최대한 많이 받으려고 합니다. 한 제품에는 쿠폰을 하나만 적용할 수 있으며, 사용한 쿠폰은 사라집니다.

주문할 제품의 가격 prices, 쿠폰별 할인율 discounts가 매개변수로 주어집니다. 할인을 최대한 많이 받도록 쿠폰을 적용했을 때 얼마를 내야 하는지 return 하도록 solution 함수를 완성해주세요.

제한 사항
prices 배열의 길이는 1 이상 1,000 이하입니다.
prices 배열의 원소는 5,000 이상 150,000 이하인 자연수이며, 항상 100으로 나누어 떨어집니다.
discounts 배열의 길이는 1 이상 1,000 이하입니다.
discounts 배열의 원소는 1 이상 100 이하인 자연수입니다.
입출력 예
prices	discounts	result
[13000, 88000, 10000]	[30, 20]	82000
[32000, 18000, 42500]	[50, 20, 65]	45275
입출력 예 설명
입출력 예 #1

13,000원짜리 제품에 20% 쿠폰을 적용해 10,400원을 결제합니다.
88,000원짜리 제품에 30% 쿠폰을 적용해 61,600원을 결제합니다.
10,000원짜리 제품에는 쿠폰을 적용하지 않습니다.

따라서 82,000원을 내야 합니다.

입출력 예 #2

32,000원짜리 제품에 50% 쿠폰을 적용해 16,000원을 결제합니다.
18,000원짜리 제품에 20% 쿠폰을 적용해 14,400원을 결제합니다.
42,500원짜리 제품에 65% 쿠폰을 적용해 14,875원을 결제합니다.

따라서 45,275원을 내야 합니다.
	 */
	public Solution_taewon_coupon() {
		// TODO Auto-generated constructor stub
	}
	
    public int solution(int[] prices, int[] discounts) {
        int answer = 0;
        Stack<Integer> pricesStack = new Stack<Integer>();
        Stack<Integer> discountsStack = new Stack<Integer>();
        
        Arrays.sort(prices);
        Arrays.sort(discounts);
        
        for (int price : prices) {
        	pricesStack.add(price);
        }
        for (int discount : discounts) {
        	discountsStack.add(discount);
        }
        
        for (int i = 0; i < prices.length; i++) {
        	if (discountsStack.isEmpty()) break;
        	float percent = (float)(100 - discountsStack.pop()) / 100;
        	float cost = pricesStack.pop() * percent;
        	answer += cost;
        }
        
        while (!pricesStack.isEmpty()) {
        	answer += pricesStack.pop();
        }
        
        return answer;
    }
    
    public int solutionAcceptanceFail(int[] prices, int[] discounts) {
        int answer = 0;
        Integer[] pricesz = new Integer[prices.length];
        Integer[] discountsz = new Integer[discounts.length];

        int z = 0;
        for(int i : prices) pricesz[z++] = Integer.valueOf(i);
        z = 0;
        for(int i : discounts) discountsz[z++] = Integer.valueOf(i);
        
        Arrays.sort(pricesz, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2) return 1;
				return -1;
			}
        	
        });
        
        Arrays.sort(discountsz, new Comparator<Integer>() {
        	
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		if(o1 < o2) return 1;
				return -1;
        	}
        	
        });
        
        //System.out.println(Arrays.toString(pricesz));
        //System.out.println(Arrays.toString(discountsz));
        
        for(int i = 0; i < discountsz.length; i++) {
        	if(i == pricesz.length) break;
        	pricesz[i] =  pricesz[i] - (pricesz[i] * (discountsz[i]) / 100) ;
        }
        System.out.println(Arrays.toString(pricesz));
        
        for(int i : pricesz) answer += i;
        
        return answer;
    }
    
	public static void main(String[] args) {
		Solution_taewon_coupon solution = new Solution_taewon_coupon();
		int[] prices = {13000, 88000, 10000};
		int[] discounts = {30, 20, 30};
		System.out.println(solution.solution(prices, discounts));
	}
}
