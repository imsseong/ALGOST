import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0; //섞은 횟수
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //최소힙

        for(int s : scoville) {
            minHeap.offer(s);
        }

        while(minHeap.peek() < K) {
            if(minHeap.size() < 2) { //스코빌 지수가 K보다 작은데 원소가 하나일 경우
                return -1;
            }
            count++;
            minHeap.offer(minHeap.poll() + (minHeap.poll() * 2));
        }

        return count;
    }

}
