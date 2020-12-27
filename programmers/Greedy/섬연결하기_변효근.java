import java.util.*;
import java.util.stream.*;

class Island {
    Integer v1;
    Integer v2;
    Integer dist;

    public Island(Integer v1, Integer v2, Integer dist) {
        this.v1 = v1;
        this.v2 = v2;
        this.dist = dist;
    }
}

class Solution {
    public int findv1(int[] visited, int v2) {
        if(visited[v2] == v2) return v2;
        else return findv1(visited, visited[v2]);
    }

    public int solution(int n, int[][] dists) {
        List<Island> islandList = new ArrayList<>();
        for(int[] dist : dists) {
            islandList.add(new Island(dist[0], dist[1], dist[2]));
        }

        islandList.sort((s1, s2) -> s1.dist - s2.dist);

        int[] visited = new int[n];
        for(int i = 0; i < n; i++) {
            visited[i] = i;
        }

        int answer = 0;
        int count = 0;
        for(Island island : islandList) {
            int v1 = findv1(visited, island.v1);
            int v2 = findv1(visited, island.v2);
            if(v1 != v2) {
                visited[v2] = visited[v1];
                answer += island.dist;
            }
        }
        return answer;
    }
}
