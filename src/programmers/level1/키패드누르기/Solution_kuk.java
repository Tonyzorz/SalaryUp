import java.util.*;

class Solution {
    /*
        0. keyPad에 번호 좌표값 입력
        1. 1,4,7 왼손
        2. 3,6,9 오른손
        3. 2,5,8,0 가까운 사람, 같은면 hand에 맞게
    */
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        ArrayList<int[]> keyPad = new ArrayList<>();
        int[] rightHand = {3, 2}, leftHand = {3, 0};

        setKeyPad(keyPad);

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append("L");
                leftHand = keyPad.get(numbers[i]);
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer.append("R");
                rightHand = keyPad.get(numbers[i]);
            } else {
                int left = Math.abs(leftHand[0] - keyPad.get(numbers[i])[0]) +
                        Math.abs(leftHand[1] - keyPad.get(numbers[i])[1]);
                int right = Math.abs(rightHand[0] - keyPad.get(numbers[i])[0]) +
                        Math.abs(rightHand[1] - keyPad.get(numbers[i])[1]);

                if (left == right) {
                    if(hand.equals("left")) {
                        answer.append("L");
                        leftHand = keyPad.get(numbers[i]);
                    } else {
                        answer.append("R");
                        rightHand = keyPad.get(numbers[i]);
                    }
                } else if(left < right) {
                    answer.append("L");
                    leftHand = keyPad.get(numbers[i]);
                } else {
                    answer.append("R");
                    rightHand = keyPad.get(numbers[i]);
                }
            }
        }
        System.out.println(answer);
        return answer.toString();
    }

    void setKeyPad(ArrayList<int[]> keyPad) {
        int row = 0, col = 0;
        keyPad.add(new int[]{3, 1});

        for (int i = 1; i <= 9; i++) {
            keyPad.add(new int[]{row, col});
            col++;

            if (i % 3 == 0) {
                row++;
                col = 0;
            }
        }
    }
}
