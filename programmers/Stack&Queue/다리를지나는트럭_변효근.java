class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
		int head = 0,tail = 0;
		int answer =0;
	    int total = 0;
	    int [] time = new int [truck_weights.length];
	    for(int i=0;i<truck_weights.length;i++)
	    	time[i]= bridge_length;

	    while(true) {
	    	if(head!=0 && head == tail) break;
	    	if(head<truck_weights.length && time[head]==0)
	    		total -= truck_weights[head++];
	    	if(tail<truck_weights.length && total < weight && total+truck_weights[tail]<=weight) {
	    		total += truck_weights[tail++];
	    	}
	    	for(int i = head;i<tail;i++)
	    		time[i]--;

	    	answer++;
	    }
        return answer;
    }
}
