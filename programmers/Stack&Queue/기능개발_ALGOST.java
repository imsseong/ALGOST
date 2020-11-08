import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int answer[] = {};
        for(int i = 0 ; i < progresses.length ; i++)
        {
            days.add((int)Math.ceil((100-progresses[i])/(float)speeds[i]));
        }
        int day = days.poll();
        int cnt = 1;
        while(!days.isEmpty()){
            int day2 = days.poll();
            if(day >= day2){
                cnt++;
            }
            else{
                result.add(cnt);
                cnt = 1;
                day = day2;
            }
            
        }
        result.add(cnt);
        answer = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++)
            answer[i] = result.get(i);
        return answer;
    }
}