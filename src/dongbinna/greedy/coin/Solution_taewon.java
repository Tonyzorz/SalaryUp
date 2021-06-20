package dongbinna.greedy.coin;

import java.util.*;

public class Solution_taewon {

	/*
	 * 당신은 음식점의 계산을 도와주는 점원입니다. 
	 * 카운터에는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정합니다.
	 * 손님에게 거슬러 주어야 할 돈이 N원일 때, 거슬러 주어야 할 동전의 최소 개수를 구하세요.
	 * 단, 거슬러 줘야 할 돈 N은 항상 10의 배수입니다.
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(int money) {
		int answer = 0;
		int[] change = {500, 100, 50, 10};
		
		for(int i = 0; i < change.length; i++) {
			answer += money/change[i];
			money = money % change[i];
		}
		
		return answer;
	}
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int money = 1260;
		System.out.println(solution.solution(money));
	}
}
