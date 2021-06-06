import java.util.*;

class Solution {
    /*
        0단계 set에 들어갈수 있는 문자 입력
        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
            만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     */
    public String solution(String new_id) {
        //0단계
        Set<String> specialString = new HashSet<>();
        setSpecialString(specialString);
        boolean flag = false;

        //1단계
        StringBuilder answer = new StringBuilder(new_id.toLowerCase());

        //2단계
        for (int i = 0; i < answer.length(); i++) {
            if (!specialString.contains(Character.toString(answer.charAt(i)))) {
                answer.deleteCharAt(i);
                i--;
            }
        }

        //3단계
        for (int i = 0; i < answer.length(); i++) {
            if (flag) { // . 연속으로 나올때
                if (Character.toString(answer.charAt(i)).equals(".")) {
                    answer.deleteCharAt(i);
                    i--;
                } else
                    flag = false;
            } else { // .이 처음 나올때
                if (Character.toString(answer.charAt(i)).equals(".")) {
                    flag = true;
                }
            }
        }

        //4단계
        if (answer.length() > 0 && Character.toString(answer.charAt(answer.length() - 1)).equals("."))
            answer.deleteCharAt(answer.length() - 1);
        if (answer.length() > 0 && Character.toString(answer.charAt(0)).equals("."))
            answer.deleteCharAt(0);

        //5단계
        if (answer.length() == 0)
            answer.append("a");

        //6단계
        if (answer.length() >= 16) {
            answer = new StringBuilder(answer.substring(0, 15));
            if (Character.toString(answer.charAt(answer.length() - 1)).equals("."))
                answer.deleteCharAt(answer.length() - 1);
        }

        //7단계
        if (answer.length() <= 2) {
            String str = Character.toString(answer.charAt(answer.length() - 1));
            while (answer.length() < 3) {
                answer.append(str);
            }
        }
        
        return answer.toString();
    }

    void setSpecialString(Set<String> set) {
        set.add("-");
        set.add("_");
        set.add(".");

        for (int i = 0; i <= 9; i++) {
            set.add(Integer.toString(i));
        }

        for (int i = 97; i <= 122; i++) {
            set.add(Character.toString((char) i));
        }
    }
}
