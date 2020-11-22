import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        List<Integer> numList = new ArrayList<>();

        for(int[] command : commands) {
          if(command[0] == command[1]) {
            answer[index] = array[command[0]-1];
          } else {
            numList = Arrays.stream(array, command[0]-1, command[1]).sorted().boxed().collect(Collectors.toList());
            answer[index] = numList.get(command[2]-1);
          }
          index++;
        }

        return answer;
    }
}
