package templates.chocolate;

import java.math.BigInteger;
import java.util.*;

public class Solution_taewon_binaryManipulation {

	/*
	 * 
	 */
	public Solution_taewon_binaryManipulation() {
		// TODO Auto-generated constructor stub
	}
	
	public int minOperations(long n) {
		int answer = 0;
		String strBinary = Long.toBinaryString(n);
		String[] splitBinary = strBinary.split("");
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(String str : splitBinary) {
			list.add(Integer.parseInt(str));
		}
		
		System.out.println(list);
		System.out.println(list.contains(1));
		while(list.contains(1)) {
			
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i) == 1) {
					
					int j = 0;
						
					for(j = i + 1; j < list.size(); j++) {
						
						if(list.get(j) == 1) {
							list.set(j, 0);
							
							break;
						} else if (j == list.size() - 1 && list.get(j) == 0) {
							list.set(j, 1);
							answer++;
							System.out.println(list);
							j = i + 1;
						}
					}
					
					System.out.println(list);
					list.set(i, 0);
					answer++;
					
				}
			}
		}
		
		return answer;
	}
	
	static BigInteger calculateStepsRequired(long number) {
	    // Take sign bit
	    int bit = number < 0 ? 1 : 0;
	    BigInteger result = BigInteger.valueOf(bit);
	    for (int i = 0; i < 63; i++) {
	        number = number << 1;
	        System.out.println("number == " + number);
	        int sign = number < 0 ? 1 : 0;
	        System.out.println("sign == " + sign);
	        bit = (bit + sign) % 2;
	        System.out.println("bit == " + bit);
	        result = result.shiftLeft(1).add(BigInteger.valueOf(bit));
	        System.out.println("result == " + result);
	        System.out.println();
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		Solution_taewon_binaryManipulation solution = new Solution_taewon_binaryManipulation();
		//long n = 1000000000000000L;
		long n = 4;
		
		//System.out.println(solution.minOperations(n));
		System.out.println(solution.calculateStepsRequired(n));
	}
}
