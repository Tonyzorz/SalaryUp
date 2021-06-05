import java.util.*;

class Solution {
    /*
        1. num에 숫자 저장
        2. num과 arr의 숫자 비교해서 같으면 x, 다르면 list에 add
    */
    public int[] solution(int[] arr) {
        int num = arr[0];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (num != arr[i]) {
                num = arr[i];
                list.add(num);
            }
        }
        int[] answer = new int[list.size()];
        
        for(int i=0;i<answer.length;i++)
            answer[i]=list.get(i);

        return answer;
    }
}
