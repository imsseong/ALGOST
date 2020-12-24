import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
    int answer = n - lost.length;

	for(int i=0;i<lost.length;i++) {
		for(int j=0;j<reserve.length;j++) {
			if(lost[i]>0 && lost[i] == reserve[j]) {
				lost[i]= -10;
				reserve[j]= -10;
                answer++;
			}
		}
	}


	for(int person : lost) {
        if(person<0) continue;
	    for(int j=0;j<reserve.length;j++) {
	    	if(reserve[j]<0) continue;
	    	if(person-1 == reserve[j] || person+1 ==reserve[j]) {
	    			reserve[j]=-10;
	    			answer++;
	    			break;
            }
	    	}
	    }
        return answer;
    }
}
