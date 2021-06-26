package interview.kingkiyo;

import java.util.*;

public class Solution_taewon_createEmails {

	/*
	 * 
	 */
	public Solution_taewon_createEmails() {
		// TODO Auto-generated constructor stub
	}
	
	public String solution(String S, String C) {
        // write your code in Java SE 8
		String[] fullNames = S.split(", ");
		LinkedHashMap<String, Integer> hm = new LinkedHashMap<String,Integer>();
		ArrayList<String> emails = new ArrayList<String>();
		
		//System.out.println(Arrays.toString(fullNames));
		
		for(int i = 0; i < fullNames.length; i++) {
			//System.out.println(fullNames[i]);
			String[] partialNames = fullNames[i].split(" ");
			//System.out.println(Arrays.toString(partialNames));
			//System.out.println(partialNames.length);
			
			if(partialNames.length > 2) {
				partialNames[2] = partialNames[2].replaceAll("-", "");
				//System.out.println("==============" + partialNames[2]);
				String name = partialNames[0] + "." + partialNames[2];
				name = name.toLowerCase();
				//System.out.println("???" + name);
				
				if(hm.containsKey(name)) {
					
					int duplNum = hm.get(name) + 1;
					String email = "<" + name + duplNum + "@" + C.toLowerCase() + ".com>";
					emails.add(fullNames[i] + " " + email);
					hm.put(name, duplNum);
				}  else {
					
					hm.put(name, 1);
					
					String email = "<" + name + "@" + C.toLowerCase() + ".com>";
					emails.add(fullNames[i] + " " + email);
				}
			} else {
				partialNames[1] = partialNames[1].replaceAll("-", "");
				String name = partialNames[0] + "." + partialNames[1];
				name = name.toLowerCase();
				if(hm.containsKey(name)) {
					
					int duplNum = hm.get(name) + 1;
					String email = "<" + name + duplNum + "@" + C.toLowerCase() + ".com>";
					emails.add(fullNames[i] + " " + email);
					hm.put(name, duplNum);
				}  else {
					
					hm.put(name, 1);
					
					String email = "<" + name + "@" + C.toLowerCase() + ".com>";
					emails.add(fullNames[i] + " " + email);
				}
			}

		}
		
		//System.out.println(emails);
		String zzz = emails.toString();
		zzz = zzz.substring(1, zzz.length() - 1);
		return zzz;
    }
	
	public static void main(String[] args) {
		Solution_taewon_createEmails solution = new Solution_taewon_createEmails();
		String S = "John Doe, Peter Benjamin Parker, Mary Jane Watson-Parker, John Elvis Doe, John Evan Doe, Jane Doe, Peter Brian Parker";
		String C = "Example";
		System.out.println(solution.solution(S, C));
	}
}
