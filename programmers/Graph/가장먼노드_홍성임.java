import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] distance = new int[n + 1]; //1번 노드와 다른 노드 사이의 거리
        boolean[][] visited = new boolean[n + 1][n + 1];

        //[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]
        for(int i = 0; i < edge.length; i++) {
            visited[edge[i][0]][edge[i][1]]  = true;
            visited[edge[i][1]][edge[i][0]]  = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        distance[1] = 0;

        int maxDistance = 0;

        while(!queue.isEmpty()) {
            int i = queue.poll();
            for(int j = 2; j <= n; j++) {
                if(distance[j] == 0 && visited[i][j]) { //[1][2] [1][3] [1][4] [1][5] [1][6]
                    distance[j] = distance[i] + 1;
                    maxDistance = (maxDistance > distance[j]) ? maxDistance : distance[j];
                    queue.offer(j);
                }
            }
        }
        final int max = maxDistance;
        return (int)Arrays.stream(distance).filter(s -> s == max).count();
    }
}
