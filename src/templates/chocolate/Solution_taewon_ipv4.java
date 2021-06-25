package templates.chocolate;

import java.util.*;

public class Solution_taewon_ipv4 {

	/*
	 * 
	 */
	public Solution_taewon_ipv4() {
		// TODO Auto-generated constructor stub
	}
	

	public static String validateIPv4(final String ip) {
	    String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";

	    return ip.matches(PATTERN) ? "IPv4" : "no";
	}
	
	public static String validateIPv6(final String ip) {
	   // String PATTERN = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
	    String PATTERN = "([a-f0-9:]+:+)+[a-f0-9]+";

	    return ip.matches(PATTERN) ? "IPv6" : "no";
	}
	
	public static void main(String[] args) {
		Solution_taewon_ipv4 solution = new Solution_taewon_ipv4();
		String str = "";
		/*
		 * 10100 2
		 * 01010 4
		 * 010 0
		 * 11111 6 
		 */
	    
	    String isip = "121.18.19.20";
	    String isip1 = "0.12.12.34";
	    String isip2 = "23.45.12.56";
	    String isip3 = "0.1.2.3";
	    String isip4 = "121.234.12.12";
	    
	    
	    String isip5 = "2001:0db8:0000:0000:0000:ff00:0042:8329";
	    String isip6 = "::1";
	    String isip7 = "121.18.19.20";
	    String isip8 = "121.18.19.20";
	    
	    System.out.println(validateIPv4(isip4));
	    System.out.println(validateIPv6(isip5));
	}
}
