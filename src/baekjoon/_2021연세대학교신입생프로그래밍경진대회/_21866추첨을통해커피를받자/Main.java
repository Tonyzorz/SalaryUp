package baekjoon._2021연세대학교신입생프로그래밍경진대회._21866추첨을통해커피를받자;

import java.util.*;

public class Main {

    public static void main (String[] args){
    	Scanner sc = new Scanner(System.in);
    	int[] maximumScore = {100, 100, 200, 200, 300, 300, 400, 400, 500};
        int totalScore = 0;
        int score = 0;
        
        for (int i = 0; i < maximumScore.length; i++) {
        	score = sc.nextInt();
        	
        	if (score > maximumScore[i]) {
        		System.out.println("hacker");
        		return;
        	}
        	
        	totalScore += score;
        	
        	if (totalScore >= 100) {
        		System.out.println("draw");
        		return;
        	}
        }
        
        System.out.println("none");
    }
    
}
