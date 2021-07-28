package baekjoon._9기본수학2._1085직사각형에서탈출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/1085
	 * 문제
		한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
		
		입력
		첫째 줄에 x, y, w, h가 주어진다.
		
		출력
		첫째 줄에 문제의 정답을 출력한다.
		
		제한
		1 ≤ w, h ≤ 1,000
		1 ≤ x ≤ w-1
		1 ≤ y ≤ h-1
		x, y, w, h는 정수
	 */
    public static void main (String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int x = Integer.parseInt(st.nextToken());
    	int y = Integer.parseInt(st.nextToken());
    	int w = Integer.parseInt(st.nextToken());
    	int h = Integer.parseInt(st.nextToken());
    	
//    	//위치가 우측 위 지점과 가깝다
//    	if (x > w/2 || y > h/2) {
//    		
//    		if (h - y > w - x) {
//    			System.out.println(w - x);
//    		} else {
//    			System.out.println(h - y);
//    		}
//
//    	//밑단 과 가깝다
//    	} else {
//    		
//    		if (y > x) {
//    			System.out.println(x);
//    		} else {
//    			System.out.println(y);
//    		}
//    	}
    	
    	int shortest = Math.min(h - y, Math.min(w - x, Math.min(y , x)));
    	System.out.println(shortest);
    }
    
}
