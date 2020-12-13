import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] count = new int[n];

        for(int i = 0; i < count.length; i++) count[i] = 1;
        for(int i = 0; i < lost.length; i++) count[lost[i]-1]--;
        for(int i = 0; i < reserve.length; i++) count[reserve[i]-1]++;

       return Arrays.stream(count).boxed().map(s -> String.valueOf(s)).collect(Collectors.joining())
           .replaceAll("02", "11")
           .replaceAll("20", "11")
           .replaceAll("0", "")
           .length();
    }
}
