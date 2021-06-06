class Solution {
    /*
        1. 앞에 부호있으면 숫자에 1 or -1 곱해서 return
        2. 숫자만 있으면 숫자만 return
    */
    public int solution(String s) {
        if (!Character.isDigit(s.charAt(0)))
            return Integer.parseInt(s.substring(1)) * (s.charAt(0) == 43 ? 1 : -1);
        return Integer.parseInt(s);
    }
}
