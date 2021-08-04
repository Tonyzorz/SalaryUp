package baekjoon._12정렬._18870좌표압축;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/*
	 * https://www.acmicpc.net/problem/18870
	 * 
	 * 좌표 압축
		시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
		2 초	512 MB	11644	5388	4029	44.911%
		문제
		수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
		
		Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
		
		X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
		
		입력
		첫째 줄에 N이 주어진다.
		
		둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
		
		출력
		첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
		
		제한
		1 ≤ N ≤ 1,000,000
		-109 ≤ Xi ≤ 109
		예제 입력 1 
		5
		2 4 -10 4 -9
		예제 출력 1 
		2 3 0 3 1
		예제 입력 2 
		6
		1000 999 1000 999 1000 999
		예제 출력 2 
		1 0 1 0 1 0
	 */
    public static void main (String[] args) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
    	
    	int cases = Integer.parseInt(br.readLine());
    	String[] st = br.readLine().split(" ");
    	
    	int[] numbers = new int[cases];
    	HashMap<Integer, Integer> places = new HashMap<Integer, Integer>();
    	SortedSet<Integer> set = new TreeSet<>();
    	
    	for (int i = 0; i < st.length; i++) {
    		int num = Integer.parseInt(st[i]);
    		numbers[i] = num;
    		set.add(num);
    	}
    	
    	Iterator<Integer> iterator = set.iterator();
    	for (int i = 0; i < set.size(); i++) {
    		places.put(iterator.next(), i);
    	}
    	
    	for (int i = 0; i < numbers.length; i++) {
    		bw.write(places.get(numbers[i]) + " ");
    	}
    	
    	bw.flush();
    	
    }
    
}
