import java.util.*;

public class Solution {
    /*
        1.
    */
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}
