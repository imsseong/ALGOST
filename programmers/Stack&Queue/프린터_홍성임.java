import java.util.*;

class Solution {
    class Docs {
        int priority, location;

        public Docs(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Docs> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new Docs(priorities[i], i));
        }

        while(!queue.isEmpty()) {
            boolean flag = false;
            int prio = queue.peek().priority;
            for (Docs d : queue) {
				if (prio < d.priority) {
					flag = true;
				}
			}

			if (flag) {
				queue.offer(queue.poll());
			} else {
				if (queue.poll().location == location) {
					answer = priorities.length - queue.size();
				}
			}
        }

        return answer;
    }
}
