import java.util.*;
class Solution {
    class Pair{
        int cur;
        int index;
        Pair(int cur , int index){
            this.cur = cur;
            this.index = index;
        }
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(numbers[0] , 0));
        queue.offer(new Pair(-numbers[0] ,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.index == numbers.length - 1){
                if(p.cur == target)
                    answer ++;
                continue;
            }
            int n1 = p.cur + numbers[p.index+1];
            int n2 = p.cur - numbers[p.index+1];
            queue.offer(new Pair(n1 , p.index+1));
            queue.offer(new Pair(n2 , p.index+1));
        }

        return answer;
    }
}
