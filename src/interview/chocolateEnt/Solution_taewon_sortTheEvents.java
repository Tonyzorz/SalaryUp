package interview.chocolateEnt;

import java.util.*;

public class Solution_taewon_sortTheEvents {

	/*
	 * 
	 */
	public Solution_taewon_sortTheEvents() {
		// TODO Auto-generated constructor stub
	}
	//GYR === employee-name time event-name 
	//S ===   employee-name time event-name second-employee-name
	
	public String[] getEventsOrder(String team1, String team2, String[] events1, String[] events2) {
		
		
		ArrayList<ArrayList<String>> allEvents = new ArrayList<ArrayList<String>>();
		
		//First events to allEvents
		for(int i = 0; i < events1.length; i++) {
			
			String[] split = events1[i].split(" ");
			
			ArrayList<String> tempArray = new ArrayList<String>();
			tempArray.add(team1);
			
			
			for(String str : split) {
				tempArray.add(str);
			}
			
			allEvents.add(tempArray);
		}
		
		//Second events to allEvents
		for(int i = 0; i < events2.length; i++) {
			
			String[] split = events2[i].split(" ");
			
			ArrayList<String> tempArray = new ArrayList<String>();
			tempArray.add(team2);
			for(String str : split) {
				tempArray.add(str);
			}
			
			allEvents.add(tempArray);
		}
		
//		System.out.println("before sorting ==============");
//		for(int i = 0; i < allEvents.size(); i++) {
//			System.out.println(allEvents.get(i));
//		}
//		
		Collections.sort(allEvents, new Comparator<ArrayList<String>>() {

			@Override
			public int compare(ArrayList<String> o1, ArrayList<String> o2) {
				// TODO Auto-generated method stub
				String firstStr = o1.get(2).contains("+") ? o1.get(2).replace("+", ".") : o1.get(2);
				String secondStr = o2.get(2).contains("+") ? o2.get(2).replace("+", ".") : o2.get(2);
				
				float first = Float.parseFloat(firstStr);
				float second = Float.parseFloat(secondStr);
				
				return (int)(first - second);
			}
			
			
		});
		
//		System.out.println("before after ==============");
//		for(int i = 0; i < allEvents.size(); i++) {
//			System.out.println(allEvents.get(i));
//		}		
//		
		
		//convert ArrayList to String[]
		String[] array = new String[allEvents.size()];
		for(int i = 0; i < allEvents.size(); i++) {
			StringBuffer sb = new StringBuffer();
			
			for(int j = 0; j < allEvents.get(i).size(); j++) {
				sb.append(allEvents.get(i).get(j) + " ");
			}
			array[i] = sb.toString().trim();
//			System.out.println(array[i]);
		}
		
		return array;
	}
	public static void main(String[] args) {
		Solution_taewon_sortTheEvents solution = new Solution_taewon_sortTheEvents();
		String team1 = "edc";
		String[] events2 = {"alex 12 G", "sam 43 Y"};
		String team2 = "cde 23423 423423423 423423234 ";
		String[] events1 = {"kris 45+1 S avery", "robin 46 G"};
		
		System.out.println(Arrays.toString(solution.getEventsOrder(team1, team2, events1, events2)));
	}
}
