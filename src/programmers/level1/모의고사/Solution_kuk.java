import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] count = new int[4], arr1 = {1, 3, 4, 5}, arr2 = {3, 1, 2, 4, 5};
        int num = -1, index = -1, len = 1;

        for (int i = 0; i < answers.length; i++) {
            if ((i % 5) + 1 == answers[i])
                count[1] += 1;

            if (i % 2 == 0) {
                num++;
                if (num == 4)
                    num = 0;
                if (answers[i] == 2)
                    count[2] += 1;
            } else if (i % 2 != 0 && answers[i] == arr1[num]) {
                count[2] += 1;
            }

            if (i % 2 == 0) {
                index++;
                if (index == 5)
                    index = 0;
                if (answers[i] == arr2[index])
                    count[3] += 1;
            } else if (i % 2 != 0 && answers[i] == arr2[index]) {
                count[3] += 1;
            }
        }
        int max = Math.max(count[1], Math.max(count[2], count[3]));
        for (int i = 1; i <= 3; i++) {
            if (count[i] == max)
                list.add(i);
        }
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
