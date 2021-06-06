class Solution {
    /*
        1. n의 반만큼 수박 append
        2. n이 홀수면 수 append
    */
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= n / 2; i++)
            answer.append("수박");
        if (n % 2 != 0)
            answer.append("수");
        
        return answer.toString();
    }
}
