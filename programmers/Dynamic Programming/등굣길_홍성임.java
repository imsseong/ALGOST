import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] array = new int[n+1][m+1];

        for(int[] puddle : puddles) {
            array[puddle[1]][puddle[0]] = -1;
        }
        array[1][1] = 1;
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if(array[i][j] == -1) {
                    array[i][j] = 0;
                    continue;
                }
                if(i != 1) array[i][j] += array[i-1][j] % 1000000007;
                if(j != 1) array[i][j] += array[i][j-1] % 1000000007;
            }
        }
        return array[n][m] % 1000000007;
    }
}
