class Solution {
    /*
        1. 음양같네
    */
    public int[] solution(long n) {
        String[] arr = Long.toString(n).split("");
        int len = arr.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++)
            answer[i] = Integer.parseInt(arr[len - i - 1]);
        
        return answer;
    }
}
