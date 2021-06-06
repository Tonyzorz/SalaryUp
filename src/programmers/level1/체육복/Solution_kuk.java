import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int i : reserve)
            reserveSet.add(i);

        for (int i : lost) {
            if (!reserveSet.contains(i))
                lostSet.add(i);
            else
                reserveSet.remove(i);
        }

        reserveSet.forEach(num -> {
            int back = num - 1, front = num + 1;

            if (lostSet.contains(back))
                lostSet.remove(back);
            else if (lostSet.contains(front))
                lostSet.remove(front);
        });
        
        return n - lostSet.size();
    }
}
