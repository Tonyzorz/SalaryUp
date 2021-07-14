package baekjoon._2021연세대학교신입생프로그래밍경진대회._21867JavaBitecode;

import java.util.*;

public class Main {

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        StringBuffer sb = new StringBuffer();
//        s = s.replace("J", "");
//        s = s.replace("A", "");
//        s = s.replace("V", "");
//        
//        if (s.length() == 0) {
//        	System.out.println("nojava");
//        } else {
//        	System.out.println(s);
//        }
        
        for (int i = 0; i < n; i++) {
        	char c = s.charAt(i);
        	if (c != 'J' && c != 'V' && c != 'A') sb.append(c);  
        }
        
        if (sb.length() == 0) System.out.println("nojava");
        else System.out.println(sb.toString());
    }
    
}
