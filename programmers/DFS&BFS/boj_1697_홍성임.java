import java.util.*;

public class Main {
    private static boolean[] visited = new boolean[100001];
    private static int[] time = new int[100001];
    private static int[] move = {1, -1, 2};

    private static void solution () {
          Scanner sc = new Scanner(System.in);

          Integer N = sc.nextInt();
          Integer K = sc.nextInt();

          if(N == K) {
              System.out.println(0);
          } else {
              bfs(N, K);
          }
    }

    public static void bfs(Integer N, Integer K) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(N);
        visited[N] = true;
        time[N] = 0;
        while(!queue.isEmpty()) {
            int num = queue.poll();

            for(int i = 0; i < 3; i++) {
                int next;
                if(i == 2) {
                    next = num * move[i];
                } else {
                    next = num + move[i];
                }

                if(next <= 100000 && -1 < next && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    time[next] = time[num] + 1;
                }
                if(next == K) {
                    break;
                }
            }
        }
        System.out.println(time[K]);
    }

    public static void main(String[] args) {
        solution();
    }
}
