
class Solution {
    public int solution(int[] money) {
        int[][] pick = new int[2][money.length];
        // 첫번째를 들리는 경우와 아닌 경우 2가지 경우로 나눔.
        // index 0 은 첫번째 집을 들리는 경우
        // index 1 은 첫번째 집을 들리지 않는 경우
        pick[0][0] = money[0];
        pick[0][1] = money[0];

        pick[1][0] = 0;
        pick[1][1] = money[1];

        for(int i=2; i<money.length; i++) {
            pick[0][i] = Math.max(pick[0][i-2] + money[i], pick[0][i-1]);
            // index가 0일 때 2,3번째 값을 더해보고 더 큰 값을 저장
            pick[1][i] = Math.max(pick[1][i-2] + money[i], pick[1][i-1]);
        }

        return Math.max(pick[0][pick[0].length-2], pick[1][pick[1].length-1]);
    }

}
