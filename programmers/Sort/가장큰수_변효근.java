import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>         () {
	            @Override
	            public int compare(String s1, String s2) {
	                return Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2);
	            }
	    });
			for(int i : numbers) {
				pq.offer(String.valueOf(i));
			}
			int n = pq.size();
			for(int i=0;i<n;i++) {
				answer+=pq.poll();
			}
          return answer;
    }
}
