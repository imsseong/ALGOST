class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        for(int i = 0 ; i < n ; i++)
            visit[i] = false; // init 초기화
        //1 - 2    3 -4
        for(int i = 0 ; i < n ; i++){
            if(visit[i] == false){
                dfs(visit , i , computers);
                answer ++;
            }

        }
        return answer;
    }
    public void dfs(boolean[] visit ,int i,  int[][]computers){
        visit[i] = true;
        for(int j = 0 ; j < computers.length ; j++){
            if((i != j) && (computers[i][j] == 1) && visit[j] == false)
                dfs(visit , j , computers);
        }
    }
}
