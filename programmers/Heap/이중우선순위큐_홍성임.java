import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((q1, q2) -> q1.compareTo(q2));
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((q2, q1) -> q1.compareTo(q2));

        for(String operation : operations) {
          if(operation.contains("I")) {
            minQueue.offer(Integer.parseInt(operation.split(" ")[1]));
            maxQueue.offer(Integer.parseInt(operation.split(" ")[1]));
          }
          if(minQueue.size() > 0) {
            if(operation.contains("D -1")) {
              int minNum = minQueue.poll();
              maxQueue.remove(minNum);
            } else if(operation.contains("D 1")) {
                int maxNum = maxQueue.poll();
                minQueue.remove(maxNum);
            }
          }
        }

        if(!minQueue.isEmpty()) {
          answer[0] = maxQueue.poll();
          answer[1] = minQueue.poll();
        }
        
        return answer;
    }
}
