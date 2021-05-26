package programmers.level1.marathon;

import java.util.*;

public class Solution_geok {

	/*
	 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
	 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
		completion의 길이는 participant의 길이보다 1 작습니다.
		참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
		참가자 중에는 동명이인이 있을 수 있습니다.
		
		participant	|| completion || 	return
		["leo", "kiki", "eden"] || 	["eden", "kiki"] || 	"leo"
		["marina", "josipa", "nikola", "vinko", "filipa"] || 	["josipa", "filipa", "marina", "nikola"] || 	"vinko"
		["mislav", "stanko", "mislav", "ana"] || 	["stanko", "ana", "mislav"] || 	"mislav"
	 */
	public Solution_geok() {
		// TODO Auto-generated constructor stub
	}
	
	class Solution {
		
	}
	
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