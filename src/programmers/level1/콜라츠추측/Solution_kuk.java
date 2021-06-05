class Solution {
/*
        1-1. 입력된 수가 짝수라면 2로 나눕니다.
        1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
        2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
        3. 500번해도 1이 안나오면 -1 return
    */
    public int solution(int num) {
        int answer = 0;
        long number = num;

        while (number != 1) {
            if (answer == 500)
                return -1;
            if (number % 2 == 0)
                number /= 2;
            else
                number = number * 3 + 1;
            answer++;
        }
        return answer;
    }
}
