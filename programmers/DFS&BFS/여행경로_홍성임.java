import java. util.*;

class Ticket {
    String from;
    String to;

    public Ticket(String from, String to) {
        this.from = from;
        this.to = to;
    }
}
class Solution {
    private static List<String> list;
    private static boolean[] visited;
    private static String route = "";

    public void dfs(String[][] tickets, int index, String to) {
        route = route + to + ",";

        if(index == tickets.length) {
            list.add(route);
            //route = "";
            return;
        } else {
            for(int i = 0; i < tickets.length; i++) {
                if(!visited[i] && to.equals(tickets[i][0])) {
                    visited[i] = true;
                    dfs(tickets, index + 1, tickets[i][1]);
                    visited[i] = false;
                    route = route.substring(0, route.length()-4);
                }
            }
        }
    }

    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs(tickets, 0, "ICN");
        list.sort(null);

        return list.get(0).split(",");
    }
}
