import java.util.*;

public class Solution {
    /*
        1. 예산 정렬
        2. 작은거 최대한 다 더해본 개수 리턴
    */
    public int solution(int[] d, int budget) {
        int answer = 0, sum = 0;
        Arrays.sort(d);


        for (int i : d) {
            sum += i;
            if (budget < sum)
                break;
            answer++;
        }
        return answer;
    }
}
