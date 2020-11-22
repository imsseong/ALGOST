import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int[] tmp;
        answer = new int[commands.length];
        for(int l = 0 ; l < commands.length ; l++){
            int i =commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            tmp = new int[j-i+1];
            for(int g = 0 ; g < j-i+1 ; g++)
                tmp[g] = array[i-1+g];
            Arrays.sort(tmp);
            answer[l] = tmp[k-1];
        }
        return answer;
    }
}
