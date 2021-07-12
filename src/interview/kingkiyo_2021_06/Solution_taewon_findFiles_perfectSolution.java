package interview.kingkiyo_2021_06;

import java.util.*;

class Solution_taewon_findFiles_perfectSolution {
    int size = 245760;
    int year = 1990;
    String month = "Jan";

    public String solution(String s) {
        int size = 245760;
        int year = 1990;
        String month = "Jan";
        String[] files = s.split("\n");
        //System.out.println(Arrays.toString(files));
        
        int cnt = 0;
        for (String file : files) {
        	//System.out.println(file);
        	file = file.trim();
        	
        	String infos[] = file.split(" ");
        	
        	if(Integer.parseInt(infos[0]) >= size) {
        		
        		if (Integer.parseInt(infos[3]) > year) {
                    cnt++;
                    
                } else if (Integer.parseInt(infos[3]) == year && !infos[2].contentEquals(month)) {
                	
                    cnt++;
                }
        	}
        }
        
        return cnt == 0 ? "NO FILES" : Integer.toString(cnt);
    }

	public static void main(String[] args) {
		Solution_taewon_findFiles_perfectSolution solution = new Solution_taewon_findFiles_perfectSolution();
		String S = " 779091968 23 Sep 2009 system.zip\r\n" + 
					" 284164096 14 Aug 2013 to-do-list.xml\r\n" + 
					" 714080256 19 Jun 2013 blockbuster.mpeg\r\n" + 
					"       329 12 Dec 2010 notes.html\r\n" + 
					" 444596224 17 Jan 1950 delete-this.zip\r\n" + 
					"       641 24 May 1987 setup.png\r\n" + 
					"    245760 16 Jul 2005 archive.zip\r\n" + 
					" 839909376 31 Jan 1990 library.dll\r\n";
		System.out.println(solution.solution(S));
	}
}
