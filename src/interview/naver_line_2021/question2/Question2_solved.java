package interview.naver_line_2021.question2;

import java.util.*;

public class Question2_solved {

	/*
	 * 문제 설명
당신은 검색 기능을 가진 사이트를 운영하고 있습니다. 당신은 매월 초마다 전월의 최고의 이슈 검색어를 조사하고 있습니다. 최고의 이슈 검색어를 조사하는 방법은 아래와 같습니다.

전월의 사용자들의 검색 기록을 일 기준으로 나눈 research가 주어집니다.
research를 일 기준으로 어떤 검색어가 몇 번 검색되었는지 정리합니다.
어떤 검색어가 연속된 n일 동안 매일 최소 k 번 이상 검색되고, 같은 연속된 n일 동안 총 2 x n x k번 이상 검색되었을 경우 이슈 검색어가 됩니다.
예를 들어, n이 3이고 k가 50이면 그 전월에서 임의의 연속된 3일을 골랐을 때, 매일 50번 이상씩 검색되고 같은 기간 동안 총 300번 이상 검색되면 이슈 검색어가 됩니다.
이슈 검색어 중에서 가장 여러 번 이슈 검색어가 된 검색어가 최고의 이슈 검색어가 됩니다.
가장 여러 번 이슈 검색어가 된 검색어가 여러 개일 경우 사전 순으로 빠른 검색어가 최고의 이슈 검색어가 됩니다.
예를 들어, "a"가 2번 이슈 검색어가 되었고 "c"도 2번 이슈 검색어가 되었다면 "a"가 최고의 이슈 검색어가 됩니다.
그 전월의 사용자들의 검색 기록을 일 기준으로 나눈 1차원 문자열 배열 research, 정수 n, k가 매개변수로 주어집니다. 그 전월의 최고의 이슈 검색어를 조사하여 return 하도록 solution 함수를 완성해 주세요. 최고의 이슈 검색어가 없으면 "None"을 return해 주세요.

제한사항
2 ≤ research의 길이(=그 전월의 일 수) ≤ 30
2 ≤ research의 원소의 길이 ≤ 100
research의 원소는 "검색어1검색어2..." 형태입니다. 하루 동안 검색된 검색어를 순서 없이 붙여 놓은 형태입니다.
검색어의 길이 = 1
검색어는 알파벳 소문자 중 하나입니다.
검색어는 서로 겹칠 수 있습니다.
예를 들어, "abaa"는 하루에 "a"가 3번 "b"가 1번 검색됐다는 뜻입니다.
research에는 1일부터 하루 동안 검색된 검색어들이 차례대로 담겨져있습니다.
1 ≤ n ≤ research의 길이
1 ≤ k ≤ 100
입출력 예
research	n	k	result
["abaaaa","aaa","abaaaaaa","fzfffffffa"]	2	2	"a"
["yxxy","xxyyy"]	2	1	"x"
["yxxy","xxyyy","yz"]	2	1	"y"
["xy","xy"]	1	1	"None"
입출력 예 설명
입출력 예 #1

총 4일 동안의 검색 기록이 주어졌습니다.
아래 표는 전월의 모든 검색어를 날마다 몇 번 검색되었는지 정리한 표입니다.

검색어	1일	2일	3일	4일
a	5	3	7	1
b	1	0	1	0
f	0	0	0	8
z	0	0	0	1
연속된 2(=n)일 동안 날마다 2(=k)번 이상 검색되고, 같은 연속된 2(=n)일 동안 총 8번(=2 x 2 x 2) 이상 검색된 검색어는 1일부터 2일까지 그리고 2일부터 3일까지 검색된 "a"뿐입니다. (4일에 k번 미만으로 검색되었으므로 3일부터 4일까지의 "a"는 이슈 검색어가 아닙니다.) 1일부터 2일까지 그리고 2일부터 3일까지 두 번 이슈 검색어가 된 "a"를 제외한 다른 검색어는 한 번도 이슈 검색어가 되지 못했습니다.
따라서 "a"를 return 합니다.

입출력 예 #2

총 2일 동안의 검색 기록이 주어졌습니다.
아래 표는 전월의 모든 검색어를 날마다 몇 번 검색되었는지 정리한 표입니다.

검색어	1일	2일
x	2	2
y	2	3
연속된 2(=n)일 동안 날마다 1(=k)번 이상 검색되고, 같은 연속된 2(=n)일 동안 총 4번(=2 x 2 x 1) 이상 검색된 검색어는 "x"와 "y"이고 두 검색어 모두 1일부터 2일까지 한 번만 이슈 검색어가 되었습니다.
따라서 사전 순으로 더 빠른 "x"를 return 합니다.

입출력 예 #3

총 3일 동안의 검색 기록이 주어졌습니다.
아래 표는 전월의 모든 검색어를 날마다 몇 번 검색되었는지 정리한 표입니다.

검색어	1일	2일	3일
x	2	2	0
y	2	3	1
z	0	0	1
연속된 2(=n)일 동안 날마다 1(=k)번 이상 검색되고, 같은 연속된 2(=n)일 동안 총 4번(=2 x 2 x 1) 이상 검색된 검색어는 "x"와 "y"입니다. 이때 "x"는 1일부터 2일까지 단 한 번만 이슈 검색어가 되었고 "y"는 1일부터 2일까지 그리고 2일부터 3일까지 2번 이슈 검색어가 되었습니다.
따라서 더 많이 이슈 검색어가 된 "y"를 return 합니다.

입출력 예 #4

총 2일 동안의 검색 기록이 주어졌습니다.
아래 표는 전월의 모든 검색어를 날마다 몇 번 검색되었는지 정리한 표입니다.

검색어	1일	2일
x	1	1
y	1	1
연속된 1(=n)일 동안 날마다 1(=k)번 이상 검색되고, 같은 연속된 1(=n)일 동안 총 2번(=2 x 1 x 1) 이상 검색된 검색어는 없습니다.
따라서, 이슈 검색어가 없으므로 "None"을 return 합니다.
	 */
	
	public Question2_solved() {
		// TODO Auto-generated constructor stub
	}
	
	public String solution(String[] research, int n, int k) {
		/*
		 * 0 == total
		 * 0 = linear days 
		 */
		HashMap<String, int[]> word_data = new HashMap<String, int[]>();
		HashMap<String, int[]> table = new HashMap<String, int[]>();
		
		//똑같은 테이블 생성 
		for (int i = 0; i < research.length; i++) {
			String[] words = research[i].split("");
			
			for (int j = 0; j < words.length; j++) {
				String word = words[j];
				int[] records;

				if (!table.containsKey(word)) {
					records = new int[research.length];
					records[i] = 1;
				} else {
					records = table.get(word);
					records[i] += 1;
				}
				table.put(word, records);
				
			}
		}
		//이슈 검색어 연속 최대 몇일 확인된 검색어만 추가하기 위한 변수 
		int linear_max = 0;
		
		//테이블 관련 데이터 가지고 조건에 맞게 데이터 해쉬맵에 추가 
		//필요한 데이터 : 단어당 => 연속 몇일, 총 몇번 검색되었는지 확인 
		for (Map.Entry<String, int[]> table_set : table.entrySet()) {
			String word = table_set.getKey();
			int[] records = table.get(word);
			int total = 0;
			int linear = 0;

			for (int i = 0; i < records.length; i++) {
				total += records[i];
				
				if (i == 0) {
					continue;
				}
				
				if (records[i - 1] > k && records[i] != 0) {
					linear++;
				}
			}
			
			if (linear_max < linear) {
				linear_max = linear;
			}
			
			word_data.put(word, new int[] {total, linear});
			
		}
		
		//모든 조건을 만족하는 검색어는 passed 담기 
		LinkedList<String> passed = new LinkedList<String>();
		//총 검색 횟수가 조건에 만족하는지 확인하는 변수 
		int qualified = 2 * n * k;
		
		//데이터 세트의 자료를 가지고 조건에 만족하면 passed에 담기 
		for (Map.Entry<String, int[]> word_data_set : word_data.entrySet()) {
			String word = word_data_set.getKey();
			int[] data = word_data.get(word);
			int total = data[0];
			int linear = data[1];
			
			if (total >= qualified && linear == linear_max && linear_max != 0) {
				passed.add(word);
			}
			
		}
		
		//조건들을 만족한 검색어가 없으면 none return
		if (passed.size() == 0) {
			return "None";
		}
		
		//조건 만족한 검색어가 있을시 오름차순으로 검색해서 첫번째 리턴
		Collections.sort(passed);
		
		return passed.get(0);
    }
	
	public static void main(String[] args) {
		Question2_solved solution = new Question2_solved();
		String[] research = {"abaaaa","aaa","abaaaaaa","fzfffffffa"};
		int n = 2;
		int k = 2;
		
//		String[] research = {"yxxy","xxyyy"};
//		int n = 2;
//		int k = 1;
		
//		String[] research = {"yxxy","xxyyy","yz"};
//		int n = 2;
//		int k = 1;
		
//		String[] research = {"xy","xy"};
//		int n = 1;
//		int k = 1;
		
		System.out.println(solution.solution(research, n, k));
	}
}
