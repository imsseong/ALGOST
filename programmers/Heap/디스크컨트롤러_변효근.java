import java.util.PriorityQueue;
class MyMap implements Comparable<MyMap>{	//디스크의 정보를 저장하는 클래스
	int start;		// 시작시간
	int runtime;	// 처리시간
	boolean finish;
	MyMap(int start, int runtime){
		this.start = start;
		this.runtime = runtime;
		finish = false;
	}
	@Override
	public int compareTo(MyMap o) {
		return this.runtime >= o.runtime ? 1: -1;
		// 처리시간으로 오름차순함.
		// 이 문제의 키포인트는
		// 대기큐에 있는 프로세스 중
		// 처리시간이 가장 적은 순으로
		// 실행시키는 것임.
	}
}
class Solution {
    public int solution(int[][] jobs) {
    int answer = 0;
		int time = 0;
		MyMap obj = new MyMap(0, 0);
		var queue = new PriorityQueue<MyMap>();
		// 모든 디스크들을 처리시간 오름순으로 저장함.
		var wait = new PriorityQueue<MyMap>();
		// 비교 후 다시 저장을 위한 우선순위큐
		for(int j[] : jobs) {
			queue.add(new MyMap(j[0], j[1]));
			// 모든 디스크들을 처리시간 오름순으로 저장함.
		}
		for(int i=0;i<jobs.length;i++) {
			int num = queue.size();
			for(int j=0;j<num;j++) {
				obj = queue.poll(); // 맨 처음 값을 가져옴.
				if(obj.start<=time) break;
				// 처리시간 순으로 정렬을 했으므로
				// 처리시간이 작지만, 시작시간이
				// 아직 안됬을 수 있음.
				// 만약 시작시간이 되는 경우
				else {
					wait.add(obj);
					obj = null;
					// 처리시간 순으로 정렬을 했으므로
					// 처리시간이 작지만, 시작시간이
					// 아직 안됬을 수 있음.
					// 만약 시작시간이 안됬을 경우 그 값을 wait이라는
					// 우선 순위 큐에 저장 후에 다시 queue에 집어넣을 거임.
				}
			}
			for(int j=0;j<wait.size();j++) {
				MyMap object = wait.poll();
				queue.add(object);
				// 위에서 말한 거 처럼 다시 값을 queue에 집어넣음.
			}
			if(obj == null) {
				i--;
				time++;
				// 만약 아직 시작시간이 안되는 경우
				// time을 추가시킴.
				continue;
			}
			answer+=obj.runtime+time - obj.start;
			time+= obj.runtime;
		}
        return answer/jobs.length;
    }
}
