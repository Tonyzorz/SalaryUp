import java.util.*;

class Solution {
    /*
        1. win_nums를 set에 넣는다
        2. 반복문에서 lottos의 값이 set에 있으면 빼고 lottos의 0개 카운트
        3. 최고는 0개수만큼 더 맞는 경우, 최소는 set에서 뺀것만 맞은 것
     */
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();
        int zero = 0, best = 0, worst = 0;
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        // 1
        for (int i : win_nums)
            set.add(i);

        // 2
        for (int i : lottos) {
            if (set.contains(i))
                set.remove(i);
            else if (i == 0)
                zero++;
        }

        // 3
        worst = win_nums.length - set.size();
        best = worst + zero;

        return new int[]{rank[best], rank[worst]};
    }
}
