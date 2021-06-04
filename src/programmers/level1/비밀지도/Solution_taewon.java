package programmers.level1.비밀지도;

import java.util.*;

public class Solution_taewon {

	/*
비밀지도
네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 
그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 
다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자. 
지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 
지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
"지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
secret map

네오가 프로도의 비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.

입력 형식
입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.

1 ≦ n ≦ 16
arr1, arr2는 길이 n인 정수 배열로 주어진다.
정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2n - 1을 만족한다.
출력 형식
원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라.

입출력 예제
매개변수	값
n	5
arr1	[9, 20, 28, 18, 11]
arr2	[30, 1, 21, 17, 28]
출력	["#####","# # #", "### #", "# ##", "#####"]
매개변수	값
n	6
arr1	[46, 33, 33 ,22, 31, 50]
arr2	[27 ,56, 19, 14, 14, 10]
출력	["######", "### #", "## ##", " #### ", " #####", "### # "]
	 */
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
	public String[] solution(int n, int[] arr1, int[] arr2) {
		
		/**
		 * anwer = 답 담을 배열 
		 * hash = 벽의 여부를 확인할 2차원배열
		 */
        String[] answer = new String[n];
        boolean[][] hash = new boolean[n][n];
        // n x n 사이즈 만큼 돌려서 
        for(int i = 0; i < arr1.length; i++) {
        	//각 지도(arr1, arr2)의 값을 2진수로 변환 
        	String temp = checkBinary(n, arr1[i]);
        	String temp2 = checkBinary(n, arr2[i]);
        	
        	//2진수 크기는 n이랑 동일, 각 place마다 1이면 true으로 벽있다고 표시 
        	for(int j = 0; j < n; j++) {
        		//hash[i][j]
        		System.out.println(Character.getNumericValue(temp.charAt(j)));
        		if(1 == Character.getNumericValue(temp.charAt(j)) || 1 == Character.getNumericValue(temp2.charAt(j))) {
        			hash[i][j] = true;
        		}
        	}
        }
        
        //벽의 위치를 hash에 다 담았으니 이제 그걸 answer에 진짜 #로 표시해주기 
        for(int i = 0; i < n; i++) {
        	
        	//계속 append를 해줘야해서 유동적인 StringBuffer로 선언 
        	StringBuffer hashAnswer = new StringBuffer();
        	
        	//n만큼 돌려서 true일시 # append, false일시 벽이 없으며 빈칸 append 
        	for(int j = 0; j < n; j++) {
        		
        		if(hash[i][j]) {
    				hashAnswer.append("#");
    			} else {
    				hashAnswer.append(" ");
    			}
        	}
        	
        	answer[i] = hashAnswer.toString();
        }
        
        return answer;
    }
	
	//숫자를 2진수로 만들어주는 함수 
	public String checkBinary(int n, int num) {
		
		//2진수 만들어주는 내장함수/라이브러리 사용
		String answer = Integer.toBinaryString(num);
		StringBuffer frontZero = new StringBuffer();
		
		//만약 2진수 길이가 n보다 짧으면 부족한 만큼 앞에 더해주기 
		if(answer.length() != n) {
			
			for(int i = answer.length(); i < n; i++) {
				frontZero.append("0");
			}
			
			answer = frontZero.toString() + answer;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		System.out.println(Arrays.toString(solution.solution(n, arr1, arr2)));
	}
	
}
