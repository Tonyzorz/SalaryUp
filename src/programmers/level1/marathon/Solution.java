package programmers.level1.marathon;

import java.util.*;

public class Solution {

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
	public Solution() {
		// TODO Auto-generated constructor stub
	}
	
	//O(n^2) 나와서 효율성 다운. 프로그래머스 통과 못함 
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        //completion 사람이 완주했느지 확인하는 array
        boolean[] check = new boolean[completion.length];
        
        //참가자들  
        for(int i = 0; i < participant.length; i++) {
        	
        	boolean isComplete = false;
        	
        	//완주자들
        	for(int j = 0; j < completion.length; j++) {
        		
        		//완주자가 확인 되었으면 continue, 다음 완주자 명단 확인 
        		if(check[j]) {
        			continue;
        		}
        		
        		//완주 == 참가자, check 명당에 true, 다음 참가자 확인
        		if(participant[i].contentEquals(completion[j])) {
        			isComplete = true;
        			check[j] = true;
        			break;
        		}
        	}
        	
        	//당시이 완주자 명단에 없는 선수이군요, 당신이 답이오 
        	if(!isComplete) {
        		answer = participant[i];
        		break;
        	}
        	
        }
        return answer;
    }
	
	//O(n) 효율성 통과 
	public String solution_hashMap(String[] participant, String[] completion) {
        String answer = "";
        
        //중복 키 방지 HashMap
        Map<String, Integer> hm = new HashMap<>();
        
        //key = 참가자 이름 
        //value = 참가자 수 
        //참가자 - 완주자 = 0. 만약 for each를 둘다 돌린후에도 value값이 1이면 미완주자. 
        for(String part : participant) {
        	if(hm.get(part) == null) {
        		hm.put(part, 1);
        	} else {
        		int value = hm.get(part) + 1;
        		hm.put(part, value);
        	}
        		
        }
        
        for(String comp : completion) {
        	int value = hm.get(comp) - 1;
        	hm.put(comp, value);
        }
        
        for(String key : hm.keySet()) {
        	if(hm.get(key) == 1) {
        		answer = key;
        	}
        }
        return answer;
    }
	/*
	 * participants
	 * completion
	 * 
	 */
	public void dfs() {
		
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		String answer = solution.solution_hashMap(participant, completion);
		
		System.out.println(answer);
	}
}
