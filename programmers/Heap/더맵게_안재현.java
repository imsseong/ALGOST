import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scoville_queue = new PriorityQueue(); // 최소힙 만들기
        for(int s : scoville){
            scoville_queue.add(s);
        }
        while(scoville_queue.peek() <= K){
            if(scoville_queue.size() == 1)
                return -1;
            int scoville1=scoville_queue.poll();
            int scoville2 = scoville_queue.poll();
            scoville_queue.add(scoville1 + (scoville2*2));
            answer += 1;
        }
        return answer;
    }
}
