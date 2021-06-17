package programmers.level2.소수찾기;

import java.util.*;

public class Solution_taewon_prime2 {

	/*
	 * 소수 찾기
문제 설명
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
입출력 예
numbers	return
"17"	3
"011"	2
입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

11과 011은 같은 숫자로 취급합니다.
	 */
	public Solution_taewon_prime2() {
		// TODO Auto-generated constructor stub
	}
	
	public int solution(String numbers) {
        int answer = 0;
        
        HashSet<Integer> list = new HashSet<Integer>();
        
        for(int i = 1; i <= numbers.length(); i++) {
        	recursive(list, "", numbers, i);
        }
        
        //System.out.println(list);

        for(int num : list) {
        	if(isPrime(num)) answer++;
        }
        
        return answer;
    }
	
	public void recursive(HashSet<Integer> list, String prefix, String remainder, int length) {
		
		if(prefix.length() == length) {
			list.add(Integer.parseInt(prefix));
		}
		
		for(int i = 0; i < remainder.length(); i++) {
			recursive(list, prefix + remainder.charAt(i), remainder.substring(0, i) + remainder.substring(i + 1, remainder.length()), length);
		}
	}
	//소수 2번 시작해서 
	//반까지 하기 
	public boolean isPrime(int num) {
		
		if(num <= 1) {
			return false;
		}
		for(int i = 2; i <= num/2; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Solution_taewon_prime2 solution = new Solution_taewon_prime2();
		String numbers = "011";
		System.out.println(solution.solution(numbers));
	}
}
