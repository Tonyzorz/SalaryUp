package programmers.level1.문자열내림차순으로배치하기;

import java.util.*;

public class Solution_taewon {

	/*
	 * 문자열 내림차순으로 배치하기
문제 설명
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

제한 사항
str은 길이 1 이상인 문자열입니다.
입출력 예
s	return
"Zbcdefg"	"gfedcbZ"
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public String solution(String s) {
        StringBuffer answer2 = new StringBuffer();
        int[] beforeSort = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
        	beforeSort[i] = (int)s.charAt(i);
        }
        
        Arrays.sort(beforeSort);
        
        for(int i = beforeSort.length - 1; i >= 0; i--) {
        	answer2.append((char)beforeSort[i]);
        }
        
        return answer2.toString();
    }
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		String s = "Zbcdefg";
		
		System.out.println(solution.solution(s));
	}
}
