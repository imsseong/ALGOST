import java.util.*;

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int cost;
    Edge(int v1 , int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge e){
        if(this.cost < e.cost)
            return -1;
        else if(this.cost == e.cost)
            return 0;
        else
            return 1;
    }
}
class Solution {
    public int getParent(int parent[] , int x){
        if(parent[x] == x)  return x;
        return parent[x] = getParent(parent, parent[x]);
    }
    public void unionParent(int parent[] , int a,  int b){
        a = getParent(parent , a);
        b = getParent(parent , b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    public int findParent(int parent[] , int a , int b){
        a = getParent(parent , a);
        b = getParent(parent , b);
        if(a == b)  return 1;
        return 0;
    }
    public int solution(int n, int[][] costs) {
        //n 은 정점수, costs.size 는 edge 수
        int answer = 0;
        ArrayList<Edge> list = new ArrayList<Edge>();
        int edge_size = costs.length;
        int parent[] = new int[n];
        for(int i = 0 ; i < costs.length ; i++)
            list.add(new Edge(costs[i][0] , costs[i][1] , costs[i][2]));  // 리스트에 삽입
        Collections.sort(list);// cost 기준으로 소트
        // for(int i = 0 ; i < list.size() ; i++)
        //     System.out.println(list.get(i).cost);
        for(int i = 0 ; i < n ; i++)
            parent[i] = i;
        System.out.println(list.size());
        for(int i = 0 ; i < list.size() ; i++){
            //사이클이 발생하지 않는 경우
            if(findParent(parent , (list.get(i).v1 ) , (list.get(i).v2) )== 0){
                answer += list.get(i).cost;
                unionParent(parent , (list.get(i).v1 ) , (list.get(i).v2) );
            }
        }
        return answer;

    }
}
