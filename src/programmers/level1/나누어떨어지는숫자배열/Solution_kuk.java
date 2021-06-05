import java.util.*;

class Solution {
    /*
        1. arr for문 돌리면서 divisor나누어 떨어지는지 확인
        2. 나누어떨어지는게 없으면 -1로 return
        3. 있으면 정렬해서 return
    */
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if (i % divisor == 0)
                list.add(i);
        }
        if (list.size()==0)
            return new int[] {-1};
        
        Collections.sort(list);
        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++)
            answer[i] = list.get(i);
        return answer;
    }
}
