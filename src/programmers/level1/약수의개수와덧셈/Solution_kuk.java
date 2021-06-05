class Solution {
    /*
        1. 약수 개수 체크
        2. 연산
    */
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int num = divisor(i);

            if (num % 2 == 0)
                answer += i;
            else
                answer -= i;
        }
        return answer;
    }

    int divisor(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                count++;
        }
        return (int)Math.sqrt(num) * (int)Math.sqrt(num) == num ? (count * 2) - 1 : count * 2;
    }
}
