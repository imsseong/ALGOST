import java.util.*;
class Solution {
  public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (n1,n2) -> {
            return n1[0]-n2[0]; // 오름차순 정렬
        });
        int camera = routes[0][1];
        for(int i=0; i<routes.length; i++) {
            if(routes[i][1] < camera)
                camera = routes[i][1]; // [-20,-15],[-18,-16]
            if(routes[i][0] > camera) {
                camera = routes[i][1]; // [-20,-15],[-14,3]
                answer++;
            }
        }
        return answer;
    }
}
