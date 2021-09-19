package interview.naver_line_2021.question5;

import java.util.*;

public class Question5 {

	/*
	 * 문제 설명
브라운은 자신이 만든 모바일 게임에, 이벤트 참여를 위해 동일한 유저가 여러 닉네임과 이메일로 중복 가입했다는 제보를 받았습니다. 고심하던 브라운은 다음과 같은 기준으로 두 유저가 동일한 유저인지 판단하려고 합니다.

어떤 두 유저의 닉네임과 이메일 주소가 모두 유사하면 동일한 유저라고 판단합니다. 또한 (a, b)가 동일 유저이고 (b, c)가 동일 유저라면, (a, c)는 동일 유저라고 간주합니다.

[I. 닉네임 유사성 판단 기준]

어떤 두 닉네임에서, 총 2개 이하의 문자를 삭제하여 동일하게 만들 수 있다면 두 닉네임은 유사하다고 판단합니다.
imhero111, imher1111은 각각 하나의 문자를 삭제하여 동일하게 만들 수 있으므로, 유사한 닉네임입니다.
imhero111
imher1111
imhero111, hero111은 첫 닉네임에서 두 개의 문자를 삭제하여 동일하게 만들 수 있으므로, 유사한 닉네임입니다.
imhero111
hero111
money55man, moneymann은 다음과 같이 최소 3개의 문자를 삭제해야만 동일하게 만들 수 있으므로, 유사한 닉네임이 아닙니다.
money55man
moneymann
[II. 이메일 주소 유사성 판단 기준]

이메일 주소는 @ 기호 앞부분인 계정이름과 뒷부분인 서버이름으로 나누어집니다.

예) ace12Boy@abcd.com
ace123Boy가 계정이름이며, abcd.com이 서버이름입니다.
다음 2개의 조건 중, 하나 이상에 해당하면 유사한 이메일이라고 판단합니다.

어떤 두 이메일 주소의 계정이름에서, 총 1개의 문자를 삭제하여 전체 이메일 주소를 동일하게 만들 수 있으면 유사하다고 판단합니다.
superman5@abcd.com, superyman5@abcd.com은 계정이름에서 총 1개의 문자를 삭제하여 전체 이메일 주소를 동일하게 만들 수 있으므로 유사한 이메일입니다.
superman5@abcd.com
superyman5@abcd.com
aaabaaa@qwer.pe, aaaaaa@abcd.pe는 계정이름 부분만 놓고 보면 1개의 문자를 삭제하여 동일하게 만들 수 있지만, 서버이름이 달라서 전체 이메일 주소가 같아질 수 없으므로, 유사한 이메일이 아닙니다.
aaabaaa@qwer.pe
aaaaaa@abcd.pe
어떤 두 이메일 주소의 계정이름이 동일하면, 서버이름과 상관없이 유사하다고 판단합니다.
superman@abcd.com, superman@erty.net은 서버이름은 다르지만, 계정이름이 동일하므로 유사한 이메일 주소입니다.
superman@abcd.com
superman@erty.net
브라운이 만든 모바일 게임에 가입된 유저들의 닉네임이 담긴 문자열 배열 nicks, 이메일 주소가 담긴 문자열 배열 emails가 매개변수로 주어집니다. 위에서 주어진 기준으로 동일 유저를 판단했을 때, 실제로 가입한 유니크(Unique) 유저의 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
nicks에는 1번 유저의 닉네임부터 차례대로 담겨있습니다.
1 ≤ nicks의 길이 ≤ 100
3 ≤ nicks의 원소의 길이 ≤ 20
nicks의 원소는 알파벳 소문자와 숫자로만 이루어진 문자열입니다.
nicks에 중복된 원소는 담겨있지 않습니다. 즉, 모든 닉네임은 서로 다릅니다.
emails에는 1번 유저의 이메일 주소부터 차례대로 담겨있습니다.
emails의 길이 = nicks의 길이
9 ≤ emails의 원소의 길이 ≤ 41
emails의 원소는 알파벳 소문자, 숫자, 특수문자('@', '.')로만 이루어진 문자열입니다.
emails의 각 원소에서, '@'는 정확히 1번만 등장합니다.
emails의 각 원소는 "계정이름@서버이름" 형식입니다.
3 ≤ 계정이름의 길이 ≤ 20
계정이름은 알파벳 소문자와 숫자로만 이루어진 문자열입니다.
5 ≤ 서버이름의 길이≤ 20
서버이름은 알파벳 소문자와 특수문자('.')로만 이루어진 문자열입니다.
emails에 중복된 원소는 담겨있지 않습니다. 즉, 모든 이메일은 서로 다릅니다.
emails에 담긴 모든 이메일 주소는 올바른 형식의 이메일 주소라고 가정합니다.
입출력 예
nicks	emails	result
["imhero111", "moneyman", "hero111", "imher1111", "hro111", "mmoneyman", "moneymannnn"]	["superman5@abcd.com", "batman432@korea.co.kr", "superman@abcd.com", "supertman5@abcd.com", "superman@erty.net", "batman42@korea.co.kr", "batman432@usa.com"]	3
["99police", "99poli44"]	["687ufq687@aaa.xx.yyy", "87ufq687@aaa.xx.yyy"]	2
["99polico", "99policd"]	["687ufq687@aaa.xx.yyy", "587ufq687@aaa.xx.yyy"]	2
입출력 예 설명
입출력 예 #1

닉네임	이메일 주소
imhero111	superman5@abcd.com
hero111	superman@abcd.com
1, 3번 유저는 동일 유저입니다.
 

닉네임	이메일 주소
imhero111	superman5@abcd.com
imher1111	supertman5@abcd.com
1, 4번 유저는 동일 유저입니다.
 

닉네임	이메일 주소
hero111	superman@abcd.com
hro111	superman@erty.net
3, 5번 유저는 동일 유저입니다.
 

닉네임	이메일 주소
moneyman	batman432@korea.co.kr
mmoneyman	batman42@korea.co.kr
2, 6번 유저는 동일 유저입니다.
 

7번 유저와 동일한 유저는 없습니다.

즉, 유니크 유저는 [ (1, 3, 4, 5), (2, 6), (7) ] 3명입니다.

입출력 예 #2

닉네임	이메일 주소
99police	687ufq687@aaa.xx.yyy
99poli44	87ufq687@aaa.xx.yyy
이메일 주소는 계정이름에서 단 하나의 문자를 삭제하여 전체 이메일 주소를 동일하게 만들 수 있으므로, 유사하다고 판단할 수 있습니다.
하지만, 닉네임은 최소 4개의 문자를 삭제해야만 동일하게 만들 수 있으므로, 유사하지 않다고 판단합니다.
따라서, 1, 2번 유저는 동일한 유저가 아닙니다.
입출력 예 #3

닉네임	이메일 주소
99polico	687ufq687@aaa.xx.yyy
99policd	587ufq687@aaa.xx.yyy
닉네임은 2개의 문자를 삭제하여 전체 이메일 주소를 동일하게 만들 수 있으므로, 유사하다고 판단할 수 있습니다.
하지만, 이메일 주소는 계정이름에서 2개의 문자를 삭제해야만 동일하게 만들 수 있으므로, 유사하지 않다고 판단합니다.
닉네임과 이메일 주소의 유사성을 판단하는 기준은 상이함을 주의해주세요.
따라서, 1, 2번 유저는 동일한 유저가 아닙니다.
	 */
	
	public Question5() {
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<ArrayList<Integer>> uniques = new ArrayList<>();
	public static boolean[] isAdded;
	
	//유저네임이 유사한지 체크하는 메소드 
	public static boolean isSameNickname_failed(String firstNick, String secondNick) {
		
		ArrayList<String> longerNick = new ArrayList<String>();
		
		boolean isFirst = true;
		//긴 길이를 ArrayList에 한자리마다 담기 
		if (firstNick.length() > secondNick.length()) {
			
			for (int i = 0; i < firstNick.length(); i++) {
				longerNick.add(String.valueOf(firstNick.charAt(i)));
			}
			
		} else {
			isFirst = false;
			
			for (int i = 0; i < secondNick.length(); i++) {
				longerNick.add(String.valueOf(secondNick.charAt(i)));
			}
			
		}
		
		String firstTemp = firstNick;
		String secondTemp = secondNick;
		//짧은 nickname을 ArrayList에 하나식 제거 
		if (isFirst) {
			
			for (int i = 0; i < secondNick.length(); i++) {
				longerNick.remove(String.valueOf(secondNick.charAt(i)));
				firstTemp = firstTemp.replace(String.valueOf(secondNick.charAt(i)), "");
			}
			
		} else {
			
			for (int i = 0; i < firstNick.length(); i++) {
				longerNick.remove(String.valueOf(firstNick.charAt(i)));
				secondTemp = secondTemp.replace(String.valueOf(secondNick.charAt(i)), "");

			}
		}
		
		int total = 0;
		if (isFirst) {
			total = firstTemp.length() + longerNick.size();
		} else {
			total = secondTemp.length() + longerNick.size();
		}
		
		return total <= 2 ? true : false;
	}
	
	public static ArrayList<String> convertToArrayList(String str) {
		
		ArrayList<String> converted = new ArrayList<String>();
		
		for (int i = 0; i < str.length(); i++) {
			converted.add(String.valueOf(str.charAt(i)));
		}
		
		return converted;
	}
	
	public static boolean isSameNickname(String firstNick, String secondNick) {
		
		ArrayList<String> firstTemp = convertToArrayList(firstNick);
		ArrayList<String> secondTemp = convertToArrayList(secondNick);
		
		for (int i = 0; i < secondNick.length(); i++) {
			firstTemp.remove(String.valueOf(secondNick.charAt(i)));
		}
		
		for (int i = 0; i < firstNick.length(); i++) {
			secondTemp.remove(String.valueOf(firstNick.charAt(i)));
		}
		
		int total = firstTemp.size() + secondTemp.size();
		
		return total <= 2 ? true : false;
	}
	
	//유사한 유저들을 uniques란 arraylist에 추가해주는 메소드
	public static void addUniques(int firstIndex, int secondIndex) {
		
		boolean isContains = false;
		
		for (int i = 0; i < uniques.size(); i++) {
			ArrayList<Integer> indexes = uniques.get(i);
			
			if (indexes.contains(firstIndex)) { 
				uniques.get(i).add(secondIndex);
				isContains = true;
				break;
				
			} else if (indexes.contains(secondIndex)) {
				uniques.get(i).add(firstIndex);
				isContains = true;
				break;
			}
			
		}
		
		//만약 index 둘다 존재 하지 않으면 ArrayList안에 담아서 uniques에 넣어주기 
		if (!isContains) {
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			indexes.add(firstIndex);
			indexes.add(secondIndex);
			uniques.add(indexes);
		} 
	}
	
	//유저 이메일 유사한지 체크하는 메소드 
	public static boolean isSameEmail(String firstEmail, String secondEmail) {
		
		String[] first = firstEmail.split("@");
		String[] second = secondEmail.split("@");
		
		//이메일 앞부분이 동일하면 유사한 이메일 
		if (first[0].equals(second[0])) {
			return true;
		}
		
		//이메일 앞부분 확인 
		ArrayList<String> firstTemp = convertToArrayList(firstEmail);
		ArrayList<String> secondTemp = convertToArrayList(secondEmail);
		
		for (int i = 0; i < secondEmail.length(); i++) {
			firstTemp.remove(String.valueOf(secondEmail.charAt(i)));
		}
		
		for (int i = 0; i < firstEmail.length(); i++) {
			secondTemp.remove(String.valueOf(firstEmail.charAt(i)));
		}
		
		int total = firstTemp.size() + secondTemp.size();
		//모든 문자를 삭제했는데 1가 남으며 서버도 같을시 유사한 이메일 
		if (total <= 1 && first[1].equals(second[1])) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isSameEmail_failed(String firstEmail, String secondEmail) {
		
		String[] first = firstEmail.split("@");
		String[] second = secondEmail.split("@");
		
		//이메일 앞부분이 동일하면 유사한 이메일 
		if (first[0].equals(second[0])) {
			return true;
		}
		
		//이메일 앞부분 확인 
		ArrayList<String> longerEmail = new ArrayList<String>();
		
		boolean isFirst = true;
		//긴 길이를 ArrayList에 한자리마다 담기 
		if (first[0].length() > second[0].length()) {
			
			for (int i = 0; i < first[0].length(); i++) {
				longerEmail.add(String.valueOf(first[0].charAt(i)));
			}
			
		} else {
			isFirst = false;
			
			for (int i = 0; i < second[0].length(); i++) {
				longerEmail.add(String.valueOf(second[0].charAt(i)));
			}
			
		}
		
		//짧은 email을 ArrayList에 하나식 제거 
		if (isFirst) {
			
			for (int i = 0; i < second[0].length(); i++) {
				longerEmail.remove(String.valueOf(second[0].charAt(i)));
			}
			
		} else {
			
			for (int i = 0; i < first[0].length(); i++) {
				longerEmail.remove(String.valueOf(first[0].charAt(i)));
			}
		}
		
		//모든 문자를 삭제했는데 1가 남으며 서버도 같을시 유사한 이메일 
		if (longerEmail.size() <= 1 && first[1].equals(second[1])) {
			return true;
		}
		
		return false;
	}
	
	//유니크한 유저들 반환하는 메소드
	public static int uniqueUsers() {
		
		int total = 0;
		for (boolean added : isAdded) {
			if (!added) total++;
		}
		
		return total;
	}
	/*
	 * 
	 */
	public int solution(String[] nicks, String[] emails) {
		
		isAdded = new boolean[nicks.length];
		
		//유저 닉네임 비교
		for (int i = 0; i < nicks.length - 1; i++) {
			String firstNick = nicks[i];
			String firstEmail = emails[i];
			for (int j = i + 1; j < nicks.length; j++) {
				String secondNick = nicks[j];
				String secondEmail = emails[j];
				
				if (isSameNickname(firstNick, secondNick) && isSameEmail(firstEmail, secondEmail)) {
					addUniques(i + 1, j + 1);
					isAdded[i] = true;
					isAdded[j] = true;
				}
			}
		}
		
		//유저 이메일 비교 
//		for (int i = 0; i < emails.length - 1; i++) {
//			String firstEmail = emails[i];
//			
//			for (int j = i + 1; j < emails.length; j++) {
//				String secondEmail = emails[j];
//				
//				if (isSameEmail(firstEmail, secondEmail)) {
//					addUniques(i + 1, j + 1);
//					isAdded[i] = true;
//					isAdded[j] = true;
//				}
//			}
//		}
		System.out.println(uniques);
		System.out.println(uniques.size());
		int total = uniques.size() + uniqueUsers();
		return total;
	}
	
	
	
	public static void main(String[] args) {
		Question5 solution = new Question5();
		String[] nicks = {"imhero111", "moneyman", "hero111", "imher1111", "hro111", "mmoneyman", "moneymannnn"};
		String[] emails = {"superman5@abcd.com", "batman432@korea.co.kr", "superman@abcd.com", "supertman5@abcd.com", "superman@erty.net", "batman42@korea.co.kr", "batman432@usa.com"};

//		String[] nicks = {"99police", "99poli44"}	;
//		String[] emails = {"687ufq687@aaa.xx.yyy", "87ufq687@aaa.xx.yyy"};
		
//		String[] nicks = {"99polico", "99policd"};
//		String[] emails = {"687ufq687@aaa.xx.yyy", "587ufq687@aaa.xx.yyy"}	;
		
		System.out.println(solution.solution(nicks, emails));
	}
}
