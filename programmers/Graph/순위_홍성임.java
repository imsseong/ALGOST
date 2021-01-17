import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int n, int[][] results) {
        Map<Integer, Set<Integer>> winnerMap = new HashMap<>(); //나를 이긴 사람
        Map<Integer, Set<Integer>> loserMap = new HashMap<>(); //나에게 진 사람
        for(int i = 1; i <= n; i++) {
            winnerMap.put(i, new HashSet<>());
            loserMap.put(i, new HashSet<>());
        }
        for(int i = 1; i <= n; i++) {
            for(int[] result : results) {
                if(result[0] == i) { //승리자
                    Set<Integer> set = loserMap.get(i);
                    set.add(result[1]);
                    loserMap.put(i, set); //i에게 진 사람
                }
                if(result[1] == i) { //패배자
                    Set<Integer> set = winnerMap.get(i);
                    set.add(result[0]);
                    winnerMap.put(i, set); //i를 이긴 사람
                }
            }
            for(Integer loser : loserMap.get(i)) { //i에게 진 사람
                //3번에게 진 사람은 3번에게 이긴 사람한테도 졌다
                //3번에게 이긴 사람은 3번에게 진 사람한테도 이겼음
                Set<Integer> set = winnerMap.get(loser);
                set.addAll(winnerMap.get(i)); // 4, 5
                winnerMap.put(loser, set);

            }

            for(Integer winner : winnerMap.get(i)) { //i를 이긴 사람
                Set<Integer> set = loserMap.get(winner);
                set.addAll(loserMap.get(i));
                loserMap.put(winner, set);
            }

        }
        Integer count = 0;
        for(int i = 1; i <= n; i++) {
            if(winnerMap.get(i).size() + loserMap.get(i).size() == n-1) {
                count++;
            }
        }
        return count;

    }
}
