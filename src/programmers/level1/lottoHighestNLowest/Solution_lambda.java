package programmers.level1.lottoHighestNLowest;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Solution_lambda {

	/*
	 * 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다
	 * 
	 * 순위	당첨 내용
		1	6개 번호가 모두 일치
		2	5개 번호가 일치
		3	4개 번호가 일치
		4	3개 번호가 일치
		5	2개 번호가 일치
		6(낙첨)	그 외
		
		민우가 구매한 로또 번호 6개가 44, 1, 0, 0, 31 25라고 가정해보겠습니다.
		당첨 번호 6개가		    31_, 10, 45, 1_, 6, 19라면, 당첨 가능한 최고 순위와 최저 순위의 한 예는 아래와 같습니다.
		[4,2]
		
	 */
	public Solution_lambda() {
		// TODO Auto-generated constructor stub
	}
	
	
   public int[] solution(int[] lottos, int[] winNums) {
        return LongStream.of(
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
        )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
    }
	
	public static void main(String[] args) {
		Solution_lambda solution = new Solution_lambda();
		
		//int[] lottos = {44, 1, 0, 0, 31, 25};
		//int[] win_nums = {31, 10, 45, 1, 6, 19};
		// [3, 5]
		
		int[] lottos = {0, 0, 0, 0, 0, 0};
		int[] win_nums = {38, 19, 20, 40, 15, 25};
		// [1, 6]
		
//		int[] lottos = {45, 4, 35, 20, 3, 9};
//		int[] win_nums = {20, 9, 3, 45, 4, 35};
		// [1, 1]
		
		int[] answer = solution.solution(lottos, win_nums);
		
		System.out.println(Arrays.toString(answer));
	}
}
