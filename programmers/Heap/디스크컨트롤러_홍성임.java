import java.util.*;

class Job {
    int startTime;
    int processTime;
    
    public Job(int startTime, int processTime) {
        this.startTime = startTime;
        this.processTime = processTime;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        List<Job> jobList = new ArrayList<>();
        for(int[] job : jobs) {
            jobList.add(new Job(job[0], job[1]));
        }
        jobList.sort((s1, s2) -> s1.processTime - s2.processTime);
        
        int time = 0; // 현재 시간
        int sum = 0; // 총 작업 시간
        
        while(jobList.size() > 0) {
            // 시작 시간이 현재 시간보다 이전일 경우 
            for(int i = 0; i < jobList.size(); i++) {
                if(time >=jobList.get(i).startTime) {
                    time += jobList.get(i).processTime;
                    sum += time - jobList.get(i).startTime; // 총 작업 시간에 소요된 시간 = 현재 시간 - 요청 시작 시간
                    jobList.remove(i);
                    break;
                }
                //리스트 탐색 후 작업 요청 할 수 없다면 현재 시간 1초 증가
                if(i == jobList.size() - 1) time++;
            }
        }
        
        return sum / jobs.length;
    }
}
