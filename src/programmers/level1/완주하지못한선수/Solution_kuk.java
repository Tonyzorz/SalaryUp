import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> completionMap = new HashMap<>();

        for (String person : completion) {
            if (completionMap.containsKey(person))
                completionMap.put(person, completionMap.get(person) + 1);
            else
                completionMap.put(person, 1);
        }

        for (String person : participant) {
            if (!completionMap.containsKey(person))
                return person;
            else {
                if (completionMap.get(person) > 0)
                    completionMap.put(person, completionMap.get(person) - 1);
                else
                    return person;
            }
        }
        return answer;
    }
}
