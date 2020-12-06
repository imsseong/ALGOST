import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> person1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> person2 = Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5);
        List<Integer> person3 = Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);

        int[] answer = new int[3];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == person1.get(i%5)) answer[0]++;
            if(answers[i] == person2.get(i%8)) answer[1]++;
            if(answers[i] == person3.get(i%10)) answer[2]++;
        }
        Integer maxNum = Arrays.stream(answer).max().getAsInt();
        return IntStream.range(1, answer.length+1).filter(i -> answer[i-1] == maxNum).toArray();
    }
}
