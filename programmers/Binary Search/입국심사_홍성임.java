import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = (long)times[times.length - 1] * n; // 60s

        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for(int time : times) {
                count += (long) mid / time;
            }
            if(count >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
