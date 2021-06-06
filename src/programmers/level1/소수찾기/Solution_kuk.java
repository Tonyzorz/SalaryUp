class Solution {
    /*
        0. arr 배열에서 소수이면 false, 소수가 아니면 true
        1. 0,1은 소수가 아니니까 true
        2. arr를 돌면서 false인걸 만나면 소수이므로 answer+1
           2,3,4,5....를 곱해서 나온 모든 수는 소수가 아니므로 true로 표현
    */
    public int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[n + 1];
        
        // 1
        arr[0] = true;
        arr[1] = true;

        // 2
        for (int i = 2; i <= n; i++) {
            if (!arr[i]) {
                int num = 2;

                while (i * num <= n) {
                    arr[i * num++] = true;
                }
                answer++;
            }
        }
        return answer;
    }
}
