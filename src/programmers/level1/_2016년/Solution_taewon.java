package programmers.level1._2016년;

import java.util.*;

public class Solution_taewon {

	/*
	 * 문제 설명
2016년 1월 1일은 금요일입니다. 
2016년 a월 b일은 무슨 요일일까요? 
두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지
 리턴하는 함수, solution을 완성하세요. 
 요일의 이름은 일요일부터 토요일까지 각각 
 SUN,MON,TUE,WED,THU,FRI,SAT

입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 
문자열 "TUE"를 반환하세요.

제한 조건
2016년은 윤년입니다. Feb 29
2016년 a월 b일은 실제로 있는 날입니다. 
(13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
입출력 예
a	b	result
5	24	"TUE"
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	//a = 월, b = 일 
	public String solution(int a, int b) {
        int[] numOfDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int num = 0;
        
        for(int i = 0; i < a; i++) {
        	num += numOfDays[i];
        }
        System.out.println("==== num " + num);
        int remainder = numOfDays[a - 1] - b;
      System.out.println("==== remainder " + remainder);
        num -= remainder;
       System.out.println("==== num " + num);
       System.out.println("==== num % 7 ==== " + num % 7);
        return weekDay((num)% 7);
    }
	
	public String weekDay(int n) {
		String day = "";
		switch (n) {
			case 1: 
				day = "FRI";
				break;
			case 2:
				day = "SAT";
				break;
			case 3:
				day = "SUN";
				break;
			case 4:
				day = "MON";
				break;
			case 5:
				day = "TUE";
				break;
			case 6:
				day = "WED";
				break;
			case 0:
				day = "THU";	
				break;
			default: 
				day = "FRI";
		}
		return day;
	}
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int a = 1;
		int b = 1;
		System.out.println(solution.solution(a, b));
		
	}
}
