class Solution {
        /*
        1. 최대 공약수는 큰값~1까지에서 0으로 떨어지는 수
        2. 최소 공배수는 큰값~큰값*작은값에서 나누어 떨어지는 수
    */
    public int[] solution(int n, int m) {
        int max = Math.max(n, m), min = Math.max(n, m);
        int greatest = 0, Least = 0;

        for (int i = max; i >= 1; i--) {
            if (n % i == 0 && m % i == 0) {
                greatest = i;
                break;
            }
        }

        for (int i=max;i<=max*min;i++){
            if (i % n == 0 && i % m == 0) {
                Least = i;
                break;
            }
        }
        return new int[]{greatest, Least};
    }
}
