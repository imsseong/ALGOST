import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (num1, num2) -> {
			return Integer.compare(num1[0], num2[0]);
        });
        int tmp = routes[0][1]; // 첫번째 차
        for(int i = 1 ; i < routes.length-1 ; i++){
            if(tmp > routes[i][1]){
                tmp = routes[i][1];
            }
            if(tmp < routes[i+1][0]){
                answer += 1;
                tmp = routes[i+1][1];
            }
        }
        return answer + 1;
    }
}
