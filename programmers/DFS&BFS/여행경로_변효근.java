import java.util.ArrayList;

public class Solution {
	static ArrayList<String> list = new ArrayList<String>();
	static String route = "";
	public static int check(boolean [] visit) {
		int num = 0;
		for(int i=0;i<visit.length;i++) {
			if(visit[i]==true) {
				num+=1;
			}
		}
		return num;
	}
	public static void dfs(String[][] tickets,boolean [] visit,int index) {
		int num = check(visit);
		for(int i=0;i<tickets.length;i++) {
			if(!visit[i] && tickets[index][1]==tickets[i][0]) {
				if(num==tickets.length-1) {
					route += " "+tickets[i][0] +" "+ tickets[i][1];
					list.add(route);
					return;
				}
				String r = route;
				route += " "+tickets[i][0];
				visit[i] = true;
				dfs(tickets,visit,i);
				visit[i] = false;
				route = r;
			}
		}
		return;
	}
	public static String[] solution(String[][] tickets) {
	        String[] answer = new String[tickets.length+1];
	        boolean visit[] = new boolean [tickets.length];

	        for(int i=0;i<tickets.length;i++) {
	        	route = tickets[i][0];
	        	visit[i]=true;
	        	dfs(tickets,visit,i);
	        	visit[i]=false;
	        }
	        String a = "a";
	        for(String arr: list) {
	        		if(a.compareTo(arr)>0) a = arr;
	        }
	        System.out.println(a);
	        for(int i=0;i<=tickets.length;i++) {
	        	answer[i] = a.substring(4*i,4*(i+1)-1);
	        	System.out.println(answer[i]);
	        }
	        return answer;
	}
	public static void main(String [] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets1 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		System.out.println(solution(tickets1));
	}
}
