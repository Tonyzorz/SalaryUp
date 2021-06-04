package programmers.level1.소수만들기;

public class Solution_taewon {

	/*	
	문제 설명
	
	주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
	숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 
	소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
			
	제한사항
	nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
	nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
	
	nums			result
	[1,2,7,6,4]		4
	
	[1,2,4]를 이용해서 7을 만들 수 있습니다.
	[1,4,6]을 이용해서 11을 만들 수 있습니다.
	[2,4,7]을 이용해서 13을 만들 수 있습니다.
	[4,6,7]을 이용해서 17을 만들 수 있습니다.
	
	*/
	public Solution_taewon() {
		// TODO Auto-generated constructor stub
	}
	
    public int solution(int[] nums) {
    	
        int numOfPrime = 0;
        int arrayLength = nums.length;
        
        for(int i = 0; i < arrayLength - 2; i++) {
        	
        	int first = nums[i];
        	
        	for(int j = i + 1; j < arrayLength - 1; j++) {
        		
        		int second = nums[j];
        		
        		for(int k = j + 1; k < arrayLength; k++) {
        			
        			int third = nums[k];
        			int total = first + second + third;
        			//System.out.println("totalSum = " + total);
        			
        			if(isPrime(total)) numOfPrime++;
        			
        		}
        	}
        }
        
        return numOfPrime;
    }
    
    public boolean isPrime(int num) {
    	
    	for(int i = 2; i < num; i++) {
    		if(num % i == 0) return false;
    	}
    	
    	//System.out.println("prime number is === " + num);
    	return true;
    }
    
	public static void main(String[] args) {
		Solution_taewon solution = new Solution_taewon();
		
		int[] nums = {1,2,7,6,4};
		
		int answer = solution.solution(nums);
		
		System.out.println(answer);
	}
}
