package programmers.level1.percentageOfFailure;

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
        ArrayList<Stage> list = new ArrayList<>();
        
        // new taewon 
        int totalFailed2 = 0;
        int[] currentStage = new int[N + 2];
        for(int i = 0; i < stages.length; i++) {
        	
        	currentStage[stages[i]]++;
        	//System.out.println("after input == " + Arrays.toString(currentStage));
        }
        //i == stages[] 안에 있는 값(스테이지에 있는 사람) 
        for(int i = 1; i <= N; i++) {
        	float percentage = (float)currentStage[i]/(stages.length - totalFailed2);
        	totalFailed2 += currentStage[i];
        	list.add(new Stage(i, percentage));
        }

        Collections.sort(list, (a, b) -> {
        	if(b.getPercentage() == a.getPercentage()) {
        		//System.out.println("true");
        		return a.getStage() - b.getStage();
        	}
        	return Float.compare(b.getPercentage(), a.getPercentage());
		});
        
//        for(int i = 0; i < list.size(); i++) {
//        	System.out.println("stage = " + list.get(i).getStage() + " .. percentage = " + list.get(i).getPercentage());
//        }
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
