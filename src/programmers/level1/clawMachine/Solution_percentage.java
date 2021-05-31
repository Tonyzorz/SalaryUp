package programmers.level1.clawMachine;

import java.util.*;

public class Solution_percentage {

	public Solution_percentage() {
		// TODO Auto-generated constructor stub
	}
	public class Stage{
		private int stage;
		private float percentage;
		
		public int getStage() {
			return this.stage;
		}
		
		public float getPercentage() {
			return this.percentage;
		}
		
		public Stage(int stage, float percentage) {
			this.stage = stage;
			this.percentage = percentage;
		}
	}
	
	public int[] solution(int N, int[] stages) {
    	//총 단계 방 사이즈 잡기 
        int[] answer = new int[N];
        int totalFailed = 0;
        int failedPeople = 0;
        ArrayList<Stage> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
        	
        	//현 stage 통과 못한 사람들 찾기 
        	for(int j = 0; j < stages.length; j++) {
        		if(stages[j] <= i + 1) {
        			failedPeople++;
        		}
        	}
        	
        	//확율 계산은 = 실패한사람 - 이전 실패자들 / 총단계 - 이전 실패자들
        	float value = (float)(failedPeople - totalFailed) / (stages.length - totalFailed) ;
        	
        	//이전 단계를 통과 못했으면 당연히 후 단계도 통과 못하니 totalFailed 담음 
        	totalFailed = failedPeople;
        	//failedPeople 초기화 
        	failedPeople = 0;
        	
        	list.add(new Stage(i + 1, value));
        }

//        for(int i = 0; i < list.size(); i++) {
//        	System.out.println("stage = " + list.get(i).getStage() + " .. percentage = " + list.get(i).getPercentage());
//        }
        
        Collections.sort(list, (a, b) -> {
        	if(b.getPercentage() == a.getPercentage()) {
        		System.out.println("true");
        		return a.getStage() - b.getStage();
        	}
        	return Float.compare(b.getPercentage(), a.getPercentage());
		});
        

        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i).getStage();
        }
        return answer;
    }
	public static void main(String[] args) {
		Solution_percentage solution = new Solution_percentage();
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		System.out.println(solution.solution(N, stages));
	}
}
