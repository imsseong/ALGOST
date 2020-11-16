import java.util.PriorityQueue;
class MyMap implements Comparable<MyMap>{
	int start;
	int runtime;
	boolean finish;
	MyMap(int start, int runtime){
		this.start = start;
		this.runtime = runtime;
		finish = false;
	}
	@Override
	public int compareTo(MyMap o) {
		return this.runtime >= o.runtime ? 1: -1;
	}
}
class Solution {
    public int solution(int[][] jobs) {
    	int answer = 0;
		int time = 0;
		MyMap obj = new MyMap(0, 0);
		var queue = new PriorityQueue<MyMap>();
		var wait = new PriorityQueue<MyMap>();
		for(int j[] : jobs) {
			queue.add(new MyMap(j[0], j[1]));
		}
		for(int i=0;i<jobs.length;i++) {
			int num = queue.size();
			for(int j=0;j<num;j++) {
				obj = queue.poll();
				if(obj.start<=time) break;
				else {
					wait.add(obj);
					obj = null;
				}
			}
			for(int j=0;j<wait.size();j++) {
				MyMap object = wait.poll();
				queue.add(object);
			}
			if(obj == null) {
				i--;
				time++;
				continue;
			}
			answer+=obj.runtime+time - obj.start;
			time+= obj.runtime;
		}
        return answer/jobs.length;
    }
}
