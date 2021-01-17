import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        int num = 10000000;
        Set<Integer> primeSet = new HashSet<>(); //모든 소수
        Set<Integer> numSet = new HashSet<>(); //numbers로 만들 수 있는 모든 수
        boolean check[] = new boolean[10000001];
        check[0] = check[1] = true;

        for(int i = 2; i < num; i++) {
            if(check[i]) continue;
            primeSet.add(i);
            for(int j = 2; i*j <= num; j++) {
                check[i * j] = true;
          }
        }

        makeNumbers("", numbers, numSet);

        while(numSet.iterator().hasNext()) {
            int n = (int)numSet.iterator().next();
            numSet.remove(n);
          if(primeSet.contains(n)) {
              answer++;
          }

        }
        return answer;
    }

    private static void makeNumbers(String prefix, String str, Set<Integer> set){
        int n = str.length();
        if(!prefix.equals("")) {
           set.add(Integer.valueOf(prefix));
        }

        for (int i = 0; i < n; i++){
          makeNumbers(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }
    }
}
