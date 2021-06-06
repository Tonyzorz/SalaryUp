import java.util.*;

class Solution {
    /*
        1. arr1,arr2 2진수로 변경
        2. 비교해서 합침
    */
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String one = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replaceAll(" ", "0"), two = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replaceAll(" ", "0");
            StringBuilder str = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (one.charAt(j) == two.charAt(j))
                    str.append(one.charAt(j));
                else
                    str.append("1");
            }
            answer[i] = str.toString().replaceAll("0", " ").replaceAll("1", "#");
        }
        return answer;
    }
}
