package programmers.level1.정수내림차순으로배치하기;

import java.util.*;

public class Solution_taewon {

	/*
	 * 정수 내림차순으로 배치하기
문제 설명
함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
n은 1이상 8000000000 이하인 자연수입니다.
입출력 예
n	return
118372	873211
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 *         String str = Integer.toString(n);
        char[] c = str.toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder(new String(c,0,c.length));  
        return Integer.parseInt(((sb.reverse()).toString()));
	 */
	
	public long solution_2(long n) {
	
		String str = Long.toString(n);
		char[] c = str.toCharArray();
		Arrays.sort(c);
		StringBuffer sb = new StringBuffer();
		for(char ch : c) sb.append(ch);

		return Long.parseLong(sb.reverse().toString());
	}
	
    public long solution(long n) {
        String temp = String.valueOf(n);
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i  < temp.length(); i++) {
        	list.add(Integer.parseInt(String.valueOf(temp.charAt(i))));
        }
        Collections.sort(list);
        Collections.reverse(list);
        
        //System.out.println("list = " + list);
        StringBuffer sb = new StringBuffer();
        
        for(int i : list) {
        	sb.append(i);
        }
        
        return Long.parseLong(sb.toString());
    }
    
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		long n = 118372;
		System.out.println(solution.solution(n));
	}
}
