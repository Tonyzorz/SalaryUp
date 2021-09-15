package interview.naver_line_2021.question6;

import java.util.*;

public class Question6_1 {

	/*
	 * 문제 설명
한 온라인 쇼핑몰에서 재구매율을 기준으로 상품을 정렬하는 기능을 추가하려고 합니다. 재구매율은 어떤 상품을 구매한 모든 고객들 중 해당 상품을 다시 구매하는 고객들의 비중이 얼마나 높은지 나타내는 지표입니다.
재구매율을 계산하는 방법은 아래와 같습니다.

재구매율 = (상품을 재구매한 고객 수) / (상품을 한 번 이상 구매한 고객 수) * 100
재구매율을 구할 때 중요한 것은 통계를 내고자 하는 기간을 정하는 것입니다. 기간을 정하지 않고 단순히 위의 식을 이용해 재구매율을 계산하면, 일반적으로 출시된 지 오래된 상품이 재구매율이 높아 보이는 문제가 발생합니다. 따라서 재구매율을 구하고자 하는 기준 날짜와 그 기간(=재구매 기간)을 정한 뒤 재구매율을 계산하려고 합니다.

아래 표는 구입 기록을 나타내는 예시이며, 날짜를 기준으로 오름차순 정렬되어 있습니다. 이 문제에서 모든 달은 30일까지 있다고 가정합니다. 다시 말해, 1월도 31일이 아닌 30일까지만 존재한다고 가정하며 2월 또한 30일까지 존재한다고 가정합니다.

날짜	유저 아이디	상품 아이디
2020-02-02	uid1	pid1
2020-02-26	uid1	pid1
2020-02-26	uid2	pid1
2020-02-27	uid3	pid2
2020-02-28	uid4	pid2
2020-02-29	uid3	pid3
2020-03-01	uid4	pid3
2020-03-03	uid1	pid1
2020-03-04	uid2	pid1
2020-03-05	uid3	pid2
2020-03-05	uid3	pid3
2020-03-05	uid3	pid3
2020-03-06	uid1	pid4
모든 고객과 상품은 각자 고유한 아이디를 가집니다. 유저의 아이디는 uid로, 상품의 아이디는 pid로 시작하며 뒤에 자연수 번호가 붙습니다. 편의상 고객과 상품을 번호로 부르겠습니다. 상품 1, 2, 3, 4의 재구매 기간은 10일로 동일합니다. 재구매율을 계산하고자 하는 기준 날짜는 3월 5일입니다. 다음과 같이 각 상품의 재구매율을 구할 수 있습니다.

재구매율을 구하는 기간은 기준 날짜인 3월 5일을 포함한 10일간입니다. 따라서 2월 26일부터 3월 5일까지의 기록을 바탕으로 계산합니다. 모든 달이 30일까지 있다는 점에 주의합니다.

1번 상품을 구입한 고객은 2명이며, 2명 모두 1번 상품을 재구매한 고객입니다. 따라서 재구매율은 100%입니다.
2번 상품을 구입한 고객은 3번 고객과 4번 고객입니다. 4번 고객은 2번 상품을 한 번 구매한 고객이며, 3번 고객은 2번 상품을 두 번 구매한 고객입니다. 따라서 재구매율은 50%입니다. 또한 총 구매 횟수는 3입니다.
3번 상품을 구입한 고객은 3번 고객과 4번 고객입니다. 4번 고객은 3번 상품을 한 번 구매한 고객이며, 3번 고객은 3번 상품을 세 번 구매한 고객입니다. 따라서 재구매율은 50%입니다. 또한 총 구매 횟수는 4입니다.
4번 상품은 조사하고자 하는 기간 내에 구매한 기록이 없으므로 고려하지 않습니다.
상품을 재구매율을 기준으로 내림차순 정렬합니다. 재구매율이 같다면 총 구매 횟수가 높은 순으로, 총 구매 횟수까지 같다면 상품 아이디가 낮은 순으로 정렬합니다. 1번 상품은 재구매율이 100%이므로 1위, 3번 상품은 2번 상품과 재구매율이 50%로 같지만 총 구매 횟수가 더 많기 때문에 2위, 2번 상품은 3위입니다. 따라서 상품을 pid1, pid3, pid2 순으로 정렬할 수 있습니다.

구매 기록을 담은 문자열 배열 records, 재구매 기간을 나타내는 정수 k, 재구매율을 계산하는 기준 날짜를 나타내는 문자열 date가 매개변수로 주어집니다. 재구매율을 기준으로 내림차순 정렬한 상품 아이디를 배열에 담아 return 하도록 solution 함수를 완성해주세요. 단, 재구매율이 같다면 총 구매 횟수로 내림차순 정렬하며, 총 구매 횟수가 같다면 상품 아이디의 번호를 기준으로 오름차순 정렬해주세요. 빈 배열을 반환하는 경우, 문자열 "no result"를 배열에 담아 return 해주세요.

제한사항
1 ≤ records의 길이 ≤ 100,000
records의 원소는 "날짜 uid유저번호 pid상품번호" 형식이며 하나의 공백으로 구분되어 있습니다.
날짜는 YYYY-MM-DD 형식이며 2020-01-01과 2020-12-30 사이에 있습니다.
모든 달은 30일까지 존재합니다. 즉, 1월과 같이 31일까지 존재하는 달도 30일까지만 존재한다고 가정합니다.
records는 날짜를 기준으로 오름차순 정렬되어 있습니다.
1 ≤ 유저번호 ≤ 100,000
1 ≤ 상품번호 ≤ 100,000
유저번호와 상품번호는 숫자로만 이루어져 있습니다.
10 ≤ k ≤ 365
date는 YYYY-MM-DD 형식이며 2020-01-01과 2020-12-30 사이에 있습니다.
2월 30일과 같이 실제로 존재하지 않는 날짜도 주어질 수 있습니다.
입출력 예
records	k	date	result
["2020-02-02 uid1 pid1", "2020-02-26 uid1 pid1", "2020-02-26 uid2 pid1", "2020-02-27 uid3 pid2", "2020-02-28 uid4 pid2", "2020-02-29 uid3 pid3", "2020-03-01 uid4 pid3", "2020-03-03 uid1 pid1", "2020-03-04 uid2 pid1", "2020-03-05 uid3 pid2", "2020-03-05 uid3 pid3", "2020-03-05 uid3 pid3", "2020-03-06 uid1 pid4"]	10	"2020-03-05"	["pid1", "pid3", "pid2"]
["2020-02-02 uid141 pid141", "2020-02-03 uid141 pid32", "2020-02-04 uid32 pid32", "2020-02-05 uid32 pid141"]	10	"2020-02-05"	["pid32", "pid141"]
["2020-01-01 uid1000 pid5000"]	10	"2020-01-11"	["no result"]
입출력 예 설명
입출력 예 #1

문제 예시와 같습니다.

입출력 예 #2

records 배열의 모든 원소가 재구매율을 계산하고자 하는 기간에 속합니다. 32번 상품과 141번 상품 모두 재구매한 고객이 없기 때문에 재구매율은 0%입니다. 총 구매 횟수 또한 2로 같습니다. 따라서 상품 아이디의 번호 높낮이를 기준으로 오름차순 정렬하여 ["pid32", "pid141"]를 return 합니다. "pid32"와 "pid141"을 사전 순으로 정렬하여 ["pid141", "pid32"]를 return 하는 것이 아님에 주의합니다.

입출력 예 #3

records 배열의 모든 원소가 재구매율을 계산하고자 하는 기간 내에 속하지 않습니다. 따라서 ["no result"]을 return 합니다.
	 */
	
	public Question6_1() {
		// TODO Auto-generated constructor stub
	}
	
	public String[] solution(String[] records, int k, String date) {
		
		/*
		 * user + item , 재구매 여부 
		 */
		HashMap<String, Boolean> boughtPeople = new HashMap<String, Boolean>();
		
		/*
		 * [0] = 재구매 (상품을 재구매한 고객 수)
		 * [1] = 총구매 
		 * [2] = 이 상품을 구매한 사용자 수 (상품을 한 번 이상 구매한 고객 수)
		 */
		HashMap<String, int[]> boughtRecords = new HashMap<String, int[]>();
		ArrayList<String> answer = new ArrayList<String>();
		
		int dateConverted = convertDate(date);
		
		//기록을 가지고 구매자 및 물품 기준으로 정리하기 
		for (int i = 0; i < records.length; i++) {
			
			String[] record = records[i].split(" ");
			int recordDate = convertDate(record[0]);
			
			//해당 기간안에 있다 
			if ((dateConverted - k) < recordDate && dateConverted >= recordDate) {
				
				//user 
				String uid = record[1];
				//item 
				String pid = record[2];
				//key 생성
				String key = uid + "_" + pid;
				//기간안에 구매 기록이 있으니 답에 추가
				//소팅 순서는 나중에 확인 
				if (!answer.contains(pid)) {
					answer.add(pid);
				}
				
				//해당 유저가 처음 물품을 구매시  
				if (!boughtPeople.containsKey(key)) {
					//구매했다고 기록해주고 
					boughtPeople.put(key, false);
					
					int[] statistics;
					//해당 구매 기록이 없을시
					if (!boughtRecords.containsKey(pid)) {
						statistics = new int[3];
						statistics[0] = 0;
						statistics[1] = 1;
						statistics[2] = 1;
					
					//구매 기록이 있을시 
					} else {
						statistics = boughtRecords.get(pid);
						statistics[1]++;
						statistics[2]++;
					}
					
					boughtRecords.put(pid, statistics);
				}
				//구매한 기록이 있으면 
				else {
					int[] statistics = boughtRecords.get(pid);
					Boolean repurchased = boughtPeople.get(key);
					
					//재구매시 
					if (!repurchased) {
						statistics[0]++;
						boughtPeople.put(key, true);
					}
					
					statistics[1]++;
					
					boughtRecords.put(pid, statistics);
				}
			}
		}
		
		//조건에 맞는 기록이 없으면 
		if (answer.size() == 0) {
			
			String[] noResult = new String[1];
			noResult[0] = "\"no result\"";
			
			return noResult;
			
		}
		
		//조건에 기록이 있을시 소팅 시작 
		Collections.sort(answer, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int[] first_statistics = boughtRecords.get(o1);
				int[] second_statistics = boughtRecords.get(o2);
				
				float first_percentage = (float) first_statistics[0] / first_statistics[2];
				float second_percentage = (float) second_statistics[0] / second_statistics[2];
				
				//재구매율이 높은 제품을 우선순위 리턴
				if (first_percentage > second_percentage) {
					return -1;
				} else if (first_percentage < second_percentage) {
					return 1;
				
				//만약 구매율이 동일하다면
				} else if (first_percentage == second_percentage){
					
					int first_total = first_statistics[1];
					int second_total = second_statistics[1];
					
					//구매 건수가 높은 우선순위 리턴
					if (first_total > second_total) {
						return -1;
					} else if (first_total < second_total) {
						return 1;
						
					//구매 건수까지 똑같으면 id순위로 정렬 (사전순위 아님!)
					} else if (first_total == second_total) {
						
						int first_id = Integer.parseInt(o1.substring(3, o1.length()));
						int second_id = Integer.parseInt(o2.substring(3, o2.length()));
						
						return first_id - second_id;
					}
				}
				
				return 0;
			}

		});
		
		//리턴 해주기 위해 String[]으로 converting 
		String[] answer_array = new String[answer.size()];
		for (int i = 0; i < answer.size(); i++) {
			answer_array[i] = "\"" + answer.get(i) + "\"";
		}
		
		return answer_array;
	}
	
	public int convertDate(String date) {
		String[] dates = date.split("-");

		int month = (Integer.parseInt(dates[1]) - 1) * 30;
		int day = Integer.parseInt(dates[2]);
		
		int total = month + day;

		return total;
	}
	
	public static void main(String[] args) {
		Question6_1 solution = new Question6_1();
		
		String[] records = {"2020-02-02 uid1 pid1", "2020-02-26 uid1 pid1", "2020-02-26 uid2 pid1", "2020-02-27 uid3 pid2", "2020-02-28 uid4 pid2", "2020-02-29 uid3 pid3", "2020-03-01 uid4 pid3", "2020-03-03 uid1 pid1", "2020-03-04 uid2 pid1", "2020-03-05 uid3 pid2", "2020-03-05 uid3 pid3", "2020-03-05 uid3 pid3", "2020-03-06 uid1 pid4"};
		int k = 10;
		String date = "2020-03-05";
		
//		String[] records = {"2020-02-02 uid141 pid141", "2020-02-03 uid141 pid32", "2020-02-04 uid32 pid32", "2020-02-05 uid32 pid141"};
//		int k = 10;
//		String date = "2020-02-05";
		
//		String[] records = {"2020-01-01 uid1000 pid5000"};
//		int k = 10;
//		String date = "2020-01-11";
		
		
		System.out.println(Arrays.toString(solution.solution(records, k, date)));
	}
}
