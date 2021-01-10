import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		boolean check[] = new boolean[100001];      // 들렸는지를 확인해주는 변수
		int visit[] = new int[100001];              // 몇번 움직였는지를 확인하는 변수
		Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
		int j=0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(a);         // 초기값을 queue에 넣고
		check[a]=true;        // check 또한 true로
		while(!queue.isEmpty()) {
			int n = queue.size();        //queue에 있는 값들 전부를 연산할것임.
			for(int i=0;i<n;i++) {       //for문을 돌림 queue 크기만큼.
				int num = queue.poll();
				//System.out.println(num +" "+visit[num]);
				if(num == b) { //원하는 값을 찾으면 break
					a = b;
					break;
				}
				if(num+1<=100000 && !check[num+1]) {   // queue에 있는 값에 +1값이 이미 들린적이있나 확인.
					check[num+1]=true;
					visit[num+1]=visit[num]+1;
					queue.add(num+1);
				}
				else if(num+1<=100000 && check[num+1] && visit[num+1]>visit[num]+1) {
					visit[num+1]=visit[num]+1; // queue에 있는 값에 +1값이 이미 들린적이 있으나
				}                            // 덜 걸리는 경우를 찾을 경우
				if(num-1>=0 && !check[num-1]) {// queue에 있는 값에 -1값이 이미 들린적이있나 확인.
					check[num-1]=true;
					visit[num-1]=visit[num]+1;
					queue.add(num-1);
				}
				else if(num-1>=0 && check[num-1] && visit[num-1]>visit[num]+1) {
					visit[num-1]=visit[num]+1;// queue에 있는 값에 -1값이 이미 들린적이 있으나
				}														// 덜 걸리는 경우를 찾을 경우
				if(num*2<=100000 && !check[num*2]) {// queue에 있는 값에 x2값이 이미 들린적이있나 확인.
					check[num*2]=true;
					visit[num*2]=visit[num];
					queue.add(num*2);
				}
				else if(num*2<=100000 && check[num*2] && visit[num*2] > visit[num]) {
					visit[num*2]=visit[num];// queue에 있는 값에 x2값이 이미 들린적이 있으나
				}													// 덜 걸리는 경우를 찾을 경우
			}
			if(a==b) break;
			//System.out.println("_______________________");

		}
		System.out.println(visit[a]);
	}

}
