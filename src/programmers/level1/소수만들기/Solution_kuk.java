import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int[] nums) {
        dfs(nums, new boolean[nums.length], 0, 0);
        return answer;
    }

    void dfs(int[] nums, boolean[] visit, int start, int size) {
        if (size == 3) {
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                if (visit[i])
                    sum += nums[i];
            }
            if (check(sum))
                answer++;
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                visit[i] = true;
                dfs(nums, visit, i + 1, size + 1);
                visit[i] = false;
            }
        }
    }

    boolean check(int num) {
        if (num % 2 == 0 || num == 1)
            return false;
        else if (num % 2 == 1) {
            for (int i = 3; i <= Math.sqrt(num); i += 2) {
                if (num % i == 0)
                    return false;
            }
        }
        return true;
    }
}
