class Solution {
    /*
        1. 약수구하면서 더하기
    */
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                answer += i;
        }

        return answer;
    }
}
