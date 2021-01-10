import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        long answer = 0;
        long left = 1;
        long right = distance;

        while(left <= right) {
            long mid = (left + right) / 2; // 13 - 6 5 4\\

            int removeCount = 0;
            int prev = 0;

            for(int rock : rocks) {
                if(rock - prev < mid) {
                    removeCount++; //2 14
                } else {
                    prev = rock; //11 17 21
                }
            }

            if(distance - prev < mid) {
                removeCount++;
            }

            if(removeCount <= n) {
                left = mid + 1;
                answer = (mid > answer) ? mid : answer;
            } else {
                right = mid - 1; //12
            }
        }
        return (int)answer;
    }
}
