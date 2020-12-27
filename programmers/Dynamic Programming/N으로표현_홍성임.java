import java.util.*;

class Solution {
    static Integer _N;
    static List<Integer>[] dp;

    public List<Integer> dp(int n) {
        if(dp[n] != null) return dp[n];
        dp[n] = new ArrayList<>();
        dp[n].add(dp[n-1].get(0) * 10 + _N);

        for(int i = 1; i < n; i++) {
            for(int n1 : dp(i)) {
                for(int n2 : dp(n-i)) {
                    dp[n].add(n1 + n2);
                    dp[n].add(n1 - n2);
                    dp[n].add(n1 * n2);
                    if(n2 != 0) dp[n].add(n1 / n2);
                }
            }
        }
        return dp[n];
    }

    public int solution(int N, int number) {
        _N = N;
        dp = new ArrayList[9];
        dp[0] = new ArrayList<>(Arrays.asList(0));

        for(int i = 1; i < 9; i++) {
            dp(i);
            if(dp[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
