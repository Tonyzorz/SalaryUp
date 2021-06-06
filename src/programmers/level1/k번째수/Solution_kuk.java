import java.util.*;

class Solution {
    /*
        1. array 잘라서 복사
        2. 복사한 배열 정렬
        3. 정렬한 배열에서 k번째 수 뽑기
    */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] copyArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(copyArr);
            answer[i] = copyArr[commands[i][2] - 1];
        }
        return answer;
    }
}
