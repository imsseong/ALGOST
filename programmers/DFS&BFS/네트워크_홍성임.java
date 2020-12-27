import java.util.*;
import java.util.stream.*;

class Solution {
    public int dfs(int[][] computers, boolean[] visited, int i) {
        if(visited[i]) return 0;
        visited[i] = true;
        for(int j = 0; j < computers[i].length; j++) {
            if(computers[i][j] == 1) dfs(computers, visited, j);
        }
        return 1;

    }

    public int solution(int n, int[][] computers) {
        int test = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            test += dfs(computers, visited, i);
        }

        return test;
    }
}
