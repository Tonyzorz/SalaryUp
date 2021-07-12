package programmers.level2.행렬의곱셈;

import java.util.*;

public class Solution_taewon_rowColumnMulti {

	/*
	 * 행렬의 곱셈
		문제 설명
		2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
		
		제한 조건
		행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
		행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
		곱할 수 있는 배열만 주어집니다.
		입출력 예
		arr1	arr2	return
		[[1, 4], [3, 2], [4, 1]]	[[3, 3], [3, 3]]	[[15, 15], [15, 15], [15, 15]]
		[[2, 3, 2], [4, 2, 4], [3, 1, 4]]	[[5, 4, 3], [2, 4, 1], [3, 1, 1]]	[[22, 22, 11], [36, 28, 18], [29, 20, 14]]
	 */
	public Solution_taewon_rowColumnMulti() {
		// TODO Auto-generated constructor stub
	}
	
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < arr1.length; i++) {

    		for (int j = 0; j < arr1[0].length; j++) {
    			
    			for (int z = 0; z < arr2[0].length; z++) {
    				
    				answer[i][z] += arr1[i][j] * arr2[j][z];
    			}
    			
    		}
        	
        }
        
        for (int i = 0; i < answer.length; i++) {
        	System.out.println(Arrays.toString(answer[i]));
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		Solution_taewon_rowColumnMulti solution = new Solution_taewon_rowColumnMulti();
		int[][] arr1 = {{2,2},{3,3},};
		int[][] arr2 = {{2,2},{3,3}};
		
		System.out.println(solution.solution(arr1, arr2));
	}
}
