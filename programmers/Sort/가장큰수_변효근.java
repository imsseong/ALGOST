import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>         () {
              // 저장할 우선순위큐
              @Override
	            public int compare(String s1, String s2) {
	                return Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2);
                  // 비교하는 두 스트링을 더한다음에 비교해봄
                  // 3,30을 예로 들자면 330 > 303이므로
                  // 직접 330과 303을 비교하여 더 큰값을 우선순위로하여 저장.
	            }
	    });
			for(int i : numbers) {
				pq.offer(String.valueOf(i));
        //주어지는 값은 integer형이므로 String값으로 바꾸어 삽입.
			}
			int n = pq.size();
			for(int i=0;i<n;i++) {
				answer+=pq.poll();
        //이미 우선순위로 정렬되어있어 그냥 concat해주기만 하면 됨.
			}
          return answer;
    }
}
