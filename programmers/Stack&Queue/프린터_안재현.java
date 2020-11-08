import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> task = new LinkedList<>();
        int cnt = 0;
        int num;
        int answer = 0;
        for(int i = 0 ; i < priorities.length ; i++)
            task.add(priorities[i]);
        while(true){
            if(task.size() == 1)
            {
                return answer+1;
            }
            if(location == 0){ // 로케이션이 0 이면
                num = task.poll();
                if(Collections.max(task) >num) {// 뒤에 더 큰수가 있으면
                    task.add(num);
                    location = task.size()-1;
                }
                else{ // 뒤에 더 큰수가 없으면
                    answer +=1;
                    break;
                }
            }
            else{
                num = task.poll();
                if(Collections.max(task) > num) // 뒤에 더 큰 수가 있으면
                {
                    task.add(num);
                    location -=1;
                }
                else // 뒤에 더 큰수가 없으면 작업큐에서 빼기
                {
                    location-=1;
                    answer++;
                }
            }
        }
        return answer;
    }
}