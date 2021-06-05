package programmers.level1.문자열내마음대로정렬하기;

import java.util.*;

public class Solution_taewon_moonja_failed {

	/*
	 * 문자열 내 마음대로 정렬하기
문제 설명
문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.

제한 조건
strings는 길이 1 이상, 50이하인 배열입니다.
strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
모든 strings의 원소의 길이는 n보다 큽니다.
인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
입출력 예
strings	n	return
["sun", "bed", "car"]	1	["car", "bed", "sun"]
["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
입출력 예 설명
입출력 예 1
"sun", "bed", "car"의 1번째 인덱스 값은 각각 "u", "e", "a" 입니다. 이를 기준으로 strings를 정렬하면 ["car", "bed", "sun"] 입니다.

입출력 예 2
"abce"와 "abcd", "cdx"의 2번째 인덱스 값은 "c", "c", "x"입니다. 따라서 정렬 후에는 "cdx"가 가장 뒤에 위치합니다. "abce"와 "abcd"는 사전순으로 정렬하면 "abcd"가 우선하므로, 답은 ["abcd", "abce", "cdx"] 입니다.
	 */
	public Solution_taewon_moonja_failed() {
		// TODO Auto-generated constructor stub
	}
	
	public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        ArrayList<String> list = new ArrayList<>();
        
        for(String str : strings) {
        	list.add(str);
        }
        for(int i = 0; i < list.size(); i++) {
        	String iString = strings[i].substring(n, strings[i].length() - 1);
        	int first = i;
        	for(int j = i + 1; j < strings.length; j++) {
        		String jString = strings[j].substring(n, strings[j].length() - 1);
        		if(iString.compareTo(jString) > 0) {
        			//front is smaller         			
        		} else {
        			iString = jString;
        			first = j;
        		}
        	}
        	//answer[index] = answer[i];
        }
        int i = 0;  int index = 0;
        while(list.size() > 1) {
        	String iString = strings[i].substring(n, strings[i].length() - 1);
        	for(int j = i + 1; j < strings.length; j++) {
        		String jString = strings[j].substring(n, strings[j].length() - 1);
        		if(iString.compareTo(jString) > 0) {
        			//front is smaller         			
        		} else {
        			iString = jString;
        			index = j;
        		}
        	}
        	//answer[index] 
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_taewon_moonja_failed solution = new Solution_taewon_moonja_failed();
		String[] strings = {"sun", "bed", "car"};
		int n = 1;
		System.out.println("a".compareTo("c"));
		// > 0
		//System.out.println(solution.solution(strings, n));
	}
}
