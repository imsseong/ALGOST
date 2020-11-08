import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> days = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            queue.add((int)Math.ceil((100 - progresses[i]) / (float)speeds[i]));
        }

        int day = queue.poll();
        int count = 1;

        while(!queue.isEmpty()) {
            int num = queue.poll();
            if(num <= day) {
                count++;
            } else {
                days.add(count);
                count = 1;
                day = num;
            }
        }

        days.add(count);

        int[] answer = new int[days.size()];

        for(int i = 0; i < days.size(); i++) {
            answer[i] = days.get(i);
        }
        return answer;
    }
}
