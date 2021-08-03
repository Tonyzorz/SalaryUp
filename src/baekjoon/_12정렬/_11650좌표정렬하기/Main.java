package baekjoon._12정렬._11650좌표정렬하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/11650
	 * 
	 * 좌표 정렬하기
		시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
		1 초	256 MB	50303	24342	18482	48.447%
		문제
		2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
		
		입력
		첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
		
		출력
		첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
		
		예제 입력 1 
		5
		3 4
		1 1
		1 -1
		2 2
		3 3
		예제 출력 1 
		1 -1
		1 1
		2 2
		3 3
		3 4
	 */
    public static void main (String[] args) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);

    	int cases = sc.nextInt();
    	
    	int[][] points = new int[cases][2];
    	
    	for (int i = 0; i < cases; i++) {
    		points[i][0] = sc.nextInt();
    		points[i][1] = sc.nextInt();
    	}

    	Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
    		
    	});
    	
    	for (int i = 0; i < cases; i++) {
    		System.out.print(points[i][0] + " " + points[i][1] + "\n");
    	}
    }
    
}
