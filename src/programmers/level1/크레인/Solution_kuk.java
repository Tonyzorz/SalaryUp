import java.util.*;

class Solution {
    /*
        1. move 열에 있는 가장 위에 값 가져오고 board에서는 0으로 바꿈
        2. 가져온 값을 stack의 top과 비교 해서 같으면 없애고 answer+1
           다르거나 stack이 비어있으면 stack push
        3. 이걸 moves의 크기만큼 반복
     */
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int col : moves) {
            int num = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][col - 1] != 0) {
                    num = board[i][col - 1];
                    board[i][col - 1] = 0;
                    break;
                }
            }
            if (checkEqual(basket, num))
                answer += 2;
        }
        System.out.println(basket + " " + answer);
        return answer;
    }

    boolean checkEqual(Stack<Integer> basket, int num) {
        if (!basket.isEmpty() && basket.peek() == num) {
            basket.pop();
            return true;
        } else if (num == 0)
            return false;

        basket.push(num);
        return false;
    }
}
