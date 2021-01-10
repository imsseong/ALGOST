import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		boolean visit[] = new boolean[100001];     // 들렸는지를 체크해주는 변수
		Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>(); //bfs를 위한 queue
		int cnt = 0;
		queue.add(a);  //초기값을 넣어주고
		visit[a]=true; //초기값 visit 또한 true로
		while(!queue.isEmpty()) {
			int n = queue.size();   //queue size만큼 for문을 돌릴 것임.
			for(int i=0;i<n;i++) {
				int num = queue.poll();
				//System.out.println(num);
				if(num == b) {  // 원하는 값을 찾으면 break
					a = b;
					break;
				}																			// +1 -1 x2 경우들의
				if(num+1<=100000 && !visit[num+1]) {  //visit을 확인하고 false일 경우
					visit[num+1]=true;                  //queue에 넣어줌.
					queue.add(num+1);
				}
				if(num-1>=0 && !visit[num-1]) {
					visit[num-1]=true;
					queue.add(num-1);
				}
				if(num*2<=100000 && !visit[num*2]) {
					visit[num*2]=true;
					queue.add(num*2);
				}
			}
			if(a==b) break;
			cnt++; // cnt는 움직인 횟수 즉 answer을 측정하기위해 while문마다 +1씩

			//System.out.println("_______________________");

		}
		System.out.println(cnt);
	}
}
//6 16 3
//8 20 3
//15964 89498 4781
//5 35 5
