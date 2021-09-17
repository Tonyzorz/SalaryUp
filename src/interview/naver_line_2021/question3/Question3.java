package interview.naver_line_2021.question3;

import java.util.*;

public class Question3 {

	/*
	 * 문제 설명
당신은 밀려드는 많은 작업을 효율적으로 처리하기 위해 다음과 같은 규칙에 따라 일을 하려고 합니다. 모든 작업은 각각의 중요도를 갖고 있으며, 처리하는 방식에 따라 여러 분류로 나눠집니다. 같은 처리 방식에 익숙해지면 편하게 일을 할 수 있기 때문에, 어떤 분류의 작업을 처리하기로 했다면 해당 분류의 작업들을 모두 끝마칠 때까지 작업을 처리합니다. 처리하는 도중이거나 처리가 끝남과 동시에 같은 분류의 작업이 새로 요청되었다면, 새로운 작업도 이어서 처리합니다. 한 분류에 속하는 모든 작업을 끝냈다면, 계속해서 다른 분류 중 작업의 중요도 합이 가장 높은 분류를 선택하여 처리합니다. 만약 중요도 합이 가장 높은 분류가 여러 개라면, 분류 번호가 가장 낮은 분류를 선택하여 처리합니다.

위와 같은 규칙에 따라 분류를 옮겨가면서 모든 일을 처리했을 때, 처리한 분류 번호의 순서를 알아보고자 합니다.

아래 표는 요청 시각을 기준으로 정렬한 작업 목록입니다. 이 문제에서 요청 시각이 같은 작업은 주어지지 않습니다.

번호	요청 시각(초)	걸리는 시간(초)	분류 번호	중요도
1번		1			5			2	3
2번		2			2			3	2
3번		3			1			3	3
4번		5			2			1	5
5번		7			1			1	1
6번		9			1			1	1
7번		10			2			2	9

1초: 요청 시각이 가장 빠른 1번 작업(분류: 2)을 선택합니다. 처리에 걸리는 시간은 5초입니다.
1초~6초: 1번 작업을 처리합니다. 그동안 2번, 3번, 4번 작업이 새로 요청되어 대기합니다.
6초: 분류 3에 속한 2번, 3번 작업의 중요도 합은 5입니다. 분류 1에 속한 4번 작업의 중요도는 5입니다. 중요도가 같다면 분류 번호가 낮은 분류를 선택합니다. 따라서 분류 1의 작업을 선택합니다.
6초~9초: 4번 작업을 8초까지 처리합니다. 그동안 같은 분류인 5번 작업이 요청되었습니다. 따라서 5번 작업을 이어서 9초까지 처리합니다.
9초~10초: 분류 1의 작업을 끝냄과 동시에 같은 분류인 6번 작업이 요청됩니다. 방금 처리가 끝난 분류와 새로 요청된 작업의 분류가 같은 경우, 이어서 해당 분류의 작업을 처리합니다. 따라서, 6번 작업을 이어서 처리합니다.
10초: 6번 작업을 처리함과 동시에 분류 2의 7번 작업이 요청됩니다. 어떤 분류의 작업을 모두 마침과 동시에 다른 분류의 작업 요청이 들어오면, 해당 요청까지 고려하여 다음 분류를 선택합니다. 따라서, 중요도 합이 더 높은 분류 2의 7번 작업을 처리합니다.
10초~12초: 7번 작업을 처리합니다.
12초~15초: 분류 3에 속한 2번과 3번 작업을 처리합니다.
따라서 위 예시에서는 분류를 2 → 1 → 2 → 3 순서대로 옮기며 작업을 처리했습니다.

작업의 요청 시각, 처리하는데 걸리는 시간, 분류, 중요도를 담은 2차원 정수 배열 jobs가 매개변수로 주어집니다. 위 규칙대로 작업을 처리했을 때, 처리한 분류 번호를 시간 순서대로 담아 return 하도록 solution 함수를 완성해주세요. 단, 어떤 분류의 작업을 이어서 처리하지 않았더라도 같은 분류 번호가 연속해서 나오지 않도록 주의해주세요. 예를 들어, 처리한 작업의 분류 순서가 1 → 1 → 2 → 1 이라면, 배열 [1, 2, 1]을 return 합니다.

제한사항
1 ≤ jobs의 길이 ≤ 10,000
jobs의 원소는 [a, b, c, d] 형태입니다.
a는 작업이 요청된 시각을 의미합니다. 모든 작업의 요청 시각은 서로 다릅니다.
jobs는 요청 시각을 기준으로 오름차순 정렬되어 있습니다.
0 ≤ a ≤ 1,000,000
b는 작업을 처리하는데 걸리는 시간을 의미합니다.
1 ≤ b ≤ 10,000
c는 작업의 분류 번호를 의미합니다.
1 ≤ c ≤ 100
d는 작업의 중요도를 의미합니다.
1 ≤ d ≤ 100
입출력 예
jobs	result
[[1, 5, 2, 3], [2, 2, 3, 2], [3, 1, 3, 3], [5, 2, 1, 5], [7, 1, 1, 1], [9, 1, 1, 1], [10, 2, 2, 9]]	[2, 1, 2, 3]
[[1, 2, 1, 5], [2, 1, 2, 100], [3, 2, 1, 5], [5, 2, 1, 5]]	[1, 2]
[[0, 2, 3, 1], [5, 3, 3, 1], [10, 2, 4, 1]]	[3, 4]
[[0, 5, 1, 1], [2, 4, 3, 3], [3, 4, 4, 5], [5, 2, 3, 2]]	[1, 3, 4]
입출력 예 설명
입출력 예 #1

문제 예시와 같습니다.

입출력 예 #2

주어진 입력을 아래 표와 같이 정리할 수 있습니다.

번호	요청 시각(초)	걸리는 시간(초)	분류 번호	중요도
1번	1	2	1	5
2번	2	1	2	100
3번	3	2	1	5
4번	5	2	1	5
1초~3초: 가장 먼저 요청된 1번 작업(분류: 1)을 처리합니다. 그동안 2번 작업의 요청이 들어옵니다.
3초~5초: 3번 작업(분류: 1)이 1번 작업(분류: 1)이 끝남과 동시에 들어옵니다. 분류 번호가 같으므로 3번 작업을 처리합니다.
5초~7초: 4번 작업(분류: 1)이 3번 작업(분류: 1)이 끝남과 동시에 들어옵니다. 분류 번호가 같으므로 4번 작업을 처리합니다.
7초~8초: 남은 2번 작업(분류: 2)을 처리합니다.
순서대로 처리한 분류 번호는 1 → 2입니다. 따라서 배열 [1, 2]를 return 합니다.

입출력 예 #3

0초~2초: 1번 작업(분류: 3)을 처리합니다.
5초~8초: 2번 작업(분류: 3)을 처리합니다.
10초~12초: 3번 작업(분류: 4)을 처리합니다.
따라서 배열 [3, 4]를 return 합니다.

입출력 예 #4

0초~5초: 1번 작업(분류: 1)을 처리합니다. 2초에 2번 작업(분류: 3), 3초에 3번 작업(분류: 4)이 요청됩니다. 중요도 합은 각각 3, 5입니다.
5초: 1번 작업이 끝남과 동시에, 4번 작업(분류: 3)이 새로 요청됩니다. 해당 요청의 중요도까지 고려하면 3번 분류와 4번 분류의 중요도 합이 5로 같습니다. 따라서 번호가 낮은 3번 분류를 선택합니다.
5초~11초: 2번, 4번 작업(분류: 3)을 처리합니다.
11초~15초: 3번 작업(분류: 4)을 처리합니다.
따라서 배열 [1, 3, 4]를 return 합니다.
	 */
	
	public Question3() {
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<Integer> classifications = new ArrayList<Integer>();
	public static Queue<int[]> queue = new LinkedList<int[]>();
	public static Deque<int[]> waiting = new LinkedList<int[]>();
	public static int[] job;
	public static int seconds;
	
	/*
	 * 답에 작업중인 분류 추가하는 함수 
	 */
	public static void addAnswer() {
		//안에 분류 데이터가 있으며 
		if (!classifications.isEmpty()) {
			//맨 위에 있는 분류가 현재 작업중인 분류랑 다를시 추가해주기
			if (classifications.get(classifications.size() - 1) != job[2]) {
				classifications.add(job[2]);
			}
		//안에 데이터가 없을시 첫 분류 추가 
		} else {
			classifications.add(job[2]);
		}
	}
	
	/*
	 *대기 리스트에 작업 추가하는 함수  
	 * 대기 리스트 추가 조건에 안맞으면 false 리턴 
	 */
	public static boolean addProcesses() {
		
		//만약 걸리는 시간이 
		boolean isAdded = false;
		
		//총 걸리는 시간들을 처리해야되는 queue에 담기 
		while (!queue.isEmpty()) {
			int[] next = queue.peek();
			
			if (next[0] <= seconds) {
				isAdded = true;
				waiting.add(next);
				queue.poll();
			} else {
				break;
			}
		}
		
		return isAdded;
	}
	
	/*
	 * 대기 리스트안에 있는 작업 처리하는 함수
	 */
	public static void removeProcess() {
		
		int[] waiting_top = waiting.peekLast();
		
		//만약 위에있는 작업이랑 현재 작업의 분류가 같을시 위에 있는거 진행 
		if (waiting_top[2] == job[2]) {
			job = waiting.pollLast();
			seconds = job[0] + job[1];
		//분류가 다를시 대기중인 작업들중에 분류별 중요도 순위 정하기
		} else {
			
			int waiting_length = waiting.size();
			
			HashMap<Integer, Integer> importances = new HashMap<Integer, Integer>();
			int max = 0;
			
			//중요도 기준으로 찾기 
			for (int i = 0; i < waiting_length; i++) {
				int[] waiting_job = waiting.poll();
				int type = waiting_job[2];
				int importance = waiting_job[3];
				
				//해당 작업 키가 존재하면, 해당 키에 중요도 ++
				if (importances.containsKey(type)) {
					
					int total = importances.get(type) + importance;
					importances.put(type, total);
					
					if (max < total) {
						max = total;
					}
				//없을시 키 새로추가 
				} else {
					
					importances.put(type, importance);
					
					if (max < importance) {
						max = importance;
					}
				}
				
				waiting.add(waiting_job);
			}
			
			int key = Integer.MAX_VALUE;
			//제일 높은 중요도 값(max)을 가진 분류 번호 찾기(key)
			for (Integer importances_key : importances.keySet()) {
				int value = importances.get(importances_key);
				//높은 중요도와 같으면 낮은 분류 번호를 먼저 처리
				if (value == max) {
					//낮은 분류 번호를 key에 저장
					if (key > importances_key) {
						key = importances_key;
					}
				}
			}
			
			//다시 한번  waiting(대기)찾아서 처리, 이부분에 대해서 만약 동이란 중요도 분류 번호까지 똑같으면 오름차순, 내림차순에 따라서 for문의 위치 돌리기(문제에 제시되지 않음)
			boolean isFound = false;
			//지금 현재 최상위에 있는 작업이 같은 분류 + 중요도가 같으면 위에 있는거 작업하기 
			if (waiting_top[2] == key && waiting_top[3] == max) {
				
				int[] waiting_job = waiting.pollLast();
				job = waiting_job;
				seconds = job[0] + job[1];
				
			} else {
				
				for (int i = 0; i < waiting_length; i++) {
					int[] waiting_job = waiting.poll();
					int type = waiting_job[2];
					
					if (!isFound && type == key) {
						job = waiting_job;
						seconds = job[0] + job[1];
						isFound = true;
					} else {
						waiting.add(waiting_job);
					}
					
				}
			}
		}
	}
	
	//ArrayList 에서 int[]으로 변환 
	public static int[] convert() {
	
		int[] answer = new int[classifications.size()];
		for (int i = 0; i < classifications.size(); i++) {
			answer[i] = classifications.get(i);
		}
		
		return answer;
	}
	
	/*
	 * 고려했던 점들
	 * - 작업 목록 과 대기중인 작업 목록 두가지 
	 * 		대기중인 작업은 맨위에 있는 작업을 봐야하기 때문에 덱 deque 사용해야함 
	 * - 분류 똑같으면 연이어서 처리 
	 * - 중요도는 번호 중첩 
	 * - 중요도 똑같으면 낮은 분류 번호 처리 
	 * 
	 */
	public int[] solution(int[][] jobs) {
		
		for (int[] job : jobs) {
			queue.add(job);
		}
		
		job = queue.poll();
		seconds = job[0] + job[1];
		addAnswer();
		
		//작업리스트를 대기 작업 리스트에 옮기면서 처리하는 while문
		while (!queue.isEmpty()) {
			//작업을 처리하면서 걸리는 시간안에 해당하는 작업들은 waiting이란 deque에 추가하는 함수 
			boolean isAdded = addProcesses();
			
			//만약 추가한 작업이 없으면 걸리는 시간을 다음 작업의 요청 시간(초)로 변경
			if (!isAdded) {
				int[] next = queue.peek();
				seconds = next[0];
				continue;
			}
			
			//작업들 처리하기 
			removeProcess();
			
			//작업하는 분류 작업들 기록하는 함수 
			addAnswer();
		}
		
		//대기 작업 리스트에 작업들이 남으면 처리하는 while문
		while(!waiting.isEmpty()) {
			removeProcess();
			addAnswer();
		}
		
		//ArrayList 에서 int[]으로 변환 
		int[] answer = convert();
		
		return answer;
	}
	
	public static void main(String[] args) {
		Question3 solution = new Question3();
		int[][] jobs = {{1, 5, 2, 3}, {2, 2, 3, 2}, {3, 1, 3, 3}, {5, 2, 1, 5}, {7, 1, 1, 1}, {9, 1, 1, 1}, {10, 2, 2, 9}}	;
		//int[][] jobs = {{1, 2, 1, 5}, {2, 1, 2, 100}, {3, 2, 1, 5}, {5, 2, 1, 5}}	;
		//int[][] jobs = {{0, 2, 3, 1}, {5, 3, 3, 1}, {10, 2, 4, 1}};
		//int[][] jobs = {{0, 5, 1, 1}, {2, 4, 3, 3}, {3, 4, 4, 5}, {5, 2, 3, 2}};
		System.out.println(Arrays.toString(solution.solution(jobs)));
	}
}
