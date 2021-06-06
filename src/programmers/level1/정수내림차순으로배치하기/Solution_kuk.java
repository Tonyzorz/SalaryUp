import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /*
        1. 음양같네
    */
    public long solution(long n) {
        String[] arr = Long.toString(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        
        return Long.parseLong(Arrays.stream(arr).collect(Collectors.joining()));
    }
}
