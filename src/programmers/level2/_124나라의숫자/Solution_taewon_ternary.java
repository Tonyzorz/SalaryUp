package programmers.level2._124나라의숫자;

import java.util.*;

public class Solution_taewon_ternary {

	/*
	 * 124 나라의 숫자
문제 설명
124 나라가 있습니다.
 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

124 나라에는 자연수만 존재합니다.
124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.

10진법	124 나라	10진법	124 나라
1		1		6		14
2		2		7		21
3		4		8		22
4		11		9		24
5		12		10		41
자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 
하도록 solution 함수를 완성해 주세요.

제한사항
n은 500,000,000이하의 자연수 입니다.
입출력 예
n	result
1	1
2	2
3	4
4	11
	 */
	public Solution_taewon_ternary() {
		// TODO Auto-generated constructor stub
	}
	
	//0, 1, 2  =  1,2,4
	public String solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n % 3);
        
        while(n > 2) {
        	//System.out.println(n);
        	int value = n/3 % 3;
        	list.add(value);
        	n /= 3;
        }
        Collections.reverse(list);
        
        //convert ternary to 124 world 
        //첫번째 index가 0일시, 근데 이 부분은 밖에 하는게 효율상 좋을듯 
        if(list.get(0) == 0) {
    		list.set(0, 4);
    	}
        
        for(int i = 1; i < list.size(); i++) {
        	
        	convertNumber(list, i);
        }
        
        if(list.get(0) == 0) {
        	list.remove(0);
        }
        
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < list.size(); i++) {
        	sb.append(list.get(i));
        }
       // System.out.println("after convertNumber == " + list);
        return sb.toString();
    }
	
	public void convertNumber(ArrayList<Integer> list, int i) {
		
		if(list.get(i) == 0 && i != 0) {
			
			int previous = (list.get(i - 1)) - 1;
			//System.out.println(previous);
			if(previous == 3) previous = 2;
			list.set(i - 1, previous);
			list.set(i, 4);
			
			//System.out.println("while in convertNumber == " + list);
			convertNumber(list, i - 1);
		} else {
			return;
		}
		
		
	}
	
	public static void main(String[] args) {
		Solution_taewon_ternary solution = new Solution_taewon_ternary();
		int n = 10;
		System.out.println(solution.solution(n));
	}
}
