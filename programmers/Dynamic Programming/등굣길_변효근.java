class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int route[][]= new int[n][m];
        // m x n 배열을 생성
        for(int i[] : puddles) {
        	int x = i[0];
        	int y = i[1];
        	route[y-1][x-1] = -1;
          // puddles는 웅덩이므로 못감
          // 못가는 곳은 -1로 고정시킴.
        }
        for(int i=0;i<n;i++) {
        	if(route[i][0]==-1) break;    //집에서 가는 길의 경우의 수를 배열에 저장함.
         	route[i][0]=1;                //집과 같은 열과 행의 길들은 무조건 경우의 수가 1임.
        }
        for(int j=0;j<m;j++) {
        	if(route[0][j]==-1) break;
        	route[0][j]=1;
        }

        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		if(i==0 || j==0 || route[i][j]==-1) continue;
            // 이미 위에서 첫행과 첫열의 값들은 1로 고정시켜두었음.
            // 그리고 route == -1 이라는 것은 웅덩이 이므로 continue
        		if(route[i-1][j]!=-1)  route[i][j]+=route[i-1][j];
            // 특정 위치의 경우의 수는 전에 갈 수 있는 경우의 수의 합과 같음
            // 즉 (2,2)는 (1,2)와 (2,1)의 합이라 할 수 있음.
        		if(route[i][j-1]!=-1)  route[i][j]+=route[i][j-1];
        	  route[i][j]%=1000000007;
            }
        }
        return answer = route[n-1][m-1];
    }
}
