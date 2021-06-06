import java.util.*;

class Solution {
    /*
        1. nums를 set으로 변환
        2. set의 크기가 nums의 반보다 크면 /2한 값 리턴
        3. set의 크기가 nums의 반보다 작으면 set 크기 리턴
     */
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        return set.size() > nums.length / 2 ? nums.length / 2 : set.size();
    }
}
