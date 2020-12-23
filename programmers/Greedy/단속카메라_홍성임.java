import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = -30001;

        Arrays.sort(routes, (s1, s2) -> s1[1] - s2[1]);

        for(int[] route : routes) {
            if(camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }
}
