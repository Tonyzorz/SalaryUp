class Solution {
    /*
        1. x를 1개씩 잘라서 string 배열로 만든다
        2. 배열의 값을 다 더한다
        3. 나누어 떨어지는지 확인
    */
    public boolean solution(int x) {
        int sum = 0;
        String[] arr = Integer.toString(x).split("");
        for (int i = 0; i < arr.length; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        return x % sum == 0 ? true : false;
    }
}
