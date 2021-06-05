import java.util.*;

public class Solution {
    /*
        1. 재귀로 모든 경우의 수 set에 저장
        2. 정렬해서 리턴
    */
    Set<Integer> numSet;

    public int[] solution(int[] numbers) {
        int index = 0;
        numSet = new HashSet<>();
        dfs(numbers, 0, 0, 0);

        int[] answer = new int[numSet.size()];
        Iterator<Integer> iterator = numSet.iterator();

        while (iterator.hasNext()){
            answer[index++]=iterator.next();
        }
        Arrays.sort(answer);
        
        return answer;
    }

    void dfs(int[] numbers, int count, int num, int index) {
        if (count == 2) {
            numSet.add(num);
            return;
        } else {
            for (int i = index; i < numbers.length; i++) {
                dfs(numbers, count + 1, num + numbers[i], i + 1);
            }
        }
    }
}
