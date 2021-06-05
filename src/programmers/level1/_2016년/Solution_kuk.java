public class Solution {
    /*
        1. a달이 아니면 다음달 1일까지 계산
        2. a달 이면 그 달의 요일 계산
    */
    public String solution(int a, int b) {
        int day = 0;
        String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] calender = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i <= a; i++) {
            if (i == a) {//2
                day = (day + (b - 1) % 7) % 7; // a달의 요일 계산
            } else // 1
                day = (day + calender[i]) % 7; // 다음달 1일이 무슨요일인지 계산
        }
        return dayOfWeek[day];
    }
}
