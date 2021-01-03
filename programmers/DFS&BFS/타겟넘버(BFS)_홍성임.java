import java.util.*;

class Solution {
    class Number {
        int number;
        int depth;

        public Number(int number, int depth) {
            this.number = number;
            this.depth = depth;
        }
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Number> queue = new LinkedList<>();
        queue.offer(new Number(numbers[0], 0)); // +1
        queue.offer(new Number(-numbers[0], 0)); // -1

        while(!queue.isEmpty()) {
            Number number = queue.poll();
            if(number.depth == numbers.length - 1) {
                if(number.number == target) answer++;
            } else {
                queue.offer(new Number(number.number + numbers[number.depth + 1], number.depth + 1)); // +1
                queue.offer(new Number(number.number - numbers[number.depth + 1], number.depth + 1)); // -1
            }
        }
        return answer;
    }
}
