import java.util.HashSet;
class Solution {
    public static int[] dfs(int visit[],int parent, int child ,int[][] computers) {
		for(int i=0;i<computers[child].length;i++) {
			if(i!=child && computers[child][i]==1) {
				computers[child][i]=0;
				visit[i]=parent;
				dfs(visit,parent,i,computers);
			}
		}
		return visit;
	}
	public static int solution(int n, int[][] computers) {
	        int answer = 0;
	        int visit[] = new int [n];
	        for(int i=0;i<n;i++) visit[i]=i;
	        for(int i=0;i<n;i++) {
	        	if(visit[i]==i){
	        		visit = dfs(visit,i,i,computers);
	        	}
	        }
	        HashSet map = new HashSet<>();
	        for(int i=0;i<n;i++)
	        	map.add(visit[i]);
	        return answer=map.size();
	    }
}
