import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int index = people.length - 1;
        for(int i = 0; i <= index; i++) {
            while(index > i && people[i] + people[index--] > limit) {
                answer++;
            }
            answer++;
        }

        return answer;
    }
}
