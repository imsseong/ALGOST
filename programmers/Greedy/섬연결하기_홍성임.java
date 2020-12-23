import java.util.*;
import java.util.stream.*;

class Island {
    Integer from;
    Integer to;
    Integer cost;

    public Island(Integer from, Integer to, Integer cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class Solution {
    public int findFrom(int[] visited, int to) {
        if(visited[to] == to) return to;
        else return findFrom(visited, visited[to]);
    }

    public int solution(int n, int[][] costs) {
        List<Island> islandList = new ArrayList<>();
        for(int[] cost : costs) {
            islandList.add(new Island(cost[0], cost[1], cost[2]));
        }

        islandList.sort((s1, s2) -> s1.cost - s2.cost);

        int[] visited = new int[n];
        for(int i = 0; i < n; i++) {
            visited[i] = i;
        }

        int answer = 0;
        int count = 0;
        for(Island island : islandList) {
            int from = findFrom(visited, island.from);
            int to = findFrom(visited, island.to);
            if(from != to) {
                visited[to] = visited[from];
                answer += island.cost;
            }
        }
        return answer;
    }
}
