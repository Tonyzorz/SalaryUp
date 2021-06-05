class Solution {
    /*
        1. a,b 작은거랑 큰거 찾기
        2. 더하기
    */
    public long solution(int a, int b) {
        long answer = 0;
        int start = Math.min(a, b), end = Math.max(a, b);
        for (int i = start; i <= end; i++)
            answer += i;

        return answer;
    }
}
