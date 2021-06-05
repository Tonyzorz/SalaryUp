import java.util.*;

public class Solution {
    /*
    N : 5,   stages : [2, 1, 2, 6, 2, 4, 3, 3]   result : [3,4,2,1,5]
    실패율은 다음과 같이 정의한다.
    스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        1. 스테이지 도달 횟수 카운트
        2. 클리어 못한 사람 = i, 스테이지에 도달한 사람 = arrive + i
        3. 실패율은 클리어 못한 사람/스테이지 도달한 사람
        4. Colletion정렬
        5.list array 변환
    */
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] countStage = new int[N + 2];
        ArrayList<Fail> fails = new ArrayList<>();

        for (int i : stages) {
            countStage[i]++;
        }
        int arrive = countStage[N + 1];

        for (int i = N; i >= 1; i--) {
            int index = i;
            double fail = countStage[i] != 0 ? (double) countStage[i] / (countStage[i] + arrive) : 0;
            arrive += countStage[i];

            fails.add(new Fail(index, fail));
        }

        Collections.sort(fails, (a, b) -> {
            if (a.getFail() == b.getFail())
                return a.getIndex() - b.getIndex();
            return Double.compare(b.getFail(), a.getFail());
        });
        
        for (int i = 0; i < fails.size(); i++) {
            answer[i] = fails.get(i).getIndex();
        }

        return answer;
    }

    class Fail {
        int index;
        double fail;

        public int getIndex() {
            return index;
        }

        public double getFail() {
            return fail;
        }

        public Fail(int index, double fail) {
            this.index = index;
            this.fail = fail;
        }
    }
}
