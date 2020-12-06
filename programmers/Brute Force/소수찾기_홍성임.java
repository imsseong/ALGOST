import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> numSet = new HashSet<>();
        makeNumbers("", numbers, numSet);
        System.out.println(numSet);
        long answer = numSet.stream().filter((s) -> {
            int count = 0;
            for(int i = 2; i < s; i++) {
                if(s % i == 0) {
                    count++;
                    break;
                }
            }
            return s > 1 && count == 0;
        }).count();
        return (int) (long) answer;
    }

    private static void makeNumbers(String prefix, String str, Set<Integer> numSet){
        int n = str.length();

        if(prefix.length() == 1) {
            numSet.add(Integer.parseInt(prefix));
        }

        if (n == 0) {
            numSet.add(Integer.parseInt(prefix));
        } else {
            for (int i = 0; i < n; i++) {
                makeNumbers(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1), numSet);
            }
        }
    }
}
