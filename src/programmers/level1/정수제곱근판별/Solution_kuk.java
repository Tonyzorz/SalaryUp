class Solution {
    /*
        1. 제곱근인지 확인
        2. 맞으면 +1해서 제곱한거 return
        3. 아니면 -1 return
    */
    public long solution(long n) {
        if (Math.sqrt(n) - (long) Math.sqrt(n) != 0.0)
            return -1;
        return (long) (Math.sqrt(n) + 1) * (long) (Math.sqrt(n) + 1);
    }
}
